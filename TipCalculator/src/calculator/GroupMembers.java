package calculator;
/**
 * represents the folk(s) ordering together
 * @author frank, Mai and Betty
 *
 */
public class GroupMembers {
	/**
	 * represent the name of one of the group members
	 */
	public String name;
	/**
	 * represent the amount charged to a single group member
	 */
	public double amount;
	/**
	 * represent the amount of tip that each group member is adding to their bill if they are tipping individually
	 */
	public double tipAmount;
	/**
	 * create each instance of a group member
	 * @param name
	 * @param amount
	 */
	public GroupMembers(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}

}
