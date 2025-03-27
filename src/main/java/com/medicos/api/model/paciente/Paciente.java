package com.medicos.api.model.paciente;

import com.medicos.api.model.endereco.Endereco;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //vai ser uma Primary-Key
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Boolean ativo = true;

    @Embedded
    private Endereco enderco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.senha = dados.senha();
        this.enderco = new Endereco(dados.endereco());
    }

        public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.endereco() != null) {
            this.enderco.atualizarInformacoes(dados.endereco());
        }
    }

    public void exclusaoLogica() {
        this.ativo = false;
    }


}
