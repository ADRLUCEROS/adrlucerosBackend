package com.adrLuceros.transporte.Almacen.Infrastructura.Input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.Almacen.Application.DTO.AlamcenDTO;
import com.adrLuceros.transporte.Almacen.Application.DTO.AlmacenAndCC;
import com.adrLuceros.transporte.Almacen.Application.Service.AlmacenService;

@RestController
@RequestMapping("/api/almacen")

public class AlmacenController {

    private final AlmacenService almacenService;
    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping("/{idAlmacen}")
    ResponseEntity<AlmacenAndCC> getAlmacenAndCCById(@PathVariable int idAlmacen) {
        AlmacenAndCC almacenAndCC = almacenService.getAlmacenAndCCById(idAlmacen);
        if (almacenAndCC != null) {
            return ResponseEntity.ok(almacenAndCC);
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    @GetMapping
    ResponseEntity<List<AlmacenAndCC>> getAllAlmacenesAndCC() {
        List<AlmacenAndCC> almacenesAndCC = almacenService.getAllAlmacenesAndCC();
        if (almacenesAndCC != null && !almacenesAndCC.isEmpty()) {
            return ResponseEntity.ok(almacenesAndCC);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping
    ResponseEntity<Void> saveAlmacen(AlamcenDTO almacenDTO) {
        almacenService.save(almacenDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    ResponseEntity<Void> updateAlmacen(AlamcenDTO almacenDTO) {
        almacenService.update(almacenDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    ResponseEntity<Void> deleteAlmacen(AlamcenDTO almacenDTO) {
        almacenService.delete(almacenDTO);
        return ResponseEntity.ok().build();
    }

    
}
