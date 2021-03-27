package com.mytheresa.product.ws.bean;

import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mytheresa.product.bean.Product;

import lombok.Data;

@Data
public class ProductRequest {

	private static Logger LOG = LoggerFactory.getLogger(ProductRequest.class);
	
	private String category;
	private String price;
	
	public Predicate<Product> toPredicate() {
		Predicate<Product> predicate = (p) -> p != null;
		if(category!=null && !category.isBlank()) {
			predicate = predicate.and((p) -> category.equals(p.getCategory()));
		}
		if(price!=null && !price.isBlank()) {
			try{
	            Integer amount = Integer.parseInt(price);
				//Discount is applied to prices over this
				predicate = predicate.and((p) -> amount.compareTo(p.getPrice().getOriginalPrice()) < 0);
	        }
	        catch (NumberFormatException ex){
	        	LOG.error("Price on request is not a number");
	            ex.printStackTrace();
	        }
		}
		return predicate;
	}
}
