package com.medicos.api.model.medico;

import com.medicos.api.model.endereco.Endereco;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //vai ser uma Primary-Key
    private String nome;
    private String email;
    private String crm;
    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco enderco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.enderco = new Endereco(dados.endereco());
    }

    //Método responsável por realzar a verificação de qual campo está sendo atualizado.
    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
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










