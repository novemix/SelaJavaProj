/**
 * 
 */
package part3.customer;

import part3.vehicle.Vehicle;
/**
 * @author Administrator
 *
 */
public class Customer {
	protected String m_name;
	protected Vehicle m_rentedVehicle;
	
	public Customer(String i_name) {
		m_name = i_name;
	}
	
	public void rentVehicle(Vehicle i_vehicle) {
		m_rentedVehicle = i_vehicle;
	}
	
	public void returnVehicle() {
		m_rentedVehicle = null;
	}
	
	public String name() {
		return m_name;
	}
	
	public String toString() {
		return m_name + " - " + m_rentedVehicle;
	}
}
