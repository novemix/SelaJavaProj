import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import vehicle.*;


public class Part1 {
	
	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static Car[] m_cars = new Car[10];
	private static int m_totalCars = 0;
	private static Truck[] m_trucks = new Truck[10];
	private static int m_totalTrucks = 0;
	private static Bike[] m_bikes = new Bike[10];
	private static int m_totalBikes = 0;
	
	private static void loadInputFile(String file) {
		FileReader input = null;
		BufferedReader bufIn = null;
		try {
			input = new FileReader(file);
			bufIn = new BufferedReader(input);
			
			String line;
			while ((line = bufIn.readLine()) != null) {
				loadData(line);
			}
		}
		catch (IOException io) {
			System.out.println(io);
		}
		finally {
			try {
				bufIn.close();
				input.close();
			}
			catch (IOException io) {
				System.out.print(io);
			}
		}
	} // loadInputFile
	
	private static void loadData(String data) {
		String[] d = data.split(",");
		System.out.println(d[0]);
		if (d[0].equals("Car") && m_totalCars < m_cars.length) {
			System.out.println(d[1]);
			m_cars[m_totalCars++] = new Car(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),d[5].equals("yes") ? true : false);
			vehicles.add(m_cars[m_totalCars - 1]);
		}
		if (d[0].equals("Truck") && m_totalTrucks < m_trucks.length) {
			System.out.println(d[1]);
			m_trucks[m_totalTrucks++] = new Truck(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5]));
			vehicles.add(m_trucks[m_totalTrucks - 1]);
		}
		if (d[0].equals("Bike")) {
			System.out.println(d[1]);
			m_bikes[m_totalBikes++] = new Bike(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]));
			vehicles.add(m_bikes[m_totalBikes - 1]);
		}
	}
	

	public static void main(String[] args) {
		loadInputFile("/part1vehicles.txt");
		m_cars[5].printInfo();
		System.out.println();
		m_trucks[1].printInfo();
		System.out.println();
		m_bikes[1].printInfo();
		System.out.println();

		TreeSet<Vehicle> foo = new TreeSet<Vehicle>();
		
		System.out.println();
		for (Vehicle v : vehicles) {
			foo.add(v);
			v.printInfo();
			System.out.println();
		}
		
		Iterator<Vehicle> foo_i = foo.iterator();

		System.out.println();
		System.out.println();
		while (foo_i.hasNext()) {
			foo_i.next().printInfo();
			System.out.println();
		}
	}

}
