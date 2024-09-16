package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Order_New;

@Repository
public interface OrderRepository extends JpaRepository<Order_New, Integer>{

}
