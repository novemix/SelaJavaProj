
package company;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;


import vehicle.*;
/**
 * 
 */

/**
 * @author marred01
 *
 */
public class Company {
	
		private final int VEHICLE_MAX;
		
		private int m_totalCars = 0;
		private int m_totalTrucks = 0;
		private int m_totalBikes = 0;
		HashSet<Vehicle> m_vehiclesHashSet = new HashSet<Vehicle>();
		TreeSet<Vehicle> m_vehicles;
		
		// Constructor
		public Company(String i_inputFile, int i_vehicleMaximum) {
			VEHICLE_MAX = i_vehicleMaximum;
			readInputFile(i_inputFile);
			m_vehicles = new TreeSet<Vehicle>(m_vehiclesHashSet);
			m_vehiclesHashSet = null;
		} // Constructor
		
		// File access, call parseData on successful reads
		private void readInputFile(String i_file) {
			FileReader input = null;
			BufferedReader bufIn = null;
			try {
				input = new FileReader(i_file);
				bufIn = new BufferedReader(input);
				
				String line;
				while ((line = bufIn.readLine()) != null) {
					parseData(line);
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
		} // readInputFile
		
		// Called from readInputFile method
		private void parseData(String i_data) {
			String[] d = i_data.split(",");
			// TODO: act on boolean return from add, report error and/or throw exception
			if (d[0].equals("Car") && m_totalCars < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Car(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),d[5].equals("yes") ? true : false));
				m_totalCars++;
			}
			if (d[0].equals("Truck") && m_totalTrucks < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Truck(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5])));
				m_totalTrucks++;
			}
			if (d[0].equals("Bike") && m_totalBikes < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Bike(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4])));
				m_totalBikes++;
			}
		} // parseData
		
		public int getTotal(VehicleType i_vehicleType) {
			int allTotal = m_totalCars + m_totalTrucks + m_totalBikes;
			switch(i_vehicleType) {
				case All:	return allTotal;
				case Car:	return m_totalCars;
				case Truck:	return m_totalTrucks;
				case Bike:	return m_totalBikes;
				default:	return allTotal;
			}
		}
		
		public void printVehicles(VehicleType i_vehicleType) {
			Iterator<Vehicle> it = m_vehicles.iterator();
			Vehicle it_vehicle;
			while (it.hasNext()) {
				it_vehicle = it.next();
				if (i_vehicleType == VehicleType.All || it_vehicle.type() == i_vehicleType) {
					System.out.println(it_vehicle);
				}
			}
		} // printVehicles
} // class