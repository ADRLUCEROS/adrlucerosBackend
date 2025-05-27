package com.adrLuceros.transporte.Tienda.infraestructura.input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.service.TiendaService;

@RestController
@RequestMapping("/api/tienda")

public class TiendaControllers {

    private final TiendaService tiendaService;
    public TiendaControllers(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> getAllTiendas() {
        List<TiendaDTO> tiendas = tiendaService.findAllTiendas();
        return ResponseEntity.ok(tiendas);
    }
    
}
