package entities;

public class Company extends TaxPayer{

	private Integer employeesQuantity;
	
	public Company() {
		super();
	}
	public Company(String name, Double annualIncome, Integer employeesQuantity) {
		super(name, annualIncome);
		this.employeesQuantity = employeesQuantity;
	}
	
	public Integer getEmployessQuantity() {
		return employeesQuantity;
	}
	public void setEmployeesQuantity(Integer employeesQuantity) {
		this.employeesQuantity = employeesQuantity;
	}
	
	@Override
	public double tax() {
		Double tax = 0.16;
		if (employeesQuantity >= 10) {
			tax = 0.14;
		}
		return annualIncome * tax;
	}
}
