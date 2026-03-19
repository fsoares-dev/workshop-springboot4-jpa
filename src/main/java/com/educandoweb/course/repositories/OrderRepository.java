package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// a minha interface herda do JPA o meu service
public interface OrderRepository extends JpaRepository<Order, Long> {

}
