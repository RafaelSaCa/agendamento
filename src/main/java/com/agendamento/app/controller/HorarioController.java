package com.agendamento.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.app.controller.dto.HorarioRequest;
import com.agendamento.app.domain.Horario;
import com.agendamento.app.enums.StatusHorario;
import com.agendamento.app.service.HorarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    private final HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Horario> create(@RequestBody @Valid HorarioRequest horario) {
        Horario novoHorario = service.create(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHorario);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Horario>> getHorariosDisponiveis() {
        List<Horario> horarios = service.findHorariosDisponiveis(StatusHorario.DISPONIVEL);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/disponiveis/profissional/{profissionalId}")
    public ResponseEntity<List<Horario>> getHorariosDisponiveisPorProfissioal(@PathVariable Long profissionalId) {
        List<Horario> horarios = service.findHorariosDisponiveisPorProfissional(profissionalId);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/reservados")
    public ResponseEntity<List<Horario>> getHorariosReservados() {
        List<Horario> horarios = service.findHorariosDisponiveis(StatusHorario.RESERVADO);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/reservados/profissional/{profissionalId}")
    public ResponseEntity<List<Horario>> getHorariosReservadosPorProfissional( @PathVariable long profissionalId) {
        List<Horario> horarios = service.findHorariosReservadosPorProfissional(profissionalId);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping
    public ResponseEntity<List<Horario>> getAll() {
        List<Horario> horarios = service.findAll();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity<List<Horario>> getHorariosByProfisisonal(@PathVariable Long profissionalId) {
        List<Horario> horarios = service.findHorariosByProfissional(profissionalId);
        return ResponseEntity.ok(horarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
