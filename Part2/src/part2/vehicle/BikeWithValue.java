/**
 * 
 */
package part2.vehicle;

import vehicle.Bike;

/**
 * @author marred01
 *
 */
public class BikeWithValue extends Bike {
	
	protected int m_value;
	
	public BikeWithValue(String i_id, String i_name, int i_odometer, int i_cc, int i_value) {
		super(i_id, i_name, i_odometer, i_cc);
		m_value = i_value;
	}
	
	public int value() {
		return m_value;
	}
	
	public String toString() {
		return super.toString() + " Value: " + m_value;
	}
	
}
