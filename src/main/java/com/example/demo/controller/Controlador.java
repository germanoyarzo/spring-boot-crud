package com.example.demo.controller;

import com.example.demo.interfazService.IPersonService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {
    @Autowired
    private IPersonService service;


    @GetMapping("/listar") //al ingresar al url listar traera toda la tabla con las personas
    public String listar(Model model){
        List<Person>persons= service.listar();
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("person", new Person());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Validated Person p, Model model){
        service.save(p);
        return "redirect:/listar";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Optional<Person> person= service.listarId(id);
        model.addAttribute("person", person);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/listar";
    }
}
