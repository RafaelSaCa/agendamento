package com.agendamento.app.controller.dto;

import jakarta.validation.constraints.NotNull;

public class AgendamentoRequest {

    @NotNull(message = "O ID do horário é obrigatório")
    private Long horarioId;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    public AgendamentoRequest(Long horarioId, Long usuarioId) {
        this.horarioId = horarioId;
        this.usuarioId = usuarioId;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
