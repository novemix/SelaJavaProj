package vehicle;

public class Car extends Vehicle implements IPrintInformation {
	
	protected boolean m_hasAC;

	public Car(String i_id, String i_name, int i_odometer, int i_cc, boolean i_hasAC) {
		super(i_id, i_name, i_odometer, i_cc);
		m_hasAC = i_hasAC;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.print(" Has A/C: " + ( m_hasAC ? "yes" : "no" ));
	}

	@Override
	protected void setType() {
		m_type = "Car";
		
	}
}
