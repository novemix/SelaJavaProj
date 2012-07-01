
import company.*;


public class Part1 {
	
	public static void main(String[] args) {
		String vehicleList = "/JavaProj/part1vehicles.txt";
		Company theCompany = new Company(vehicleList);
		
		theCompany.printVehicles();
	}
	
}