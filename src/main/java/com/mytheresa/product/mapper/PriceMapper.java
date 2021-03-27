package com.mytheresa.product.mapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mytheresa.product.bean.Price;
import com.mytheresa.product.ws.bean.PublicPrice;

@Component
public class PriceMapper {
	
	@Value("${currency}")
	private String currency;
	
	public PublicPrice fromServer(Price price) {
		PublicPrice publicPrice = new PublicPrice();
		publicPrice.setOriginalPrice(price.getOriginalPrice());
		publicPrice.setFinalPrice(price.getFinalPrice());
		publicPrice.setDiscountPercentage(price.getDiscountPercentage());
		publicPrice.setCurrency(currency);
		return publicPrice;
	}

}
