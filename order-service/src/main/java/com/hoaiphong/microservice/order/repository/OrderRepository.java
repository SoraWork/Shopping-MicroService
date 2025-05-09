package com.hoaiphong.microservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoaiphong.microservice.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
