package application;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);


		List <TaxPayer> listTax = new ArrayList<>();
		
		System.out.println("Enter the number of tax payers: "); 
		int n = sc.nextInt();
		for (int i=0; i<n;i++) {
			System.out.printf("Tax payer #%d data: \n", i+1);
			System.out.print("Individual or company (i/c)? ");
			char ch= sc.next().charAt(0);
			if (ch=='i') {
				System.out.print("Name:");
				String nameI= sc.next();
				System.out.print("Anual income:");
				double annualIncomeI = sc.nextDouble();
				System.out.print("Health expenditures:");
				double healthExpensesI =sc.nextDouble();
				listTax.add(new Individual(nameI, annualIncomeI, healthExpensesI));	
			}
			if(ch=='c') {
				System.out.print("Name:");
				String nameC= sc.next();
				System.out.print("Anual income:");
				double annualIncomeC = sc.nextDouble();
				System.out.print("Number of employees:");
				int numberOfEmployees = sc.nextInt();
				listTax.add(new Company(nameC, annualIncomeC, numberOfEmployees));
			}
					
		}
		System.out.println("TAXES PAID:");
		for (TaxPayer c: listTax) {
			System.out.println(c.getName()+" "+ String.format("%.2f", c.tax()));
		}
		System.out.println("");
		System.out.println("TOTAL TAXES:");
		double sum=0;
		for (TaxPayer c: listTax) {
			sum+= c.tax();
		}
		System.out.print(String.format("%.2f", sum));
	}

}
