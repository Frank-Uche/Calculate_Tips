package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Calculate tips and bill amount, customizing based on users' input 
 * (tax rates, number of people to split the bill with, and tip percentage)
 * @author Franklyn, Mai and Betty
 */
public class CalculateTip {
	
	public static double getTotalSum() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("How much is your total bill, not including tax?");
			try {
				return userInput.nextDouble();
			}
			catch (java.util.InputMismatchException e) {
		        userInput.nextLine();
			}
		}
	}
	
	public static double getTaxRate() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("What is the tax percentage of your bill? (i.e 6.25)");
			try {
				return userInput.nextDouble();
			}
			catch (java.util.InputMismatchException e) {
		        userInput.nextLine();
			}
		}
	}
	
	public static double getNumPeople() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("How many people would you like to split this bill with? (including yourself)");
			try {
				return userInput.nextInt();
			}
			catch (java.util.InputMismatchException e) {
		        userInput.nextLine();
			}
		}
	}
	
	public static double getTipPercentage() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("What is the tip percentage you'd like to put in? (i.e 20)");
			try {
				return userInput.nextDouble();
			}
			catch (java.util.InputMismatchException e) {
		        userInput.nextLine();
			}
		}
	}
	
	public static void getEvenSplit() {
		
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Master Tip Calculator!");
		Scanner userInput = new Scanner(System.in);
		
		// 1. Get the total sum of the bill, not including taxes
		double totalSum = getTotalSum();
		
		// 2. Get the tax rate 
		double taxRate = getTaxRate();
		
		// 3. Get the number of people to split bill with (including user)
		int numPeople = (int) getNumPeople();
		
		// 4. Get the tip percentage
		double tipPercentage = getTipPercentage();
		
		// calculate the tip amount
		double tipAmount = Math.round(totalSum * (1 + taxRate / 100) * tipPercentage/100);
		
		// calculate the bill total after tip & tax
		double totalBill = Math.round(totalSum * (1 + taxRate /100) + tipAmount);
		System.out.println("Your total bill amount including tax and tip will be " + totalBill);
		
		// 5. Ask if the user would like to split the bill evenly
		System.out.println("Would you like to split the check evenly? Y for Yes, N for No.");
		String evenString = userInput.next();
		
		// if the user says yes
		if (evenString.equalsIgnoreCase("Y")) {
			
			double payAmount = Math.round(totalBill / numPeople);
			System.out.println("The total bill amount for each person in your party of " + numPeople + " comes to " + payAmount + " dollars");
		}
		
		else if (evenString.equalsIgnoreCase("N")) {
			String[] groupArr = new String[(int) numPeople];
			TreeMap<String, Double> groupMap = new TreeMap<String, Double>();
			
			for (int i = 0; i < groupArr.length; i++) {
				System.out.println("Enter name of person " + (i+1) + ": " );
				String name = userInput.next();
				groupArr[i] = name; 
			}
			
			for (int i = 0; i < groupArr.length; i++) {
				System.out.println("Name of person #" + (i+1) + ": " + groupArr[i]);
			}
			
			double checkSum = 0.0;
			for (String name: groupArr) {
				System.out.println("Please enter bill amount for " + name + ": ");
				groupMap.put(name, userInput.nextDouble());
				checkSum += groupMap.get(name);
				double remainSum = totalSum - checkSum;
				// to help user keep track of individual bill amounts
				System.out.println("The remaining amount in your total bill is " + remainSum);
			}
			
			// check that the user has put in the correct amount for all group members
			if (checkSum != totalSum) {
				System.out.println("Your total bill amount does not add up correctly. Please input the correct amount for individual users. ");
				checkSum = 0.0;
				for (String name: groupArr) {
					System.out.println("Please enter bill amount for " + name + ": ");
					groupMap.put(name, userInput.nextDouble());
					checkSum += groupMap.get(name);
					double remainSum = totalSum - checkSum;
					// to help user keep track of individual bill amounts
					System.out.println("The remaining amount in your total bill is " + remainSum);
				}
			}
			
			for (String name : groupMap.keySet()) {
				
				double indBillAmount = groupMap.get(name);
				double payAmount = indBillAmount + (tipAmount + taxRate * totalSum / 100) / numPeople;
				double finalTip = tipAmount * (indBillAmount / totalSum);
				groupMap.put(name, payAmount);
				System.out.println("The total bill amount for " + name + " is " + Math.round(payAmount) + " dollars");
				System.out.println("The tip amount for " + name + " is " + finalTip + " dollars");
				System.out.println(""); // blank line
			}
		}
	userInput.close();
	}

}
