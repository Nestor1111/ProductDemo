package com.mytheresa.product.ws;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytheresa.product.bean.Product;
import com.mytheresa.product.mapper.ProductMapper;
import com.mytheresa.product.service.ProductService;
import com.mytheresa.product.ws.bean.ProductRequest;
import com.mytheresa.product.ws.bean.PublicProductList;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductMapper productMapper;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PublicProductList findProducts(ProductRequest request) throws IOException {
		LOG.info("List of products by {}", request);
		List<Product> productList = this.productService.findProducts(request);		
		return new PublicProductList(productList.stream().map(productMapper::fromServer)
				.collect(Collectors.toList()));
	}

}
