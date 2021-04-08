package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	

	@RequestMapping(value = {"/Form" }, method = RequestMethod.GET)
    public String showForm(Model mode) {		
		return "form";
	}
	
	@RequestMapping(value = {"/CreateProduct" }, method = RequestMethod.POST)
    public String createProduct(Model model, @RequestParam String productName, @RequestParam java.sql.Date productDate, 
    		@RequestParam String origin, @RequestParam Float price) {
		System.out.println(productName + ", " + productDate);
		productService.createNewProduct(productName,  productDate, origin, price);
		return "success";
	}
	
	@RequestMapping(value = {"/ProductList" }, method = RequestMethod.GET)
    public String productList(HttpServletRequest request) {
		List<Product> productList = productService.getAll();
		request.setAttribute("productList", productList);
		return "list";
	}
}
