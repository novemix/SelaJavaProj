
import company.*;
import vehicle.VehicleType;

public class Part1 {
	
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0,6).equals("Windows") ? "C:" : "";
		String vehicleList = drive + "/JavaProj/part1vehicles.txt";
		
		Company theCompany = new Company(vehicleList);
		
		theCompany.printVehicles(VehicleType.All);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(VehicleType.Truck);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(VehicleType.Bike);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(VehicleType.Car);
		
		System.out.println("all: " + theCompany.getTotal(VehicleType.All));
		System.out.println("cars: " + theCompany.getTotal(VehicleType.Car));
		System.out.println("trucks: " + theCompany.getTotal(VehicleType.Truck));
		System.out.println("bikes: " + theCompany.getTotal(VehicleType.Bike));
	}
	
}
