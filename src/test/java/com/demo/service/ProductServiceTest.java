package com.demo.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.demo.models.Product;
import com.demo.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	
	@BeforeEach 
	public void init() { 
		MockitoAnnotations.openMocks(this); 
	}
	
	
	@Test
	public void createProduct_NormalCondition_shouldReturnNewProduct() {	
		when(productRepository.save(Mockito.any(Product.class)))
			.thenAnswer(i -> i.getArguments()[0]);
		
		java.sql.Date date = new java.sql.Date(2021, 4, 5); 		
		Product createdProduct = productService.createNewProduct("table", date, "Vietnam", 123f);
		
		assertEquals(createdProduct.getProductName(), "table");		
		assertEquals(createdProduct.getOrigin(), "Vietnam");
		assertEquals(createdProduct.getPrice(), 123f);
		assertEquals(createdProduct.getProductDate(), date);
	}
}
