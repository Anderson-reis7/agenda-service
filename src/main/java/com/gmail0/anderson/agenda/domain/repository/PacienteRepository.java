package com.gmail0.anderson.agenda.domain.repository;

import com.gmail0.anderson.agenda.domain.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends
        JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(String cpf);
}
