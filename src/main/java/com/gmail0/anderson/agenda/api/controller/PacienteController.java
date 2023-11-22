package com.gmail0.anderson.agenda.api.controller;

import com.gmail0.anderson.agenda.api.mapper.PacienteMapper;
import com.gmail0.anderson.agenda.api.request.PacienteRequest;
import com.gmail0.anderson.agenda.api.response.PacienteResponse;
import com.gmail0.anderson.agenda.domain.entities.Paciente;
import com.gmail0.anderson.agenda.domain.service.PacienteService;
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
    @PostMapping
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest request){
        Paciente paciente = PacienteMapper.toPaciente(request);
        Paciente pacienteSalvo = service.salvar(paciente);
        PacienteResponse pacienteResponse = PacienteMapper.toPacienteRequest(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id){
        Optional<Paciente> paciente = service.buscarPorId(id);
        return paciente.map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping
    public ResponseEntity<Paciente> alterar(@RequestBody Paciente paciente){
        Paciente alterar = service.alterar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(alterar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
