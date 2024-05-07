package com.entity;

public class Mobile {
	private int mobileId;
	private String mobileName;
	private String mobileBrand;
	private int mobilePrice;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(int mobileId, String mobileName, String mobileBrand, int mobilePrice) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileBrand = mobileBrand;
		this.mobilePrice = mobilePrice;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public int getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(int mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileBrand=" + mobileBrand
				+ ", mobilePrice=" + mobilePrice + "]";
	}
	
	

}
