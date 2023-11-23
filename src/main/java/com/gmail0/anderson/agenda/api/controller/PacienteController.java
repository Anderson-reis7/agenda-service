package com.gmail0.anderson.agenda.api.controller;

import com.gmail0.anderson.agenda.api.mapper.PacienteMapper;
import com.gmail0.anderson.agenda.api.request.PacienteRequest;
import com.gmail0.anderson.agenda.api.response.PacienteResponse;
import com.gmail0.anderson.agenda.domain.entities.Paciente;
import com.gmail0.anderson.agenda.domain.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;
    private final PacienteMapper mapper;

    @PostMapping
    public ResponseEntity<PacienteResponse> salvar(@Valid @RequestBody PacienteRequest request) {
        Paciente paciente = mapper.toPaciente(request);
        Paciente pacienteSalvo = service.salvar(paciente);
        PacienteResponse pacienteResponse = mapper.toPacienteResponde(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        List<Paciente> pacientes = service.listarTodos();
        List<PacienteResponse> pacienteResponses = mapper.toPacienteResponseList(pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> paciente = service.buscarPorId(id);
        if (paciente.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPacienteResponde(paciente.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> alterar(@Valid @PathVariable Long id, @RequestBody PacienteRequest request) {
        Paciente paciente = mapper.toPaciente(request);
        Paciente alterar = service.alterar(id, paciente);
        PacienteResponse response = mapper.toPacienteResponde(alterar);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
