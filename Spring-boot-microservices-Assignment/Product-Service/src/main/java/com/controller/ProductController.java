package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping(value = "getProduct/{id}")
	public Product getProductById(@PathVariable("id") int pid)
	{
		return productService.getProductById(pid);
	}
	
	@GetMapping(value = "getProductName/{id}")
	public String getProductNameById(@PathVariable("id") int pid)
	{
		return productService.getProductNameById(pid);
	}
	
	@PostMapping(value = "saveProduct")
	public String storeProduct(@RequestBody Product product)
	{
		return productService.storeProduct(product);
	}
	
	@GetMapping(value = "getAllProduct")
	public List<Product> getProducts()
	{
		return productService.getAllProducts();
	}
	
}
