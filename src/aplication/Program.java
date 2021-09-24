package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Departament;
import entites.HourContract;
import entites.Worker;
import entitis.enums.WorkLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Entre com o nome do departamento: ");
		String name = sc.nextLine();
		System.out.println("Entre com o nome do funcionario");
		System.out.print("Name: ");
		String namefuncionario = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("BasaSalary: ");
		double baseSalary = sc.nextDouble();

		Worker w = new Worker(namefuncionario, WorkLevel.valueOf(level), baseSalary, new Departament(name ));
		
		System.out.println("Quantos contratos de trabalho? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("entre com o #" + (i+1)+"º contrato");
			System.out.println("Entre com a data: ");
			Date date = sdf.parse(sc.next());
			System.out.print("Valor por hora");
			double valuePetHour = sc.nextDouble();
			System.out.print("Horas trabalhadas");
			int hours = sc.nextInt();
			
			HourContract hc = new HourContract(date, valuePetHour, hours);
			w.addContract(hc);
		}
		System.out.println();
		System.out.print("Entre com o mes e ano dos contratos (MM/YYYY): ");
		String monthandyear = sc.next();
		int month = Integer.parseInt(monthandyear.substring(0, 2));
		int year = Integer.parseInt(monthandyear.substring(3));
	
		System.out.print("Name: " + w.getName());
		System.out.print("/nDepartamento" + w.getDepartamento().getName());
		System.out.print("/nSoma das horas trabalhadas na data " + monthandyear + ":  R$" + w.income(year, month));
		sc.close();
	}

}
