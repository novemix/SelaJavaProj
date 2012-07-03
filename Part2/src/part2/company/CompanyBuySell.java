/**
 * CompanyBuySell class for Part2.java car buying/selling application
 */
package part2.company;

import java.util.Iterator;

import part2.vehicle.*;
import vehicle.Vehicle;
import vehicle.VehicleType;
import company.*;

/**
 * @author Mark Redden
 *
 */
public class CompanyBuySell extends Company {
	// Members
	protected String m_name = "";
	protected int m_bankBalance = 0;
	protected int m_lastCarID, m_lastTruckID, m_lastBikeID;

	// Constructor
	public CompanyBuySell(String i_inputFile, int i_vehicleMaximum) {
		super(i_inputFile, i_vehicleMaximum);
	} // Constructor
	
	// Return vehicle given ID
	public Vehicle getVehicleByID(String i_id) {
		Iterator<Vehicle> it = m_vehicles.iterator();
		Vehicle it_vehicle;
		while (it.hasNext()) {
			it_vehicle = it.next();
			if (it_vehicle.ID().equals(i_id)) {
				return it_vehicle;
			}
		}
		return null;
	} // getVehicleByID
	
	public void setName(String i_name) {
		m_name = i_name;
	} // setName
	
	public String name() {
		return m_name;
	} // name
	
	public void setBankBalance(int i_balance) {
		m_bankBalance = i_balance;
	} // setBankBalance
	
	public int getBankBalance() {
		return m_bankBalance;
	} // getBankBalance
	
	// Check that a transaction will succeed
	public boolean ableToBuy(Vehicle i_vehicle) {
		boolean underMax = false;
		switch (i_vehicle.type()) {
		case Car:
			underMax = ( m_totalCars < VEHICLE_MAX );
			break;
		case Truck:
			underMax = ( m_totalTrucks < VEHICLE_MAX );
			break;
		case Bike:
			underMax = ( m_totalBikes < VEHICLE_MAX );
			break;
		}
		return (underMax && m_bankBalance >= getVehicleValue(i_vehicle));
	} // ableToBuy
	
	// Carry out buy transaction
	public boolean buyVehicle(Vehicle i_vehicle) {
		if (ableToBuy(i_vehicle)) {
			i_vehicle.setID(getNewID(i_vehicle.type()));
			if (m_vehicles.add(i_vehicle)) {
				switch (i_vehicle.type()) {
				case Car:
					m_totalCars++;
					break;
				case Truck:
					m_totalTrucks++;
					break;
				case Bike:
					m_totalBikes++;
					break;
				}
				m_bankBalance -= getVehicleValue(i_vehicle);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	} // buyVehicle
	
	// Carry out sell transaction
	public void sellVehicle(Vehicle i_vehicle) {
		if (m_vehicles.remove(i_vehicle)) {
			m_bankBalance += getVehicleValue(i_vehicle);
			switch (i_vehicle.type()) {
			case Car:
				m_totalCars--;
				break;
			case Truck:
				m_totalTrucks--;
				break;
			case Bike:
				m_totalBikes--;
				break;
			}
		}
	} // sellVehicle
	
	// Calculate a new ID
	protected String getNewID(VehicleType i_vehicleType) {
		char letter;
		int number;
		switch (i_vehicleType) {
		case Car:
			letter = 'c';
			number = ++m_lastCarID;
			break;
		case Truck:
			letter = 't';
			number = ++m_lastTruckID;
			break;
		case Bike:
			letter = 'b';
			number = ++m_lastBikeID;
			break;
		default:
			letter = 'z';
			number = 0;
		}
		return letter + ( number < 10 ? "0" : "" ) + number;
	} // getNewID
	
	protected int getVehicleValue(Vehicle i_vehicle) {
		// could probably avoid this with generics
		if (i_vehicle instanceof CarWithValue) {
			return ((CarWithValue) i_vehicle).value();
		}
		else if (i_vehicle instanceof TruckWithValue) {
			return ((TruckWithValue) i_vehicle).value();
		}
		else if (i_vehicle instanceof BikeWithValue) {
			return ((BikeWithValue) i_vehicle).value();
		}
		else {
			return 0;
		}
	} // getVehicleValue
	
	@Override
	protected void parseData(String i_data) {
		String[] d = i_data.split(",");
		if (d[0].equals("Car") && m_totalCars < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new CarWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), d[5].equals("yes") ? true : false, Integer.parseInt(d[6])));
			m_lastCarID = ++m_totalCars;
		}
		if (d[0].equals("Truck") && m_totalTrucks < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new TruckWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), Integer.parseInt(d[5]), Integer.parseInt(d[6])));
			m_lastTruckID = ++m_totalTrucks;
		}
		if (d[0].equals("Bike") && m_totalBikes < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new BikeWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), Integer.parseInt(d[5])));
			m_lastBikeID = ++m_totalBikes;
		}
	} // parseData
	
}
