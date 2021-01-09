package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Calculate tips and bill amount, customizing based on users' input 
 * (tax rates, number of people to split the bill with, and tip percentage)
 * @author frank, Mai and Betty
 */
public class CalculateTip {
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Master Tip Calculator!");
		
		// 1. Get the total sum of the bill, not including taxes
		System.out.println("How much is your total bill, not including tax?");
		Scanner userInput = new Scanner(System.in);
		double totalSum = userInput.nextDouble();
		
		// 2. Get the tax rate 
		System.out.println("What is the tax percentage of your bill? (i.e 6.25)");
		double taxRate = userInput.nextDouble();
		
		// 3. Get the number of people to split bill with (inclusing user)
		System.out.println("How many people would you like to split this bill with? (including yourself)");
		double numPeople = userInput.nextInt();
		
		// 4. Get the tip percentage
		System.out.println("What is the tip percentage you'd like to put in? (i.e 20)");
		double tipPercentage = userInput.nextDouble();
		
		// calculate the tip amount
		double tipAmount = totalSum * (1 + taxRate / 100) * tipPercentage/100;
		System.out.println("Your tip amount will be " + tipAmount);
		// calculate the bill total after tip & tax
		double totalBill = totalSum * (1 + taxRate /100) + tipAmount;
		System.out.println("Your total bill amount including tax and tip will be " + totalBill);
		
		// 5. Ask if the user would like to split the bill evenly
		System.out.println("Would you like to split the check evenly? Y for Yes, N for No.");
		String evenString = userInput.nextLine();
		
		if (evenString.toLowerCase().startsWith("y")) {
			double payAmount = totalBill / numPeople;
			System.out.println("The total bill amount for each person in your party of " + numPeople + " comes to " + payAmount);
		}
		
		else if (evenString.toLowerCase().startsWith("n")) {
			String[] groupArr = new String[(int) numPeople];
			TreeMap<String, Double> groupMap = new TreeMap<String, Double>();
			for (int i = 0; i < groupArr.length; i++) {
				System.out.println("Name of person #" + (i+1) + ": ");
				groupArr[i] = userInput.nextLine(); 
			}
			
			for (String name: groupArr) {
				System.out.println("Please enter bill amount for " + name + " is: ");
				groupMap.put(name, userInput.nextDouble());
			}
			
			for (String name : groupMap.keySet()) {
				
				double indBillAmount = groupMap.get(name);
				double payAmount = indBillAmount + (tipAmount + taxRate * totalSum / 100) / numPeople;
				groupMap.put(name, payAmount);
				System.out.println("The total bill amount for " + name + " is " + payAmount);
			}

		}
		
		
	}

}
