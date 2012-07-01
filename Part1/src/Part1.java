
import company.*;
import vehicle.*;

public class Part1 {
	
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0,6).equals("Windows") ? "C:" : "";
		String vehicleList = drive + "/JavaProj/part1vehicles.txt";
		
		Company theCompany = new Company(vehicleList);
		
		theCompany.printVehicles(vtype.All);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(vtype.Truck);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(vtype.Bike);
		System.out.println();
		System.out.println();
		theCompany.printVehicles(vtype.Car);
		
		System.out.println("all: " + theCompany.getTotal(vtype.All));
		System.out.println("cars: " + theCompany.getTotal(vtype.Car));
		System.out.println("trucks: " + theCompany.getTotal(vtype.Truck));
		System.out.println("bikes: " + theCompany.getTotal(vtype.Bike));
	}
	
}
