package com.medicos.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/olamundo") //Informa qual será o endpoint acessado que vai chamar a classe OlaMundo
@RestController //Informa ao sprin boot que a classe OlaMundo é uma classe tipo controladora. 
public class OlaMundo {
    @GetMapping //Informa que o método será invocado quando um get acontecer 
    public String olaMundo() {
        return "Olá Mundo";
    }
    
}

