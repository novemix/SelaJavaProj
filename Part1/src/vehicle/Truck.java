/**
 * Truck class for Part1.java vehicle display application
 */
package vehicle;

public class Truck extends Vehicle {
	// Members
	protected int m_weightLimit;
	
	// Constructor
	public Truck(String i_id, String i_name, int i_odometer, int i_cc, int i_weightLimit) {
		super(i_id, i_name, i_odometer, i_cc);
		m_weightLimit = i_weightLimit;
	} // Constructor
	
	public String toString() {
		return super.toString() + " Weight Limit: " + m_weightLimit;
	} // toString

	@Override
	protected void setType() {
		m_type = VehicleType.Truck;
	} // setType

}