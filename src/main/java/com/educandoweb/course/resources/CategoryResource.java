package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

        @Autowired
        private CategoryService service;

        //esta escrito basicamente, em uma lista de categorias, quando o método for chamado ele deve retornar todas as categorias
        @GetMapping
        public ResponseEntity<List<Category>> findAll(){
            List<Category> categories = service.findAll();
            return ResponseEntity.ok().body(categories);
        }

        //mesma coisa que o método acima, mas aqui ele busca diretamente pelo id da categoria por meio de uma interpolação
        @GetMapping(value = "/{id}")
        public ResponseEntity<Category> findById(@PathVariable Long id){
            Category obj = service.findById(id);
            return ResponseEntity.ok().body(obj);
        }

}
