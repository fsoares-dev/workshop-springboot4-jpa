package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// a minha interface herda do JPA o meu service
public interface UserRepository extends JpaRepository<User, Long> {

}
