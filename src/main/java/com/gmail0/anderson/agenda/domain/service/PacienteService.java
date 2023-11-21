package com.gmail0.anderson.agenda.domain.service;

import com.gmail0.anderson.agenda.domain.entities.Paciente;
import com.gmail0.anderson.agenda.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente){

        //TODO: para validar se o cpf já existe

        return repository.save(paciente);
    }
    public List<Paciente> listarTodos(){
        return repository.findAll();
    }
    public Paciente buscarPorId(Long id){
        Optional<Paciente> byId = repository.findById(id);
        return byId.orElse(null);
    }
    public Paciente alterar(Paciente paciente){
        return repository.save(paciente);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
