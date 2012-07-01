package vehicle;

public class Truck extends Vehicle {
	
	protected int m_weightLimit;
	
	public Truck(String i_id, String i_name, int i_odometer, int i_cc, int i_weightLimit) {
		super(i_id, i_name, i_odometer, i_cc);
		m_weightLimit = i_weightLimit;
	} 
	
	public String toString() {
		return super.toString() + " Weight Limit: " + m_weightLimit;
	}

	@Override
	protected void setType() {
		m_type = "Truck";
		
	}

}