package com.gmail0.anderson.agenda.domain.service;

import com.gmail0.anderson.agenda.domain.entities.Agenda;
import com.gmail0.anderson.agenda.domain.entities.Paciente;
import com.gmail0.anderson.agenda.domain.repository.AgendaRepository;
import com.gmail0.anderson.agenda.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;
    private final PacienteService service;

    public List<Agenda> listaTodos() {
        return repository.findAll();
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agenda salvar(Agenda agenda) {
        Optional<Paciente> optionalPaciente = service.buscarPorId(agenda.getPaciente().getId());
        if (optionalPaciente.isEmpty()) throw new BusinessException("Paciente não encontrado");
        Optional<Agenda> byHorario = repository.findByHorario(agenda.getHorario());
        if (byHorario.isPresent()) throw new BusinessException("Horário não está disponivel!");
        agenda.setPaciente(optionalPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());
        return repository.save(agenda);
    }
}
