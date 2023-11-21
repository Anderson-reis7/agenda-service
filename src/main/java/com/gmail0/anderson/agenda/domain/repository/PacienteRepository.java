package com.gmail0.anderson.agenda.domain.repository;

import com.gmail0.anderson.agenda.domain.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends
        JpaRepository<Paciente, Long> {
}
