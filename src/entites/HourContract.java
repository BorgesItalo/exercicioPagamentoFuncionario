package entites;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valuePetHour;
	private Integer hours;

	public HourContract() {

	}

	public HourContract(Date date, Double valuePetHour, Integer hours) {
		super();
		this.date = date;
		this.valuePetHour = valuePetHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePetHour() {
		return valuePetHour;
	}

	public void setValuePetHour(Double valuePetHour) {
		this.valuePetHour = valuePetHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double totalValue() {
		return valuePetHour * hours;
	}

}
