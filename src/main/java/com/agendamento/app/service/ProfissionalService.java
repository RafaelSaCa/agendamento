package com.agendamento.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendamento.app.domain.Profissional;
import com.agendamento.app.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public Profissional create(Profissional profissional) {
        return repository.save(profissional);
    }

    public Profissional update(Long id, Profissional profissional) {
        Profissional profissionalExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado."));

        if (profissional.getNome() != null) {
            profissionalExistente.setNome(profissional.getNome());
        }

        if (profissional.getTelefone() != null) {
            profissionalExistente.setTelefone(profissional.getTelefone());
        }

        return repository.save(profissionalExistente);
    }

    public List<Profissional> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
