package com.medicos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicos.api.model.paciente.DadosAtualizacaoPaciente;
import com.medicos.api.model.paciente.DadosCadastroPaciente;
import com.medicos.api.model.paciente.Paciente;
import com.medicos.api.model.paciente.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired 
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados) {
        var medico = pacienteRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        var medico = pacienteRepository.getReferenceById(id);
        medico.exclusaoLogica();
    }

}
