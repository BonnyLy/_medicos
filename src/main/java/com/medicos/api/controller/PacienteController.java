package com.medicos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicos.api.model.paciente.DadosCadastroPaciente;
import com.medicos.api.model.paciente.Paciente;
import com.medicos.api.model.paciente.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired //Sobreescrevendo algo, é um padrão utilizado na injeção de dependencia
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
