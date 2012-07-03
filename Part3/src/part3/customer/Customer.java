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
	protected int m_period;
	
	public Customer(String i_name) {
		m_name = i_name;
	}
	
	public void rentVehicle(Vehicle i_vehicle, int i_period) {
		m_rentedVehicle = i_vehicle;
		m_period = i_period;
	}
	
	public String name() {
		return m_name;
	}
	
	public int period() {
		return m_period;
	}
	
	public Vehicle rentedVehicle() {
		return m_rentedVehicle;
	}
	
	public String toString() {
		return m_name + ":\n" + m_rentedVehicle;
	}
}
