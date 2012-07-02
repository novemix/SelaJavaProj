
import java.io.File;
import java.util.Scanner;

import vehicle.*;
import part2.company.*;

public class Part2 {

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
	public static String getUserEntry() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static CompanyBuySell selectCompany(boolean i_listDealership) {
		String input;
		System.out.println();
		System.out.println("Select company to work with:");
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
	
	public static void printFleet(CompanyBuySell i_company) {
		System.out.println(i_company.name() + "'s fleet:");
		i_company.printVehicles(VehicleType.All);	
	}
	
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
		if (buyer.buyVehicle(theVehicle)) {
			seller.sellVehicle(theVehicle);
			System.out.println();
			printFleet(firstCompany);
			System.out.println();
			printFleet(secondCompany);
		}
		else {
			System.out.println("There was a problem, transaction not performed...");
			System.out.println("Most likely causes are insufficient funds or fleet at maximum for that type.");
		}
	}

	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0,6).equals("Windows") ? "C:" : "";
		String vehicleListDealer = drive + "/JavaProj/part2vehiclesDealer.txt";
		String vehicleListA = drive + "/JavaProj/part2vehiclesA.txt";
		
		dealership = new CompanyBuySell(vehicleListDealer, 100);
		dealership.setName("Dealership");
		rentalCompanyA = new CompanyBuySell(vehicleListA, 10);
		rentalCompanyA.setName("Company A");
		rentalCompanyB = new CompanyBuySell("", 10);
		rentalCompanyB.setName("Company B");
		rentalCompanyB.setBankBalance(500000);
		
		while (true) {
			firstCompany = selectCompany( ! showDealership);
			if (firstCompany == null) { break; }
			secondCompany = selectCompany(showDealership);
			if (secondCompany == null) { break; }
			isBuying = selectBuyOrSell();
			System.out.println("\n" + firstCompany.name() + ( isBuying ? " buying from " : " selling to " ) + secondCompany.name());
			theVehicle = selectVehicle();
			if (theVehicle != null) {
				performTransaction();
			}
		}
		System.out.println("End.");
	}

}
