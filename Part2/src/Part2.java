
import java.io.File;

import company.*;

public class Part2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String drive = System.getProperty("os.name").substring(0,6).equals("Windows") ? "C:" : "";
		String vehicleList = drive + "/JavaProj/part2vehicles.txt";
		
		Company dealership = new Company(vehicleList, 100);
		//Company rentalCo = new Company("",10);
		File file1 = new File("");
		System.out.println(file1.exists());
	}

}
