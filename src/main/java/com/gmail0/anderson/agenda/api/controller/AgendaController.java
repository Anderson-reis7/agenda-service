package com.gmail0.anderson.agenda.api.controller;

import com.gmail0.anderson.agenda.api.mapper.AgendaMapper;
import com.gmail0.anderson.agenda.api.request.AgendaRequest;
import com.gmail0.anderson.agenda.api.response.AgendaResponse;
import com.gmail0.anderson.agenda.domain.entities.Agenda;
import com.gmail0.anderson.agenda.domain.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService service;
    private final AgendaMapper mapper;

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> buscarTodos() {
        List<Agenda> listaTodos = service.listaTodos();
        List<AgendaResponse> agendaResponseList = mapper.toAgendaResponseList(listaTodos);
        return ResponseEntity.status(HttpStatus.OK).body(agendaResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponse> buscarPorId(@PathVariable Long id) {
        Optional<Agenda> agenda = service.buscarPorId(id);
        if (agenda.isEmpty()) ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toAgendaResponse(agenda.get()));
    }

    @PostMapping
    public ResponseEntity<AgendaResponse> cadastrar(@Valid @RequestBody AgendaRequest request) {
        Agenda agenda = mapper.toAgenda(request);
        Agenda salvar = service.salvar(agenda);
        AgendaResponse agendaResponse = mapper.toAgendaResponse(salvar);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaResponse);
    }

}
