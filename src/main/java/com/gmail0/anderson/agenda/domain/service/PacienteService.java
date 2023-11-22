package com.gmail0.anderson.agenda.domain.service;

import com.gmail0.anderson.agenda.domain.entities.Paciente;
import com.gmail0.anderson.agenda.domain.repository.PacienteRepository;
import com.gmail0.anderson.agenda.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente salvar(Paciente paciente){
        boolean existeCpf = false;

        Optional<Paciente> byCpf = repository.findByCpf(paciente.getCpf());

        if (byCpf.isPresent()){
            if (!byCpf.get().getId().equals(paciente.getId())){
                existeCpf = true;
            }
        }
        if (existeCpf) throw new BusinessException("Cpf já cadastrado");

        return repository.save(paciente);
    }
    public List<Paciente> listarTodos(){
        return repository.findAll();
    }
    public Optional<Paciente> buscarPorId(Long id){
        return repository.findById(id);
    }
    public Paciente alterar(Paciente paciente){
        return repository.save(paciente);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
