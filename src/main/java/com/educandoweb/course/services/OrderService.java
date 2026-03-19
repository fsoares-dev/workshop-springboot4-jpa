package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //aqui eu "libero" minha classe para poder fazer a injeção de dependencia dela dentro do meu repository
public class OrderService {

    @Autowired
    private OrderRepository repository;

    //aqui eu tenho um retorno de todos os usuarios do meu banco de dados
    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> user = repository.findById(id); //aqui eu busco meu usuario por ID
        return user.get();
    }

}
