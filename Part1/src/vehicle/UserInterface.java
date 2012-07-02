package vehicle;

public class UserInterface {

	String m_menu;

	public UserInterface(String menu) {
		this.m_menu = menu;
	}

	public void printMain() {

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
		System.out.println("SELECTION                 |		COMMAND");
		System.out.println("                          |");
		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("Press 1:        	  |    	List all Vehicles");
		System.out.println("                          |");
		System.out
				.println("-----------------------------------------------------------------------------");
		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("                          |");
		System.out.print("Press 2:     		  | 	List Vehicle by Type");
		System.out
				.println("\n-----------------------------------------------------------------------------");

		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("                          |");
		System.out.print("Press 3:     		  | 	List Number of Vehicles by Type");
		System.out
				.println("\n-----------------------------------------------------------------------------");

		System.out
				.println("-----------------------------------------------------------------------------");
		System.out.println("                          |");
		System.out.print("Press 4:     		  | 	Quit program");
		System.out
				.println("\n-----------------------------------------------------------------------------");
	}

	public void printCarMenu() {
		System.out
				.println("*****************************************************************************");
		System.out.println("				CARS											");
		System.out
				.println("*****************************************************************************\n");

	}

	public void printTruckMenu() {
		System.out
				.println("\n*****************************************************************************");
		System.out.println("				TRUCKS											");
		System.out
				.println("*****************************************************************************\n");
	}

	public void printBikeMenu() {
		System.out
				.println("\n*****************************************************************************");
		System.out.println("				BIKES										");
		System.out
				.println("*****************************************************************************\n");
		System.out
				.println("\n*****************************************************************************");
	}

	public void printCarType() {
		System.out
				.println("*****************************************************************************");
		System.out.println("		Types of Cars for rent: ");
		System.out
				.println("*****************************************************************************");
	}

	public void printTruckType() {
		System.out
				.println("*****************************************************************************");
		System.out.println("		Types of Trucks for rent: ");
		System.out
				.println("*****************************************************************************");
	}

	public void printBikeType() {
		System.out
				.println("*****************************************************************************");
		System.out.println("		Types of Bikes for rent: ");
		System.out
				.println("*****************************************************************************");
	}

	public void printCarNumber() {
		System.out.print(" cars are available for rent.");
		System.out
				.println("\n*****************************************************************************");
	}

	public void printTruckNumber() {

		System.out.print(" trucks are available for rent.");
		System.out
		.println("\n*****************************************************************************");
	}

	public void printBikeNumber() {
		System.out.print(" bikes are available for rent.");
		System.out
		.println("\n*****************************************************************************");

	}

}
