package com.mytheresa.product.bean;

import lombok.Data;

@Data
public class Price {

	private Integer originalPrice;
	private Integer finalPrice;
	private String discountPercentage;
	
}
