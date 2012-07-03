/**
 * Bike class for Part2.java buy/sell application
 */
package part2.vehicle;

import vehicle.Bike;

/**
 * @author Mark Redden
 *
 */
public class BikeWithValue extends Bike {
	// Members
	protected int m_value;
	
	// Constructor
	public BikeWithValue(String i_id, String i_name, int i_odometer, int i_cc, int i_value) {
		super(i_id, i_name, i_odometer, i_cc);
		m_value = i_value;
	} // Constructor
	
	public int value() {
		return m_value;
	} // value
	
	public String toString() {
		return super.toString() + " Value: " + m_value;
	} // toString
	
}
