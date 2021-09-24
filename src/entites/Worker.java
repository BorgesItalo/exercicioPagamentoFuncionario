package entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import entitis.enums.WorkLevel;

public class Worker {

	private String name;
	private WorkLevel level;
	private Double baseSalary;

	private Departament departamento;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String name, WorkLevel level, Double baseSalary, Departament departamento) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departament departamento) {
		this.departamento = departamento;
	}

	public List<HourContract> getcontracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;

	}

}