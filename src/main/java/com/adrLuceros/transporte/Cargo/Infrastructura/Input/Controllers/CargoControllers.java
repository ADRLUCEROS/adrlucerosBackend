package com.adrLuceros.transporte.Cargo.Infrastructura.Input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;
import com.adrLuceros.transporte.Cargo.Application.Service.CargoService;

@RequestMapping("/api/cargo")
@RestController

public class CargoControllers {

    private final CargoService cargoService;
    public CargoControllers(CargoService cargoService) {
        this.cargoService = cargoService;
    } 
    
    @GetMapping("/{idCargo}")
    public ResponseEntity<CargoDTO> findById(int idCargo) {
        CargoDTO cargoDTO = cargoService.findById(idCargo);
        return ResponseEntity.ok(cargoDTO);
    }
    @GetMapping
    public ResponseEntity<List<CargoDTO>> findAll() {
        List<CargoDTO> cargos = cargoService.findAll();
        return ResponseEntity.ok(cargos);
    }
    
    @PostMapping
    public ResponseEntity<CargoDTO> create(@RequestBody CargoDTO cargoDTO) {
         cargoService.save(cargoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CargoDTO> update(@RequestBody CargoDTO cargoDTO) {
        cargoService.update(cargoDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CargoDTO cargoDTO) {
        cargoService.delete(cargoDTO);
        return ResponseEntity.noContent().build();
    }

    
}
