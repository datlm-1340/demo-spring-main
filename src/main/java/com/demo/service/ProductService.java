package com.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.models.Product;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product createNewProduct(String productName, Date productDate, String origin, Float price) {
		Product product = new Product();
		product.setProductName(productName);
		product.setProductDate(productDate);
		product.setOrigin(origin);
		product.setPrice(price);
		product = productRepository.save(product);
		
		return product;
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
