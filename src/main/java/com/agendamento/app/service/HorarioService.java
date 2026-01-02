package com.agendamento.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendamento.app.controller.dto.HorarioRequest;
import com.agendamento.app.domain.Horario;
import com.agendamento.app.domain.Profissional;
import com.agendamento.app.enums.StatusHorario;
import com.agendamento.app.repository.HorarioRepository;
import com.agendamento.app.repository.ProfissionalRepository;

import jakarta.transaction.Transactional;

@Service
public class HorarioService {

    private final HorarioRepository repository;
    private final ProfissionalRepository profissionalRepository;

    public HorarioService(HorarioRepository repository, ProfissionalRepository profissionalRepository) {
        this.repository = repository;
        this.profissionalRepository = profissionalRepository;
    }

    @Transactional
    public Horario create(HorarioRequest request) {
        Profissional profissional = profissionalRepository.findById(request.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        if (repository.existsByDataHoraAndProfissionalId(request.getDataHora(), request.getProfissionalId())) {
            throw new RuntimeException("Horário já cadastrado para este profissional");
        }

        Horario horario = new Horario();
        horario.setProfissional(profissional);
        horario.setDataHora(request.getDataHora());
        horario.setStatus(StatusHorario.DISPONIVEL);
        return repository.save(horario);
    }

    public List<Horario> findHorariosDisponiveis(StatusHorario status) {
        return repository.findByStatus(status);
    }

    public List<Horario> findHorariosDisponiveisPorProfissional(Long profissionalId) {
        return repository.findByProfissionalIdAndStatus(profissionalId, StatusHorario.DISPONIVEL);
    }

    
    public List<Horario> findHorariosReservadosPorProfissional(Long profissionalId) {
        return repository.findByProfissionalIdAndStatus(profissionalId, StatusHorario.RESERVADO);
    }


    public List<Horario> findHorariosByProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    public List<Horario> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
