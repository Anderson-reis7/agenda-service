package com.gmail0.anderson.agenda.api.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteRequest {
    @NotBlank(message = "O nome do paciente é obrigatório!")
    private String nome;
    @NotBlank(message = "O Sobrenome do paciente é obrigatório!")
    private String sobrenome;
    private String email;
    @NotBlank(message = "O CPF do paciente é obrigatório!")
    private String cpf;
}
