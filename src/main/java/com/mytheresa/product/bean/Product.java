package com.mytheresa.product.bean;

import lombok.Data;

@Data
public class Product {

	private String sku;
	private String name;
	private String category;
	private Price price;
	
	public void setPrice(Integer price) {
		this.price = new Price();
		this.price.setOriginalPrice(price);
	}
}
