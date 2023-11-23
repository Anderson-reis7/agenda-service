package com.gmail0.anderson.agenda.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;


}
