package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService(){
        //Create TodoEntity
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        //Save TodoEntity
        repository.save(entity);
        //Search TodoEntity
        TodoEntity savedEntity = repository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }
}