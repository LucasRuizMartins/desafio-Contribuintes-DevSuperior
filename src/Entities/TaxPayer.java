package Entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpeding;
	private double educationSpeding;

	public TaxPayer() {

	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpeding,
			double educationSpeding) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpeding = healthSpeding;
		this.educationSpeding = educationSpeding;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpeding() {
		return healthSpeding;
	}

	public void setHealthSpeding(double healthSpeding) {
		this.healthSpeding = healthSpeding;
	}

	public double getEducationSpeding() {
		return educationSpeding;
	}

	public void setEducationSpeding(double educationSpeding) {
		this.educationSpeding = educationSpeding;
	}

	// taxas

	public static double grossTax(double salary, double services, double capital) {
		return salaryTax(salary) + servicesTax(services) + capitalTax(capital);
	}

	public static double salaryTax(double quantia) {

		double salaryTax;

		if (quantia / 12 > 3000.00) {
			salaryTax = 0.00;
		}

		if (quantia / 12 >= 3000.00 && quantia / 12 <= 5000.00) {
			salaryTax = 0.10;
		} else {
			salaryTax = 0.20;
		}

		return quantia * salaryTax;

	}

	public static double servicesTax(double amount) {
		return amount * 0.15;
	}

	public static double capitalTax(double amount) {
		return amount * 0.20;

	}

	public static double taxRebate(double grossTax, double servicesTax) {

		if (grossTax * 0.30 < servicesTax) {

			return grossTax * 0.30;

		} else {
			return servicesTax;

		}
	}

	public static double netTax(double amountTax, double taxRebate) {
		return amountTax - taxRebate;
	}
}