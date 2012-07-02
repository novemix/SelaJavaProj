import java.util.Scanner;

import company.*;
import vehicle.UserInterface;
import vehicle.VehicleType;

public class Part1 {

	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String vehicleList = drive + "/JavaProj/part1vehicles.txt";

		Company theCompany = new Company(vehicleList, 10);

		// Main menu interface
		String printMain = null;
		UserInterface main = new UserInterface(printMain);
		main.printMain();

		Scanner kbPrintAll = new Scanner(System.in);
		Scanner kbPrintNumber = new Scanner(System.in);
		Scanner kbPrintChoice = new Scanner(System.in);

		/******************************************************************************************
		 * OPTION 1: PRINT ALL VEHICLES
		 ******************************************************************************************/

		String printChoice = kbPrintChoice.nextLine();

		if (printChoice.equalsIgnoreCase("1")) {
			main.printCarMenu();
			theCompany.printVehicles(VehicleType.Car);

			main.printTruckMenu();
			theCompany.printVehicles(VehicleType.Truck);

			main.printBikeMenu();
			theCompany.printVehicles(VehicleType.Bike);

			/******************************************************************************************
			 * OPTION 2: PRINT VEHICLES BY TYPE
			 ******************************************************************************************/

		} else if (printChoice.equalsIgnoreCase("2")) {
			Scanner kbPrintType = new Scanner(System.in);
			System.out.println("Which type? (Type 'Car,' 'Truck,' or 'Bike')");
			String printType = kbPrintType.nextLine();

			// PRINT CAR TYPE

			if (printType.equalsIgnoreCase("Car")) {
				main.printCarType();
				theCompany.printVehicles(VehicleType.Car);
			} else if (printType.equalsIgnoreCase("Truck")) {
				main.printTruckType();
			} else if (printType.equalsIgnoreCase("Bike")) {
				main.printBikeType();
				theCompany.printVehicles(VehicleType.Bike);
			}

			/******************************************************************************************
			 * OPTION 3: NUMBER OF VEHICLES
			 ******************************************************************************************/

		} else if (printChoice.equalsIgnoreCase("3")) {
			System.out.println("Which type? (Type 'Car,' 'Truck,' or 'Bike')");
			String printNumber = kbPrintNumber.nextLine();

			if (printNumber.equalsIgnoreCase("Car")) {
				System.out.print(theCompany.getTotal(VehicleType.Car));
				main.printCarNumber();

			} else if (printNumber.equalsIgnoreCase("Truck")) {
				System.out.print(theCompany.getTotal(VehicleType.Truck));
				main.printTruckNumber();
			} else if (printNumber.equalsIgnoreCase("Bike")) {
				System.out.print(theCompany.getTotal(VehicleType.Bike));
				main.printBikeNumber();
			}

			/******************************************************************************************
			 * OPTION 4: QUIT PROGRAM
			 ******************************************************************************************/

			else if (printChoice.equalsIgnoreCase("4")) {
				System.out.println("Exiting program...");
				System.exit(0);
			}
		}
	}
}
