/**
 * 
 */
package part2.vehicle;

import vehicle.Car;
/**
 * @author marred01
 *
 */
public class CarWithValue extends Car {

	protected int m_value;

	/**
	 * @param i_id
	 * @param i_name
	 * @param i_odometer
	 * @param i_cc
	 * @param i_value
	 */
	public CarWithValue(String i_id, String i_name, int i_odometer, int i_cc, boolean i_hasAC, int i_value) {
		super(i_id, i_name, i_odometer, i_cc, i_hasAC);
		m_value = i_value;
	}
	
	public int value() {
		return m_value;
	}
	
	public String toString() {
		return super.toString() + " Value: " + m_value;
	}
}
