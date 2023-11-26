package com.gmail0.anderson.agenda.api.mapper;

import com.gmail0.anderson.agenda.api.request.PacienteRequest;
import com.gmail0.anderson.agenda.api.response.PacienteResponse;
import com.gmail0.anderson.agenda.domain.entities.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest request) {
        return mapper.map(request, Paciente.class);
    }
//    public static Paciente toPaciente(PacienteRequest request){
//        Paciente paciente = new Paciente();
//        paciente.setNome(request.getNome());
//        paciente.setSobrenome(request.getSobrenome());
//        paciente.setEmail(request.getEmail());
//        paciente.setCpf(request.getCpf());
//        return paciente;
//    }

    public PacienteResponse toPacienteResponde(Paciente paciente) {
        return mapper.map(paciente, PacienteResponse.class);
    }
//    public static PacienteResponse toPacienteResponde(Paciente paciente){
//        PacienteResponse pacienteResponse = new PacienteResponse();
//        pacienteResponse.setId(paciente.getId());
//        pacienteResponse.setNome(paciente.getNome());
//        pacienteResponse.setSobrenome(paciente.getSobrenome());
//        pacienteResponse.setEmail(paciente.getEmail());
//        pacienteResponse.setCpf(paciente.getCpf());
//        return pacienteResponse;
//    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::toPacienteResponde)
                .collect(Collectors.toList());


    }
}
