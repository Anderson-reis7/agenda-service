package com.gmail0.anderson.agenda.domain.repository;

import com.gmail0.anderson.agenda.domain.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendaRepository extends
        JpaRepository<Agenda, Long> {
    Optional<Agenda> findByHorario(LocalDateTime horario);

}
