package com.expensetracker;
import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable {
 private double amount;
 private String category;
 private String description;
 private LocalDate date;
 
 public Expense(double amount,String category,String description)
 {
	 this.amount=amount;
	 this.category=category;
	 this.description=description;
	 this.date=LocalDate.now();
 }
 
 public double getAmount()
 {
	 return amount;
 }
	
 public String getCategory()
 {
	 return category;
 }
 
 public String getDescription()
 {
	 return description;
 }
 
 public LocalDate getDate() {
     return date;
 }

 @Override
 public String toString() {
     return date + " | " + category + " | Rs" + amount + " | " + description;
 }
 
}
