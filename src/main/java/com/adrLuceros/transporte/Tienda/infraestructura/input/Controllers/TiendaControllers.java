package com.adrLuceros.transporte.Tienda.infraestructura.input.Controllers;

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

import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaEmpresaDTO;
import com.adrLuceros.transporte.Tienda.application.service.TiendaService;

@RestController
@RequestMapping("/api/tienda")

public class TiendaControllers {

    private final TiendaService tiendaService;
    public TiendaControllers(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping
    public ResponseEntity<List<TiendaEmpresaDTO>> getAllTiendas() {
        List<TiendaEmpresaDTO> tiendas = tiendaService.findAllTiendas();
        return ResponseEntity.ok(tiendas);
    }

    @GetMapping("/{idTienda}")
    public ResponseEntity<TiendaEmpresaDTO> getTiendaById(@PathVariable int idTienda) {
        TiendaEmpresaDTO tienda = tiendaService.findTiendaById(idTienda);
        return ResponseEntity.ok(tienda);
    }

    @PostMapping
    public ResponseEntity<Void> saveTienda(@RequestBody TiendaDTO tiendaDTO) {
        tiendaService.saveTienda(tiendaDTO);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping
    public ResponseEntity<Void> updateTienda(@RequestBody TiendaDTO tiendaDTO) {
        tiendaService.updateTienda(tiendaDTO);
        return ResponseEntity.ok().build();
    }  

    @DeleteMapping
    public ResponseEntity<Void> deleteTienda(@RequestBody TiendaDTO tiendaDTO) {
        tiendaService.deleteTienda(tiendaDTO);
        return ResponseEntity.ok().build();
    }  
    
}
