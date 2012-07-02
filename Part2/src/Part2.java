
import java.io.File;

import vehicle.VehicleType;
import company.*;

public class Part2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0,6).equals("Windows") ? "C:" : "";
		String vehicleListDealer = drive + "/JavaProj/part2vehiclesDealer.txt";
		String vehicleListA = drive + "/JavaProj/part2vehiclesA.txt";
		
		Company dealership = new Company(vehicleListDealer, 100);
		Company rentalCompanyA = new Company(vehicleListA, 10);
		Company rentalCompanyB = new Company("", 10);
		
		rentalCompanyA.printVehicles(VehicleType.All);
	}

}
