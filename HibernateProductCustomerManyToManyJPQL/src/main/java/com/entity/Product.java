package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productBrand;
    private int productPrice;
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<Customer> customers;
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productPrice=" + productPrice + "]";
	}
    
    
}
