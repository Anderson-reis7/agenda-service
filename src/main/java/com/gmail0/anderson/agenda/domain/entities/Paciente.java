package com.gmail0.anderson.agenda.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private  String sobrenome;
    private  String email;
    private  String cpf;
}
