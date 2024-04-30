package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Product {
	@Id
	private int productId;
	private String productName;
	private String productBrand;
	private int productPrice;
    
}
