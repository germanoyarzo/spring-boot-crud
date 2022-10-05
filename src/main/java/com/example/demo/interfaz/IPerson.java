package com.example.demo.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerson extends CrudRepository<Person, Integer>{

}
