package com.gmail0.anderson.agenda.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(name = "data_hora")
    private LocalDateTime horario;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Paciente paciente;

}
