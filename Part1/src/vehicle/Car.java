/**
 * Car class for Part1.java vehicle display application
 */
package vehicle;

public class Car extends Vehicle {
	// Members
	protected boolean m_hasAC;

	// Constructor
	public Car(String i_id, String i_name, int i_odometer, int i_cc, boolean i_hasAC) {
		super(i_id, i_name, i_odometer, i_cc);
		m_hasAC = i_hasAC;
	} // Constructor
	
	public String toString() {
		return super.toString() + " Has A/C: " + ( m_hasAC ? "yes" : "no" );
	} // toString

	@Override
	protected void setType() {
		m_type = VehicleType.Car;
	} // setType
}