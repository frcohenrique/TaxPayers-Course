package entities;

public class Individual extends TaxPayer {
	private Double healthCare;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthCare) {
		super(name, annualIncome);
		this.healthCare = healthCare;
	}

	public Double getHealthCare() {
		return healthCare;
	}

	public void setHealthCare(Double healthCare) {
		this.healthCare = healthCare;
	}

	@Override
	public double tax() {
		double tax = 0.0;

		if (annualIncome < 20000.00 && healthCare > 0) {
			tax = (annualIncome * 0.15) - (healthCare * 0.50);
		}
		else if (annualIncome >= 20000.00 && healthCare > 0) {
			tax = (annualIncome * 0.25) - (healthCare * 0.50);
		}
		else if (annualIncome < 20000.00) {
			tax = annualIncome * 0.15;
		}
		else if (annualIncome >= 20000.00) {
			tax = annualIncome * 0.25;
		}

		return tax;
	}

}
