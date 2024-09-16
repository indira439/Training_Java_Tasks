package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Order_New;
import com.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductFeignService productFS;
	
	@Autowired 
	RestTemplate restTemplate;

	public Order_New getOrderById(int id) {
		// TODO Auto-generated method stub
		Optional<Order_New> result = orderRepo.findById(id);
		if(result.isPresent())
		{
			return result.get();
		}
		return null;
	}

	public String placeOrder(Order_New order) {
		// TODO Auto-generated method stub
		int userId = order.getUserId();
		int productId = order.getProductId();
	
		if(restTemplate.getForObject("http://USER-SERVICE/user/getUser/"+userId, Object.class) == null)
		{
			return "User doesn't exists";
		}
		else if(productFS.getProductById(productId) == null)
		{
			return "Product doesn't exists";
		}
		else
		{
			order.setUserName(restTemplate.getForObject("http://USER-SERVICE/user/getUserName/"+userId, String.class));
			order.setProductName(productFS.getProductNameById(productId));
			orderRepo.save(order);
			return "Order placed successfully";
		}
	}

	public List<Order_New> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

}
