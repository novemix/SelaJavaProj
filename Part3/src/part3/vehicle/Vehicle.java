/**
 * 
 */
package part3.vehicle;

import part3.customer.Customer;
/**
 * @author Administrator
 *
 */
public class Vehicle implements Comparable<Vehicle>{
	public String m_name;
	public String m_tagID;
	public boolean m_isAvailable = false;
	public int m_pricePerDay;
	public String m_customerName = "";
	public boolean m_isSmokeFree = false;
	public int m_numberOfSeats;
	public boolean m_hasAirBags = false;
	public boolean m_hasAC = false;
	public boolean m_isAutomatic = false;
	public boolean m_hasPowerWindows = false;
	public boolean m_hasAMFMradio = false;
	public boolean m_hasPowerSteering = false;
	public boolean m_hasPowerBrakes = false;
	public VehicleType m_type;
	
	public Vehicle(String i_name) {
		m_name = i_name;
	}
	
	public VehicleType type() {
		return m_type;
	}
	
	public void rent(Customer i_customer) {
		m_customerName = i_customer.name();
		m_isAvailable = false;
		i_customer.rentVehicle(this);
	}
	
	public void returnIt(Customer i_customer) {
		m_customerName = "";
		m_isAvailable = true;
		i_customer.returnVehicle();
	}
	
	public String toString() {
		return m_name + " - " + m_tagID + " - " + m_type + " - avail: " + m_isAvailable;
	}
	
	public int compareTo(Vehicle i_vehicle) {
		return m_tagID.compareTo(i_vehicle.m_tagID);
	}
	
	public boolean equals(Vehicle i_vehicle) {
		return this.m_tagID.equals(i_vehicle.m_tagID);
	}
	
	public int hashCode() {
		return Integer.parseInt(m_tagID.substring(4));
	}
}
