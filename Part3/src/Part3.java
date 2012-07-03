/**
 * 
 */

import java.util.Scanner;

import part3.company.Company;
import part3.customer.Customer;
import part3.vehicle.VehicleType;
/**
 * @author Administrator
 *
 */
public class Part3 {
	
	static Company avis;
	static Company hertz;
	
	static String getUserEntry() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	} // getUserEntry
	
	static String welcomeMenu() {
		String input;
		do
		{
			System.out.println("\n" + "Rental Cars Service" + "\n-------------------");
			System.out.println("Please select desired option:");
			System.out.println("  1. Rent a car from list of available cars");
			System.out.println("  2. Return a car");
			System.out.println("  3. Advanced options");
			System.out.println("  4. Quit");
			System.out.print("Choice: ");
			input = getUserEntry();
		} while (!input.equals("1") && !input.equals("2") && !input.equals("3")
				&& !input.equals("4"));
		return input.equals("1") ? "rent" : input.equals("2") ? "return"
				: input.equals("3") ? "advanced" : "quit";
	} // welcomeMenu
	
	static Company selectCompany() {
		String input;
		do {
			System.out.println("\n" + "Select company:");
			System.out.println("  1. Avis");
			System.out.println("  2. Hertz");
			System.out.print("Choice: ");
			input = getUserEntry();
		} while (!input.equals("1") && !input.equals("2"));
		return input.equals("1") ? avis : hertz;
	}
	
	static void rentVehicle(Company i_company) {
		System.out.println("Rent car from " + i_company);
	}
	
	static void returnVehicle(Company i_company) {
		String input;
		Customer customer;
		do {
			System.out.print("\n" + "Customer name (or 'none'): ");
			input = getUserEntry();
			customer = i_company.getCustomerByName(input);
			if (!input.equals("none") && customer == null) {
				System.out.println("Customer not found.");
			}
		} while (!input.equals("none") && customer == null );
		if (!input.equals("none")) {
			i_company.returnCustomerVehicle(customer);
		}
	}
	
	static String advancedMenu() {
		String input;
		do
		{
			System.out.println("\n" + "Advanced Menu" + "\n-------------");
			System.out.println("  1. Display all rented vehicles");
			System.out.println("  2. Display all vehicles");
			System.out.println("  3. Return to main menu");
			System.out.print("Choice: ");
			input = getUserEntry();
		} while (!input.equals("1") && !input.equals("2") && !input.equals("3"));
		return input.equals("1") ? "rented" : input.equals("2") ? "all" : "return";
	} // advancedMenu
	
	static void printRentedVehicles() {
		System.out.println("\n" + "Avis rented cars:\n-----------------");
		avis.printRentedVehicles();
		System.out.println("\n" + "Hertz rented cars:\n------------------");
		hertz.printRentedVehicles();
	} // printRentedVehicles
	
	static void printAllVehicles() {
		System.out.println("\n" + "Avis fleet:\n-----------");
		avis.printVehicles(VehicleType.All);
		System.out.println("\n" + "Hertz fleet:\n------------");
		hertz.printVehicles(VehicleType.All);
	} // printAllVehicles
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String projectPath = System.getProperty("user.dir");
		String vehicleFileAvis = drive + projectPath + "/part3/avis_cars.txt";
		String vehicleFileHertz = drive + projectPath + "/part3/hertz_cars.txt";
		
		avis = new Company("Avis", vehicleFileAvis);
		hertz = new Company("Hertz", vehicleFileHertz);
			
		String option;
		while(true) {
			switch(welcomeMenu()) {
			case "rent":
				rentVehicle(selectCompany());
				break;
			case "return":
				returnVehicle(selectCompany());
				break;
			case "advanced":
				do {
					option = advancedMenu();
					switch(option) {
					case "rented":
						printRentedVehicles();
						break;
					case "all":
						printAllVehicles();
						break;
					case "return":
						break;
					}
				}
				while (!option.equals("return"));
				break;
			case "quit":
				System.exit(0);
			}
		}
		/* interface -
		 *  - rent
		 *    - choose company
		 *    - enter vehicle type
		 *    - rental period
		 *    - list only cars matching criteria
		 *    - select by tag id
		 *    - confirmation
		 *  
		 *  - return
		 *    - display bill on screen
		 *    - save bill under Company/Bills/
		 *    
		 *  - other actions
		 *    - print all rented vehicles with customers
		 *    - printing all vehicles
		 */

	} // main

} // class
