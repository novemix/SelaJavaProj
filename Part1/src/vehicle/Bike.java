package vehicle;

public class Bike extends Vehicle {

	public Bike(String i_id, String i_name, int i_odometer, int i_cc) {
		super(i_id, i_name, i_odometer, i_cc);
	}

	@Override
	protected void setType() {
		m_type = VehicleType.Bike;

	}

}