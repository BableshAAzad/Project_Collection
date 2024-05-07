package com.entity;

public class Laptop {
	private int laptopId;
	private String laptopModel;
	private String laptopBrand;
	private int laptopPrice;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int laptopId, String laptopModel, String laptopBrand, int laptopPrice) {
		super();
		this.laptopId = laptopId;
		this.laptopModel = laptopModel;
		this.laptopBrand = laptopBrand;
		this.laptopPrice = laptopPrice;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public int getLaptopPrice() {
		return laptopPrice;
	}

	public void setLaptopPrice(int laptopPrice) {
		this.laptopPrice = laptopPrice;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopModel=" + laptopModel + ", laptopBrand=" + laptopBrand
				+ ", laptopPrice=" + laptopPrice + "]";
	}

	
}
