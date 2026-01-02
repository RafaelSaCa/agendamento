package com.agendamento.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.app.domain.Profissional;
import com.agendamento.app.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Profissional> create (@RequestBody Profissional profissional){
        Profissional novoProfissional = service.create(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfissional);
    }


    @GetMapping
    public ResponseEntity<List<Profissional>> findAll(){
        List<Profissional> listaProfissionais = service.findAll();
        return ResponseEntity.ok(listaProfissionais);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profissional> update (@PathVariable Long id, @RequestBody Profissional profissional){
        Profissional profissionalAtualizado = service.update(id,profissional);
        return ResponseEntity.ok(profissionalAtualizado);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
