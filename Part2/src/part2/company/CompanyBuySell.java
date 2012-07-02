/**
 * 
 */
package part2.company;

import part2.vehicle.*;
import company.*;

/**
 * @author marred01
 *
 */
public class CompanyBuySell extends Company {
	protected String m_name = "";
	protected int m_bankBalance = 0;

	public CompanyBuySell(String i_inputFile, int i_vehicleMaximum) {
		super(i_inputFile, i_vehicleMaximum);
	}
	
	public void setName(String i_name) {
		m_name = i_name;
	}
	
	public String name() {
		return m_name;
	}
	
	public void setBankBalance(int i_balance) {
		m_bankBalance = i_balance;
	}
	
	public int getBankBalance() {
		return m_bankBalance;
	}
	
	@Override
	protected void parseData(String i_data) {
		String[] d = i_data.split(",");
		// TODO: act on boolean return from add, report error and/or throw
		// exception
		if (d[0].equals("Car") && m_totalCars < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new CarWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), d[5].equals("yes") ? true : false, Integer.parseInt(d[6])));
			m_totalCars++;
		}
		if (d[0].equals("Truck") && m_totalTrucks < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new TruckWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), Integer.parseInt(d[5]), Integer.parseInt(d[6])));
			m_totalTrucks++;
		}
		if (d[0].equals("Bike") && m_totalBikes < VEHICLE_MAX) {
			m_vehiclesHashSet.add(new BikeWithValue(d[1], d[2], Integer.parseInt(d[3]),
					Integer.parseInt(d[4]), Integer.parseInt(d[5])));
			m_totalBikes++;
		}
	} // parseData
	
}
