import java.util.Scanner;

import company.*;
import vehicle.VehicleType;

public class Part1 {

	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String vehicleList = drive + "/JavaProj/part1vehicles.txt";

		Company theCompany = new Company(vehicleList, 10);

		Scanner kbPrintAll = new Scanner(System.in);
		Scanner kbPrintNumber = new Scanner(System.in);
		Scanner kbPrintType = new Scanner(System.in);

		// Main menu interface

		System.out
				.println("=============================================================================\n");
		System.out
				.println("----------------------------RENTAL CARS SERVICE------------------------------\n");
		System.out
				.println("=============================================================================\n");
		System.out
				.println("This program is designed to help you decide which vehicle is the best for you!");
		System.out
				.println("\nIn the following program you will be able to choose from a list of:");
		System.out.println("\n\t--> Cars" + "\n\t--> Trucks" + "\n\t--> Bikes");

		System.out
				.println("\n=============================================================================\n");
		System.out
				.println("--------------------------------DASHBOARD------------------------------------\n");
		System.out
				.println("=============================================================================");
		System.out.println("FILTER                    |		SELECTION");
		System.out.println("                          |");
		System.out
				.println("-----------------------------------------------------------------------------");
		System.out
				.println("List all Vehicles?        |     ------> Press 'Y' or 'N'");
		System.out.println("                          |");
		System.out
				.println("-----------------------------------------------------------------------------");

		/*
		 * PRINT ALL VEHICLES
		 */

		String printAllChoice = kbPrintAll.nextLine();

		if (printAllChoice.equalsIgnoreCase("y")) {
			/*
			 * PRINT ALL CARS
			 */
			System.out
					.println("*****************************************************************************");
			System.out.println("				CARS											");
			System.out
					.println("*****************************************************************************\n");

			theCompany.printVehicles(VehicleType.Car);

			/*
			 * PRINT ALL TRUCKS
			 */

			System.out
					.println("\n*****************************************************************************");
			System.out.println("				TRUCKS											");
			System.out
					.println("*****************************************************************************\n");

			theCompany.printVehicles(VehicleType.Truck);

			/*
			 * PRINT ALL BIKES
			 */

			System.out
					.println("\n*****************************************************************************");
			System.out.println("				BIKES										");
			System.out
					.println("*****************************************************************************\n");

			theCompany.printVehicles(VehicleType.Bike);

		} // if
		System.out
				.println("\n*****************************************************************************");

		/*
		 * PRINT ALL VEHICLES OF A TYPE
		 */

		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("                          |");
		System.out.print("List Vehicle by Type:     |");
		System.out.print("	[ Cars ] [ Trucks ] [ Bikes ]");
		System.out
				.println("\n-----------------------------------------------------------------------------");
		String printType = kbPrintType.nextLine();

		if (printType.equalsIgnoreCase("Cars")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Types of Cars for rent: ");
			System.out
					.println("*****************************************************************************");
			theCompany.printVehicles(VehicleType.Car);
			System.out
					.println("*****************************************************************************");
		}

		else if (printType.equalsIgnoreCase("trucks")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Types of Trucks for rent: ");
			System.out
					.println("*****************************************************************************");
			theCompany.printVehicles(VehicleType.Truck);
			System.out
					.println("*****************************************************************************");
		}

		else if (printType.equalsIgnoreCase("bikes")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Types of Bikes for rent: ");
			System.out
					.println("*****************************************************************************");
			theCompany.printVehicles(VehicleType.Bike);
			System.out
					.println("*****************************************************************************");
		}

		/*
		 * PRINT NUMBER OF VEHICLES OF A TYPE
		 */

		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("                          |");
		System.out.print("List Vehicle by Type:     |");
		System.out.print("	[ Cars ] [ Trucks ] [ Bikes ]");
		System.out
				.println("\n-----------------------------------------------------------------------------");
		String printNumber = kbPrintNumber.nextLine();

		if (printNumber.equalsIgnoreCase("Cars")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Number of CARS for rent: "
					+ theCompany.getTotal(VehicleType.Car));
			System.out
					.println("*****************************************************************************");
		}

		else if (printNumber.equalsIgnoreCase("trucks")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Number of TRUCKS for rent: "
					+ theCompany.getTotal(VehicleType.Truck));
			System.out
					.println("*****************************************************************************");
		}

		else if (printNumber.equalsIgnoreCase("bikes")) {
			System.out
					.println("*****************************************************************************");
			System.out.println("		Number of BIKES for rent: "
					+ theCompany.getTotal(VehicleType.Bike));
			System.out
					.println("*****************************************************************************");
		}
	}

}
