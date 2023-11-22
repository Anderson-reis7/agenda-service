package com.gmail0.anderson.agenda.api.mapper;

import com.gmail0.anderson.agenda.api.request.PacienteRequest;
import com.gmail0.anderson.agenda.api.response.PacienteResponse;
import com.gmail0.anderson.agenda.domain.entities.Paciente;

public class PacienteMapper {
    public static Paciente toPaciente(PacienteRequest request){
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setSobrenome(request.getSobrenome());
        paciente.setEmail(request.getEmail());
        paciente.setCpf(request.getCpf());
        return paciente;
    }
    public static PacienteResponse toPacienteRequest(Paciente paciente){
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setSobrenome(paciente.getSobrenome());
        pacienteResponse.setEmail(paciente.getEmail());
        pacienteResponse.setCpf(paciente.getCpf());
        return pacienteResponse;
    }
}
