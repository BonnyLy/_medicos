package com.medicos.api.model.paciente;

import com.medicos.api.model.endereco.Endereco;
import com.medicos.api.model.medico.DadosAtualizacaoMedico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
