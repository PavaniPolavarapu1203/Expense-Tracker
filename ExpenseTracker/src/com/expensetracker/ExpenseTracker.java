package com.expensetracker;
import java.util.*;

public class ExpenseTracker {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		ExpenseManager manager =new ExpenseManager();
		while(true)
		{
			System.out.println("Daily Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Daily Summary");
            System.out.println("3. View Weekly Summary");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            case 1:
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter description: ");
                String description = sc.nextLine();
                manager.addExpense(amount, category, description);
                System.out.println("Expense added!");
                break;
            case 2:
            	manager.showSummary("Day");
                break;
            case 3:
                manager.showSummary("Week");
                break;
            case 4:
                manager.showSummary("Month");
                break;
            case 5:
                System.out.println("Exiting... Have a great day!");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
		}
		
	}
}
