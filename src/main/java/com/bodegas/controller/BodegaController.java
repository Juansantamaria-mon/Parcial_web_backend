package com.bodegas.controller;

import com.bodegas.dto.BodegaDto;
import com.bodegas.service.BodegaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    private final BodegaService service;

    public BodegaController(BodegaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BodegaDto> create(@Valid @RequestBody BodegaDto dto) {
        BodegaDto creada = service.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creada.getId())
                .toUri();
        return ResponseEntity.created(location).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<BodegaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
