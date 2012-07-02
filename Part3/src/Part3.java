/**
 * 
 */

import part3.company.Company;
import part3.vehicle.VehicleType;
/**
 * @author Administrator
 *
 */
public class Part3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String projectPath = System.getProperty("user.dir");
		String vehicleFileAvis = drive + projectPath + "/part3/avis_cars.txt";
		String vehicleFileHertz = drive + projectPath + "/part3/hertz_cars.txt";
		Company avis = new Company("Avis", vehicleFileAvis);
		Company hertz = new Company("Hertz", vehicleFileHertz);
		
		avis.printVehicles(VehicleType.All);
		System.out.println();
		System.out.println();
		hertz.printVehicles(VehicleType.All);
		
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

	}

}
