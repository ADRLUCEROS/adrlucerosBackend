package com.adrLuceros.transporte.Persona.Infrastructura.Input.Controllers;

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

import com.adrLuceros.transporte.Persona.Application.DTO.CargoPersonaDTO;
import com.adrLuceros.transporte.Persona.Application.DTO.PersonaDTO;
import com.adrLuceros.transporte.Persona.Application.Service.PersonaService;

@RestController
@RequestMapping("/api/personas")    

public class PersonaController {

    private final PersonaService personaService;
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{idPersona}") 
    public ResponseEntity<CargoPersonaDTO> findbyIdPersona(@PathVariable int idPersona) {
        CargoPersonaDTO cargoPersonaDTO = personaService.findbyIdPersona(idPersona);
        if (cargoPersonaDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cargoPersonaDTO);
    }

    @GetMapping
    public ResponseEntity<List<CargoPersonaDTO>> findAllPersonas() {
        List<CargoPersonaDTO> Cargopersonas = personaService.findAllPersonasWithCargo();
        return ResponseEntity.ok(Cargopersonas);
    }

    @PostMapping
    public ResponseEntity<Void> savePersona(@RequestBody PersonaDTO personaDTO) {
        personaService.savePersona(personaDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> saveUpdate(@RequestBody PersonaDTO personaDTO) {
        personaService.saveUpdate(personaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> saveDelete(@RequestBody PersonaDTO personaDTO) {
        personaService.saveDelete(personaDTO);
        return ResponseEntity.ok().build();
    }

    
}
