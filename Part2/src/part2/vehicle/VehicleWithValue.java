/**
 * 
 */
package part2.vehicle;

import vehicle.Vehicle;

/**
 * @author marred01
 *
 */
public abstract class VehicleWithValue extends Vehicle {
	
	private int m_value;

	public VehicleWithValue(String i_id, String i_name, int i_odometer, int i_cc, int i_value) {
		super(i_id, i_name, i_odometer, i_cc);
		m_value = i_value;
	}
	
}
