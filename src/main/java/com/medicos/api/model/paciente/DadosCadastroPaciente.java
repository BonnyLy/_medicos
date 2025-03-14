package com.medicos.api.model.paciente;

import com.medicos.api.model.endereco.DadosEndereco;




public record DadosCadastroPaciente(String nome, String email, String telefone, String senha, DadosEndereco endereco) {
    
}
