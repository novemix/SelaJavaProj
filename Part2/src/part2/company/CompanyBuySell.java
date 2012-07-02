/**
 * 
 */
package part2.company;

import company.*;

/**
 * @author marred01
 *
 */
public class CompanyBuySell extends Company {
	private int m_bankBalance = 0;

	public CompanyBuySell(String i_inputFile, int i_vehicleMaximum) {
		super(i_inputFile, i_vehicleMaximum);
	}
	
	public void setBankBalance(int i_balance) {
		m_bankBalance = i_balance;
	}
	
	public int getBankBalance() {
		return m_bankBalance;
	}
}
