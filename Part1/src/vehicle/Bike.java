/**
 * Bike class for Part1.java vehicle display application
 */
package vehicle;

public class Bike extends Vehicle {

	// Constructor
	public Bike(String i_id, String i_name, int i_odometer, int i_cc) {
		super(i_id, i_name, i_odometer, i_cc);
	} // Constructor

	@Override
	protected void setType() {
		m_type = VehicleType.Bike;
	} // setType

}