package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductFeignService {
	
	@GetMapping(value = "product/getProduct/{id}")
	public Object getProductById(@PathVariable("id") int pid);
	
	@GetMapping(value = "product/getProductName/{id}")
	public String getProductNameById(@PathVariable("id") int pid);


}
