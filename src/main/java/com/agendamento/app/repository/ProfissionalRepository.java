package com.agendamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.app.domain.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
