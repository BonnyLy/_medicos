package com.medicos.api.model.consulta;

import java.time.LocalDateTime;

import com.medicos.api.model.medico.Medico;
import com.medicos.api.model.paciente.Paciente;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime data;
}
