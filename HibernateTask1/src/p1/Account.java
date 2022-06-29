package p1;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;


@Entity
@Table(name="Account")
public class Account implements Serializable, Comparator<Account> {
	

	private static final long serialVersionUID = 1L;
	@Column(name="accountNumber")
	@Id 
	private int accountNumber;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private int phone;
	
	@Embedded
	@AttributeOverrides({
		 @AttributeOverride(name="insuranceNumber", column=@Column(name="medical_insuranceNumber")),
		 @AttributeOverride(name="insuranceType", column=@Column(name="medical_insuranceType")),
		 @AttributeOverride(name="expireAt", column=@Column(name="medical_expireAt")),
	})
	private Insurance medicalInsurance;
	
	@Embedded
	@AttributeOverrides({
		 @AttributeOverride(name="insuranceNumber", column=@Column(name="car_insuranceNumber")),
		 @AttributeOverride(name="insuranceType", column=@Column(name="car_insuranceType")),
		 @AttributeOverride(name="expireAt", column=@Column(name="car_expireAt")),
	})
	private Insurance carInsurance;
	
	@Embedded
	@AttributeOverrides({
		 @AttributeOverride(name="insuranceNumber", column=@Column(name="health_insuranceNumber")),
		 @AttributeOverride(name="insuranceType", column=@Column(name="health_insuranceType")),
		 @AttributeOverride(name="expireAt", column=@Column(name="health_expireAt")),
	})
	private Insurance healthInsurance;
	
	@ElementCollection
	private List<Transactions> allTransactions;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int accountNumber, String name, int phone) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.phone = phone;
	}
	
	

	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Insurance getMedicalInsurance() {
		return medicalInsurance;
	}


	public void setMedicalInsurance(Insurance medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}


	public Insurance getCarInsurance() {
		return carInsurance;
	}


	public void setCarInsurance(Insurance carInsurance) {
		this.carInsurance = carInsurance;
	}


	public Insurance getHealthInsurance() {
		return healthInsurance;
	}


	public void setHealthInsurance(Insurance healthInsurance) {
		this.healthInsurance = healthInsurance;
	}


	public List<Transactions> getAllTransactions() {
		return allTransactions;
	}


	public void setAllTransactions(List<Transactions> allTransactions) {
		this.allTransactions = allTransactions;
	}
	
	

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", phone=" + phone + ", allTransactions="
				+ allTransactions + "]";
	}


	@Override
	public int compare(Account a, Account a1) {
		
		return a.getAccountNumber() - a1.getAccountNumber();
	}

}
