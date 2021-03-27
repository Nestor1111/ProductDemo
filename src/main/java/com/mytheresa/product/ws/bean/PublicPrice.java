package com.mytheresa.product.ws.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PublicPrice {

	@JsonProperty("original")
	private Integer originalPrice;
	
	@JsonProperty("final")
	private Integer finalPrice;
	
	@JsonProperty("discount_percentage")
	private String discountPercentage;
	
	@JsonProperty("currency")
	private String currency;
	
}
