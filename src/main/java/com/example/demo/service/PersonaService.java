package com.example.demo.service;

import com.example.demo.interfaz.IPerson;
import com.example.demo.interfazService.IPersonService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaService implements IPersonService {
    @Autowired
    private IPerson data;
    @Override
    public List<Person> listar() {
        return (List<Person>)data.findAll();
    }

    @Override
    public Optional<Person> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Person p) {
        int res=0;
        Person person=data.save(p);
        if(!person.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

}
