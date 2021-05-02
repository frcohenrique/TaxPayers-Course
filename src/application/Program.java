package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) { 
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().toLowerCase().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				TaxPayer payer = new Individual(name, annualIncome, healthExpenditures);
				list.add(payer);
			}
			else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int employeesQuantity = sc.nextInt();
				TaxPayer payer = new Company(name, annualIncome, employeesQuantity);
				list.add(payer);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
		}
		
		System.out.println();
		Double sum = 0.0;
		for (TaxPayer totalTaxes : list) {
			sum += totalTaxes.tax();
		}
		System.out.printf("TOTAL TAXES: $ %.2f%n", sum);
		
		sc.close();

	}

}
