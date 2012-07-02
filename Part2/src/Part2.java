
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
			System.out.print("buy or sell: ");
			input = getUserEntry().toLowerCase();
		}
		while (!input.equals("buy") && !input.equals("sell"));
		
		return input.equals("buy") ? true : false;
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
		
		rentalCompanyA.printVehicles(VehicleType.All);
		System.out.println();
		dealership.printVehicles(VehicleType.All);
		
		while (true) {
			firstCompany = selectCompany( ! showDealership);
			if (firstCompany == null) { break; }
			System.out.println(firstCompany.name());
			secondCompany = selectCompany(showDealership);
			if (secondCompany == null) { break; }
			System.out.println(secondCompany.name());
			isBuying = selectBuyOrSell();
			System.out.println("buying: " + isBuying);
			// select vehicle
			// complete transaction if possible
		}
		System.out.println("End.");
	}

}
