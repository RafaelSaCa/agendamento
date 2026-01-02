package com.agendamento.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.agendamento.app.domain.Horario;
import com.agendamento.app.enums.StatusHorario;

import jakarta.persistence.LockModeType;

public interface HorarioRepository extends JpaRepository<Horario, Long> {


   @Lock(LockModeType.PESSIMISTIC_WRITE)
   Optional<Horario> findById(Long id);   

   boolean existsByDataHoraAndProfissionalId(LocalDateTime dataHora, Long profissionalId);

   List<Horario> findByProfissionalId(Long profissionalId);

   List<Horario> findByStatus(StatusHorario status);

   List<Horario> findByProfissionalIdAndStatus(Long profissionalId, StatusHorario status);

}
