package p1;

import javax.persistence.Embeddable;

@Embeddable
public class Insurance {
	private int insuranceNumber;
	private String insuranceType;
	private String expireAt;
	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(int insuranceNumber, String insuranceType, String expireAt) {
		super();
		this.insuranceNumber = insuranceNumber;
		this.insuranceType = insuranceType;
		this.expireAt = expireAt;
	}

	public int getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(int insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}
	
	
	
}
