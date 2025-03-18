package com.expensetracker;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class ExpenseManager {

	private static final String FILE_NAME="expense.txt";
	private List<Expense>expenses;
	
	public ExpenseManager()
	{
		this.expenses=new ArrayList<>();
		loadExpenses();
	}
	public void addExpense(double amount,String category ,String description)
	{
		Expense expense = new Expense(amount,category,description);
        expenses.add(expense);
        saveExpenses();
	}
	 public void showSummary(String period) {
	        LocalDate now = LocalDate.now();
	        double total = 0;

	        for (Expense exp : expenses) {
	            if ((period.equals("Day") && exp.getDate().equals(now)) ||
	                (period.equals("Week") && exp.getDate().isAfter(now.minusDays(7))) ||
	                (period.equals("Month") && exp.getDate().getMonth().equals(now.getMonth()))) {
	                total += exp.getAmount();
	                System.out.println(exp);
	            }
	        }
	        System.out.println("Total " + period + " expenses: Rs" + total);
	    }
	 private void saveExpenses() {
	        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	            obj.writeObject(expenses);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 private void loadExpenses() {
	        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	            expenses = (List<Expense>) obj.readObject();
	        } catch (FileNotFoundException e) {
	            expenses = new ArrayList<>();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
}
