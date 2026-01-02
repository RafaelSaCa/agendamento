package com.agendamento.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agendamento.app.controller.dto.AgendamentoRequest;
import com.agendamento.app.domain.Agendamento;
import com.agendamento.app.service.AgendamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Agendamento> create (@RequestBody @Valid AgendamentoRequest request){
        Agendamento agendamento = service.create(request);
        
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(agendamento.getId())
            .toUri();

        return ResponseEntity.created(location).body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> findAll(){
        List<Agendamento> agendamentos = service.findAll();
        return ResponseEntity.ok().body(agendamentos);

    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Agendamento> cancelar (@PathVariable Long id){
        Agendamento agendamento = service.cancelar(id);
        return ResponseEntity.ok().body(agendamento);
    }

    @PatchMapping("/{id}/finalizar")
    public ResponseEntity<Agendamento> finalizar (@PathVariable Long id){
        Agendamento agendamento = service.finalizar(id);
        return ResponseEntity.ok().body(agendamento);
    }


}
