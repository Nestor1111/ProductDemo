package com.mytheresa.product.service;

import java.io.IOException;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mytheresa.product.bean.Discount;
import com.mytheresa.product.bean.Product;
import com.mytheresa.product.util.Utils;
import com.mytheresa.product.ws.bean.ProductRequest;

@Service
public class ProductService {

	private static Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Value("${static.file.products}")
	private String productsPath;
	
	@Value("${static.file.discounts}")
	private String discountsPath;

	public List<Product> findProducts(ProductRequest request) throws IOException {
		return this.loadProducts().stream().filter(request.toPredicate()).collect(Collectors.toList());
	}

	private List<Product> loadProducts() throws IOException {
		String productsJson = Utils.readFileToString(productsPath);
		List<Product> productList = Utils.jsonToList(productsJson, Product.class);
		List<Discount> discountList = this.loadDiscounts();
		//Apply discounts
		productList.forEach(p -> {
			int totalDiscount = discountList.stream().filter(d -> d.toPredicate().test(p)).mapToInt(Discount::getDiscount).sum();
			p.getPrice().setFinalPrice(totalDiscount > 0 
					? p.getPrice().getOriginalPrice() - (p.getPrice().getOriginalPrice() * totalDiscount / 100) 
					: p.getPrice().getOriginalPrice());
			p.getPrice().setDiscountPercentage(totalDiscount > 0 ? totalDiscount + "%" : null);
		});
		return productList;
	}
	
	private List<Discount> loadDiscounts() throws IOException {
		String discountsJson = Utils.readFileToString(discountsPath);
		return Utils.jsonToList(discountsJson, Discount.class);
	}
}
