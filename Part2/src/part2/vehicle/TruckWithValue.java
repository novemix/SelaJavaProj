/**
 * 
 */
package part2.vehicle;

import vehicle.Truck;

/**
 * @author marred01
 *
 */
public class TruckWithValue extends Truck {
	
	protected int m_value;
	
	public TruckWithValue(String i_id, String i_name, int i_odometer, int i_cc, int i_weightLimit, int i_value) {
		super(i_id, i_name, i_odometer, i_cc, i_weightLimit);
		m_value = i_value;
	} 
	
	public int value() {
		return m_value;
	}
	
	public String toString() {
		return super.toString() + " Value: " + m_value;
	}
}
