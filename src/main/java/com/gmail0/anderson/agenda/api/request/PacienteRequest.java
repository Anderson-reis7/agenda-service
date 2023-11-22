package com.gmail0.anderson.agenda.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteRequest {

    private String nome;
    private  String sobrenome;
    private  String email;
    private  String cpf;
}
