package com.mytheresa.product.bean;

import java.util.function.Predicate;

import lombok.Data;

@Data
public class Discount {

	private String sku;
	private String name;
	private String category;
	private Integer price;
	private Integer discount;
	
	public Predicate<Product> toPredicate() {
		Predicate<Product> predicate = (p) -> p != null;
		if(sku!=null && !sku.isBlank()) {
			predicate = predicate.and((p) -> sku.equals(p.getSku()));
		}
		if(category!=null && !category.isBlank()) {
			predicate = predicate.and((p) -> category.equals(p.getCategory()));
		}
		if(name!=null && !name.isBlank()) {
			predicate = predicate.and((p) -> name.equals(p.getName()));
		}
		if(price!=null) {
			//Discount is applied to prices over this
			predicate = predicate.and((p) -> price.compareTo(p.getPrice().getOriginalPrice()) < 0);
		}
		return predicate;
	}
}
