package com.agendamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.app.domain.Agendamento;
import com.agendamento.app.enums.StatusAgendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Agendamento findByStatus (StatusAgendamento status);

    
}
