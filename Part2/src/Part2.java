/**
 * Main driver/user interface for vehicle buying/selling application
 */
import java.util.Scanner;

import vehicle.*;
import part2.company.*;

/**
 * @author Mark Redden
 *
 */
public class Part2 {
	/*
	 * Members
	 */
	static CompanyBuySell dealership;
	static CompanyBuySell rentalCompanyA;
	static CompanyBuySell rentalCompanyB;
	
	static final boolean showDealership = true;
	static CompanyBuySell firstCompany;
	static CompanyBuySell secondCompany;
	static boolean isBuying;
	static Vehicle theVehicle;
	/**
	 * @param args
	 */
	
	// Helper method for user input
	public static String getUserEntry() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	// Select and return company, optionally listing dealership
	public static CompanyBuySell selectCompany(boolean i_listDealership) {
		String input;
		System.out.println("company to work with:");
		System.out.println("A. Company A");
		System.out.println("B. Company B");
		if (i_listDealership) {
			System.out.println("C. Dealership");
		}
		System.out.println("X. Quit");
		input = getUserEntry().toUpperCase();
		while ((!i_listDealership && !input.equals("A") && !input.equals("B") && !input
				.equals("X"))
				|| (i_listDealership && !input.equals("A")
						&& !input.equals("B") && !input.equals("C") && !input
							.equals("X")))
		{
			System.out.println("Selection not valid, please choose again.");
			input = getUserEntry().toUpperCase();
		}

		return input.equals("A") ? rentalCompanyA
				: input.equals("B") ? rentalCompanyB
						: input.equals("C") ? dealership : null;
	}
	
	// Choose whether first company is buying or selling
	public static boolean selectBuyOrSell() {
		String input;
		do
		{
			System.out.println();
			System.out.print("buy or sell: ");
			input = getUserEntry().toLowerCase();
		}
		while (!input.equals("buy") && !input.equals("sell"));
		
		return input.equals("buy") ? true : false;
	}
	
	// Display all vehicles for specified company
	public static void printFleet(CompanyBuySell i_company) {
		System.out.println(i_company.name() + "'s fleet:  (funds: " + i_company.getBankBalance() + ")");
		i_company.printVehicles(VehicleType.All);	
	}
	
	// Summary of what is to take place
	public static void printSummary() {
		System.out.println();
		System.out.print(firstCompany.name());
		System.out.print( isBuying ? " buying from " : " selling to " );
		System.out.println(secondCompany.name());
		
		if (isBuying) {
			System.out.println(firstCompany.name() + " funds: " + firstCompany.getBankBalance());
		}
		else {
			System.out.println(secondCompany.name() + " funds: " + secondCompany.getBankBalance());
		}
	}
	
	// Select and return vehicle choice
	public static Vehicle selectVehicle() {
		System.out.println();
		if (isBuying) {
			printFleet(secondCompany);
			System.out.print(" - enter ID of vehicle to buy (or 'none'): ");
			return secondCompany.getVehicleByID(getUserEntry());
		}
		else
		{
			printFleet(firstCompany);
			System.out.print(" - enter ID of vehicle to sell (or 'none'): ");
			return firstCompany.getVehicleByID(getUserEntry());
		}
	}
	
	// Carry out the transfer of vehicle
	public static void performTransaction() {
		CompanyBuySell buyer, seller;
		if (isBuying) {
			buyer = firstCompany;
			seller = secondCompany;
		}
		else {
			buyer = secondCompany;
			seller = firstCompany;
		}
		if (buyer.ableToBuy(theVehicle)) {
			seller.sellVehicle(theVehicle);
			buyer.buyVehicle(theVehicle);
			System.out.println();
			printFleet(firstCompany);
			System.out.println();
			printFleet(secondCompany);
		}
		else {
			System.out.println("\n" + "There was a problem, transaction not performed...");
			System.out.println("Cause is either insufficient funds or fleet at maximum for that type.");
		}
	}

	public static void main(String[] args) {
		// Setup files
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String projectPath = System.getProperty("user.dir");
		String vehicleListA = drive + projectPath + "/part2/part2vehiclesA.txt";
		String vehicleListDealer = drive + projectPath + "/part2/part2vehiclesDealer.txt";
		
		// Setup companies
		rentalCompanyA = new CompanyBuySell(vehicleListA, 10);
		rentalCompanyA.setName("Company A");
		rentalCompanyA.setBankBalance(30000);
		rentalCompanyB = new CompanyBuySell("", 10);
		rentalCompanyB.setName("Company B");
		rentalCompanyB.setBankBalance(500000);
		dealership = new CompanyBuySell(vehicleListDealer, 100);
		dealership.setName("Dealership");
		dealership.setBankBalance(20000);
		
		// Main interface loop
		while (true) {
			System.out.print("\n" + "Choose first ");
			firstCompany = selectCompany( ! showDealership);
			if (firstCompany == null) { break; }
			System.out.print("\n" + "Choose second ");
			secondCompany = selectCompany(showDealership);
			if (secondCompany == null) { break; }
			isBuying = selectBuyOrSell();
			printSummary();
			theVehicle = selectVehicle();
			if (theVehicle != null) {
				performTransaction();
			}
			else
			{
				System.out.println("\n" + "No action taken.");
			}
		}
		System.out.println("End.");
	}

}
