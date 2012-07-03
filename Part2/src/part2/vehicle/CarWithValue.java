/**
 * Car class for Part2.java buy/sell application
 */
package part2.vehicle;

import vehicle.Car;
/**
 * @author Mark Redden
 *
 */
public class CarWithValue extends Car {
	// Members
	protected int m_value;

	/**
	 * @param i_id
	 * @param i_name
	 * @param i_odometer
	 * @param i_cc
	 * @param i_value
	 */
	// Constructor
	public CarWithValue(String i_id, String i_name, int i_odometer, int i_cc, boolean i_hasAC, int i_value) {
		super(i_id, i_name, i_odometer, i_cc, i_hasAC);
		m_value = i_value;
	} // Constructor
	
	public int value() {
		return m_value;
	} // value
	
	public String toString() {
		return super.toString() + " Value: " + m_value;
	} // toString
}
