package com.mytheresa.product.ws.bean;

import lombok.Data;

@Data
public class PublicProduct {
	
	private String sku;
	private String name;
	private String category;
	private PublicPrice price;
	
}
