/**
 * 
 */
package part3.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import part3.customer.*;
import part3.vehicle.*;

/**
 * @author Administrator
 *
 */
public class Company {
	protected String m_name;
	protected Vehicle m_currentVehicle;
	protected ArrayList<Customer> m_customers = new ArrayList<Customer>();
	
	protected int[] m_totals = new int[VehicleType.All.ordinal() + 1]; // All is the last type
	protected HashSet<Vehicle> m_vehiclesHashSet = new HashSet<Vehicle>();
	protected TreeSet<Vehicle> m_vehicles;
	
	public Company(String i_name, String i_inputFile) {
		m_name = i_name;
		File inputFile = new File(i_inputFile);
		if (inputFile.exists()) {
			readInputFile(inputFile);
		}
		m_vehicles = new TreeSet<Vehicle>(m_vehiclesHashSet);
		m_vehiclesHashSet = null;
	} // Constructor
	
	public String name() {
		return m_name;
	}
	
	public Vehicle getVehicleByID(String i_id) {
		Iterator<Vehicle> it = m_vehicles.iterator();
		Vehicle it_vehicle;
		while (it.hasNext()) {
			it_vehicle = it.next();
			if (it_vehicle.m_tagID.equals(i_id)) {
				return it_vehicle;
			}
		}
		return null;
	}
	
	public Customer getCustomerByName(String i_name) {
		for (Customer c : m_customers) {
			if (c.name().equals(i_name)) { return c; }
		}
		return null;
	} // getCustomerByName
	
	public void rentVehicle(Vehicle i_vehicle, Customer i_customer, int i_period) {
		i_vehicle.rent(i_customer, i_period);
		m_customers.add(i_customer);
	}
	
	public boolean returnCustomerVehicle(Customer i_customer) {
		billCustomer(i_customer);
		i_customer.rentedVehicle().returnIt();
		return m_customers.remove(i_customer);
	} // returnCustomerVehicle
	
	public void printVehicles(VehicleType i_vehicleType, boolean i_availableOnly) {
		Iterator<Vehicle> it = m_vehicles.iterator();
		Vehicle it_vehicle;
		while (it.hasNext()) {
			it_vehicle = it.next();
			if (i_vehicleType == VehicleType.All || it_vehicle.type() == i_vehicleType) {
				if ((i_availableOnly && it_vehicle.m_isAvailable) || ! i_availableOnly) {
					System.out.println(it_vehicle);
				}
			}
		}
	} // printVehicles
	
	public void printRentedVehicles() {
		Vehicle v;
		for (Customer c : m_customers) {
			v = c.rentedVehicle();
			System.out.format("%-10s - %-17s - %-18s - %d days\n",v.m_tagID,v.m_name,c.name(),c.period());
		}
	} // printRentedVehicles

	public String toString() {
		return m_name;
	}
	
	protected void billCustomer(Customer i_customer) {
		String vehicleName = i_customer.rentedVehicle().m_name;
		int rate = i_customer.rentedVehicle().m_pricePerDay;
		int period = i_customer.period();
		int total = rate * period;
		System.out.println("\n" + "Thank you " + i_customer.name() + "!");
		System.out.println("We hope you enjoyed your " + period + " days with your " + vehicleName + ".");
		System.out.println("Your amount due is: " + period + " days at " + rate + " per day = " + total);
		System.out.println("Have a nice day now.");
		writeBillToFile(i_customer);
	} // billCustomer

	protected void writeBillToFile(Customer i_customer) {
		String drive = System.getProperty("os.name").substring(0, 6)
				.equals("Windows") ? "C:" : "";
		String projectPath = System.getProperty("user.dir");
		String fullPathAndFilename = drive + projectPath + "/part3/" + m_name + "/" + i_customer.name() + ".txt";
		File outputFile = new File(fullPathAndFilename);
		BufferedWriter output = null;
		try {
			outputFile.getParentFile().mkdirs();
			outputFile.setWritable(true);
			output = new BufferedWriter(new FileWriter(outputFile));
			Vehicle vehicle = i_customer.rentedVehicle();
			output.write(vehicle.m_tagID + " - " + vehicle.m_name + ", "
					+ vehicle.m_pricePerDay + "/day, " + i_customer.period()
					+ " days, total: "
					+ (vehicle.m_pricePerDay * i_customer.period()));
		}
		catch (IOException io) {
			System.out.println(io);
		}
		finally {
			try {
				output.close();
			}
			catch (IOException io) {
				System.out.print(io);
			}
		}
	}
	
	protected void readInputFile(File i_file) {
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
	protected void parseData(String i_data) {
		String[] d = i_data.split(":");
		String key = d[0].trim().toLowerCase();
		String value = "";
		if (d.length > 1) {
			value = d[1].trim();
		}
		// TODO: act on boolean return from add, report error and/or throw exception
		switch (key) {
		case "name":
			m_currentVehicle = new Vehicle(value);
			break;
		case "tag id":
			m_currentVehicle.m_tagID = value;
			m_vehiclesHashSet.add(m_currentVehicle); // adding here since hashCode is based on tagID
			break;
		case "available for rent":
			m_currentVehicle.m_isAvailable = value.equals("yes");
			break;
		case "price/day":
			m_currentVehicle.m_pricePerDay = Integer.parseInt((value.split("/"))[0]);
			break;
		case "customer":
			if (!value.equals("")) {
				Customer customer = new Customer(value);
				m_currentVehicle.rent(customer, 1); // 1 day
				m_customers.add(customer);
			}
			break;
		case "smoke free":
			m_currentVehicle.m_isSmokeFree = value.equals("yes");
			break;
		case "number of seats":
			m_currentVehicle.m_seats = Integer.parseInt(value);
			break;
		case "air bags":
			m_currentVehicle.m_hasAirBags = value.equals("yes");
			break;
		case "air conditioning":
			m_currentVehicle.m_hasAC = value.equals("yes");
			break;
		case "automatic":
			m_currentVehicle.m_isAutomatic = value.equals("yes");
			break;
		case "power windows":
			m_currentVehicle.m_hasPowerWindows = value.equals("yes");
			break;
		case "am/fm radio":
			m_currentVehicle.m_hasAMFMradio = value.equals("yes");
			break;
		case "power steering":
			m_currentVehicle.m_hasPowerSteering = value.equals("yes");
			break;
		case "power brakes":
			m_currentVehicle.m_hasPowerBrakes = value.equals("yes");
			break;
		case "type of vehicle":
			m_currentVehicle.m_type = VehicleType.valueOf(value);
			m_totals[m_currentVehicle.m_type.ordinal()]++;
			break;
		}
	} // parseData
	
}
