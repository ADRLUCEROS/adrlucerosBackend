package com.adrLuceros.transporte.Unidad.Infrastructura.Input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.Unidad.Application.DTO.UnidadDTO;
import com.adrLuceros.transporte.Unidad.Application.Service.UnidadService;

@RestController
@RequestMapping("/api/unidad")


public class UnidadController {

    private final UnidadService unidadService;
    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    @GetMapping("/{idUnidad}")
    public ResponseEntity<UnidadDTO> findById( @PathVariable int idUnidad){
        UnidadDTO unidadDTO = unidadService.findById(idUnidad);
        if (unidadDTO != null) {
            return ResponseEntity.ok(unidadDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<UnidadDTO>> findAll() {
        List<UnidadDTO> unidades = unidadService.findAll();
        return ResponseEntity.ok(unidades);
    } 

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UnidadDTO unidadDTO) {
        unidadService.save(unidadDTO);
        return ResponseEntity.ok().build();
    }   

        @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody UnidadDTO unidadDTO) {
        unidadService.delete(unidadDTO);
        return ResponseEntity.ok().build();
    }

        @PutMapping
    public ResponseEntity<Void> update(@RequestBody UnidadDTO unidadDTO) {
        unidadService.update(unidadDTO);
        return ResponseEntity.ok().build();
    }


    
}
