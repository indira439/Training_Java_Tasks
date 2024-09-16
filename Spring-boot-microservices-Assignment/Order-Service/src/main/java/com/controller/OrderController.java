package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order_New;
import com.service.OrderService;

@RestController
@RequestMapping(value = "order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping(value = "getOrder/{id}")
	public Order_New getOrderById(@PathVariable("id") int id)
	{
		return orderService.getOrderById(id);
	}
	
	@PostMapping(value = "placeOrder")
	public String placeOrder(@RequestBody Order_New order)
	{
		return orderService.placeOrder(order);
	}
	
	@GetMapping(value = "getAllOrders")
	public List<Order_New> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
}
