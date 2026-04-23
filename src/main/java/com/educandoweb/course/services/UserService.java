package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //aqui eu "libero" minha classe para poder fazer a injeção de dependencia dela dentro do meu repository
public class UserService {

    @Autowired
    private UserRepository repository;

    //aqui eu tenho um retorno de todos os usuarios do meu banco de dados
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id); //aqui eu busco meu usuario por ID
        return user.get();
    }

    public User insert(User user){
        return repository.save(user);
    }

}
