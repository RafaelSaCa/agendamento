package com.agendamento.app.domain;

import java.time.LocalDateTime;

import com.agendamento.app.enums.StatusHorario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusHorario status;

    public Horario() {
    }

    public Horario(Long id, LocalDateTime dataHora, Profissional profissional, StatusHorario status) {
        this.id = id;
        this.dataHora = dataHora;
        this.profissional = profissional;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public StatusHorario getStatus() {
        return status;
    }

    public void setStatus(StatusHorario status) {
        this.status = status;
    }

}
