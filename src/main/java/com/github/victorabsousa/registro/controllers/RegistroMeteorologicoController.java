
package com.github.victorabsousa.registro.controllers;

import com.github.victorabsousa.registro.dtos.RegistroMeteorologicoRequestDTO;
import com.github.victorabsousa.registro.dtos.RegistroMeteorologicoResponseDTO;
import com.github.victorabsousa.registro.services.RegistroMeteorologicoService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroMeteorologicoController {

    private final RegistroMeteorologicoService service;

    public RegistroMeteorologicoController(
            RegistroMeteorologicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegistroMeteorologicoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public RegistroMeteorologicoResponseDTO buscarPorId(
            @PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<RegistroMeteorologicoResponseDTO> cadastrar(
            @Valid @RequestBody RegistroMeteorologicoRequestDTO dto) {

        RegistroMeteorologicoResponseDTO registro = service.cadastrar(dto);

        URI localizacao = URI.create(
                "/api/registros/" + registro.getRegistroId()
        );

        return ResponseEntity.created(localizacao).body(registro);
    }

    @PutMapping("/{id}")
    public RegistroMeteorologicoResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody RegistroMeteorologicoRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
