/**
 * Customer class for Part3.java car rental application
 */
package part3.customer;

import part3.vehicle.Vehicle;
/**
 * @author Mark Redden
 *
 */
public class Customer {
	// Members
	protected String m_name;
	protected Vehicle m_rentedVehicle;
	protected int m_period;
	
	// Constructor
	public Customer(String i_name) {
		m_name = i_name;
	} // Constructor
	
	public void rentVehicle(Vehicle i_vehicle, int i_period) {
		m_rentedVehicle = i_vehicle;
		m_period = i_period;
	} // rentVehicle
	
	public String name() {
		return m_name;
	} // name
	
	public int period() {
		return m_period;
	} // period
	
	public Vehicle rentedVehicle() {
		return m_rentedVehicle;
	} // rentedVehicle
	
	public String toString() {
		return m_name + ":\n" + m_rentedVehicle;
	} // toString
}
