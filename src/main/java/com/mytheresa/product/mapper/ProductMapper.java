package com.mytheresa.product.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytheresa.product.bean.Product;
import com.mytheresa.product.ws.bean.PublicProduct;

@Component
public class ProductMapper {
	
	@Autowired
	private PriceMapper priceMapper;
	
	public PublicProduct fromServer(Product product) {
		PublicProduct publicProduct = new PublicProduct();
		publicProduct.setSku(product.getSku());
		publicProduct.setName(product.getName());
		publicProduct.setCategory(product.getCategory());
		publicProduct.setPrice(this.priceMapper.fromServer(product.getPrice()));
		return publicProduct;
	}

}
