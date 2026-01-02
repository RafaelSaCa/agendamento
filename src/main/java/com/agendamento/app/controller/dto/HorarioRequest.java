package com.agendamento.app.controller.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class HorarioRequest {

    @Future
    @NotNull(message = "Data e hora são obrigatórios! Informe uma data futura.")
    private LocalDateTime dataHora;

    @NotNull(message = "Id do profissional é obrigatório")
    private Long profissionalId;

    public HorarioRequest(LocalDateTime dataHora,Long profissionalId) {
        this.dataHora = dataHora;
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

}
