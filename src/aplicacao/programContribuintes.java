package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.TaxPayer;

public class programContribuintes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.println("Quantos contribuintes você vai digitar?");
		int taxPayerNumber = sc.nextInt();

		for (int i = 1; i < taxPayerNumber +1; i++) {

			System.out.println("Digite o dado do " + i  + "º contribuinte");

			System.out.println("Renda anual com salário:");
			double salaryIncome = sc.nextDouble();

			System.out.println("Renda anual com prestação de serviço:");
			double servicesIncome = sc.nextDouble();

			System.out.println("Renda anual com ganho de capital:");
			double capitalIncome = sc.nextDouble();

			System.out.println("Gastos médicos:");
			double healthSpeding = sc.nextDouble();

			System.out.println("Gastos educacionais:");
			double educationSpeding = sc.nextDouble();

			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpeding, educationSpeding));

		}

		for (TaxPayer p : list) {
			
			int n = (int)list.indexOf(p) + 1;
			double salaryIncome = p.getSalaryIncome();
			double servicesIncome = p.getServicesIncome();
			double capitalIncome = p.getCapitalIncome();
			double healthSpeding = p.getHealthSpeding();
			double educationSpeding = p.getEducationSpeding();

			double grossTax = TaxPayer.grossTax(salaryIncome, servicesIncome, capitalIncome);
			double taxRebate = TaxPayer.taxRebate(grossTax, (healthSpeding + educationSpeding));

			System.out.println();
			System.out.println("Resumo do " + n + "º contribuinte");

			System.out.print("Imposto bruto total: ");
			System.out.printf("%.2f", grossTax );
			System.out.println();

			System.out.print("Abatimento: ");
			System.out.printf("%.2f", taxRebate);
			System.out.println();
			
			System.out.print("Imposto devido: ");
			System.out.printf("%.2f", TaxPayer.netTax(grossTax, taxRebate));
			System.out.println();
			System.out.println();
					

		}

	
	}

}
