package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> result = productRepo.findById(pid);
		if(result.isPresent())
		{
			return result.get();
		}
		else return null;
	}

	public String storeProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> result = productRepo.findById(product.getPid());
		if(result.isPresent())
		{
			return "Product already exists";
		}
		else 
		{
			productRepo.save(product);
			return "Product details stored successfully";
		}
	}


	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public String getProductNameById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> result = productRepo.findById(pid);
		if(result.isPresent())
		{
			Product pro = result.get();
			return pro.getpName();
		}
		else return "Product doesn't exist";
	}

}
