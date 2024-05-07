package com.entity;

public class Gadget {
	private Laptop laptop;
	private Laptop laptop1;
	private Mobile mobile;
	private Mobile mobile1;

	public Gadget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gadget(Laptop laptop, Mobile mobile) {
		super();
		this.laptop = laptop;
		this.mobile = mobile;
	}

	public Gadget(Laptop laptop, Laptop laptop1, Mobile mobile, Mobile mobile1) {
		super();
		this.laptop = laptop;
		this.laptop1 = laptop1;
		this.mobile = mobile;
		this.mobile1 = mobile1;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Laptop getLaptop1() {
		return laptop1;
	}

	public void setLaptop1(Laptop laptop1) {
		this.laptop1 = laptop1;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Mobile getMobile1() {
		return mobile1;
	}

	public void setMobile1(Mobile mobile1) {
		this.mobile1 = mobile1;
	}

	@Override
	public String toString() {
		return "Gadget [laptop=" + laptop + ", laptop1=" + laptop1 + ", mobile=" + mobile + ", mobile1=" + mobile1
				+ "]";
	}

//	@Override
//	public String toString() {
//		return "Gadget [laptop=" + laptop + ", mobile=" + mobile + "]";
//	}

}
