package com.mytheresa.product.ws.bean;

import java.util.List;

import lombok.Data;

@Data
public class PublicProductList {
	
	private List<PublicProduct> products;
	
	public PublicProductList(List<PublicProduct> products) {
		this.products = products;
	}
	
}
