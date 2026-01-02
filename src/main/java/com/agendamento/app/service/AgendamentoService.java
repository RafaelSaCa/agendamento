package com.agendamento.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendamento.app.controller.dto.AgendamentoRequest;
import com.agendamento.app.domain.Agendamento;
import com.agendamento.app.domain.Horario;
import com.agendamento.app.domain.User;
import com.agendamento.app.enums.StatusAgendamento;
import com.agendamento.app.enums.StatusHorario;
import com.agendamento.app.repository.AgendamentoRepository;
import com.agendamento.app.repository.HorarioRepository;
import com.agendamento.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final HorarioRepository horarioRepository;
    private final UserRepository usuarioRepository;

    public AgendamentoService(AgendamentoRepository repository, HorarioRepository horarioRepository,
            UserRepository usuarioRepository) {
        this.repository = repository;
        this.horarioRepository = horarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Agendamento create(AgendamentoRequest request) {

        // busca do usuario não vai existir quando implementar autenticação
        User usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Horario horario = horarioRepository.findById(request.getHorarioId())
                .orElseThrow(() -> new RuntimeException("Horário não encontrado!"));

        if (horario.getStatus().toString().equals("RESERVADO")) {
            throw new RuntimeException("Horário indisponível! Escolha outro horário.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setHorario(horario);
        agendamento.setUsuario(usuario);
        agendamento.setStatus(StatusAgendamento.CRIADO);

        horario.setStatus(StatusHorario.RESERVADO);

        return repository.save(agendamento);
    }

    public List<Agendamento> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Agendamento cancelar(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));

        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw new RuntimeException("Agendamento já está cancelado!");
        }

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamento.getHorario().setStatus(StatusHorario.DISPONIVEL);

        return agendamento;
    }

    @Transactional
    public Agendamento finalizar(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));

        if (agendamento.getStatus() == StatusAgendamento.FINALIZADO) {
            throw new RuntimeException("Não é possível finalizar um agendamento já finalizado!");
        }

        agendamento.setStatus(StatusAgendamento.FINALIZADO);

        return agendamento;
    }

}
