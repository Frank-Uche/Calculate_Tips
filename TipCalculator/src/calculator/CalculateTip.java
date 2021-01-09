package calculator;
/**
 * Calculate the tip given the total amount and the number of people
 * @author frank, Mai and Betty
 */
public class CalculateTip {
	/**
	 * represents the total sum of charges
	 */
	public double totalSum;
	/**
	 * represents the given state tax rate
	 * We assume a constant tax rate of 6.5%
	 */
	public static final double taxRate = 0.065;
	/**
	 * represents the tip percentage that the customer is willing to give
	 */
	public double tipPercent;
	/**
	 * represents the number of customers in the group
	 */
	public int peopleCount;
	/**
	 * represents each member of the group ordering together
	 */
	public GroupMembers member;
	
	/**
	 * constructor to calculate the tips in each instance
	 * @param totalSum
	 * @param tipPercent
	 * @param member
	 */
	public CalculateTip(double tipPercent) {
		this.tipPercent = tipPercent;
	}
	/**
	 * asks the user for the total sum of the charges
	 * @returns the total sum of the charges as a double
	 */
	public double getTotalSum() {
		return 0.0;
	}
	/**
	 * asks the user what proportion of the total charges that they want to tip as a percentage
	 * @returns the proportion as a double
	 */
	public double getTipPercentage() {
		return 0.0;
	}
	/**
	 * handles the logic of calculating the tip
	 */
	public void run() {
		
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
