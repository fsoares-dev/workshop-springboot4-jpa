package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id)); //tenta fazer o get, se nao tiver usuario ele lança exceção
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id); //aqui ele esta preparando o objeto monitorado para podermos atualizar
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName()); //atualizando nome
        entity.setEmail(user.getEmail()); //atualizando email
        entity.setPhone(user.getPhone()); //atualizando telefone
    }

}
