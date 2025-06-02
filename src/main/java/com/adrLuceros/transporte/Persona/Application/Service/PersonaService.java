package com.adrLuceros.transporte.Persona.Application.Service;

import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;
import com.adrLuceros.transporte.Persona.Domain.Repository.PersonaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;
import com.adrLuceros.transporte.Cargo.Application.Service.CargoService;
import com.adrLuceros.transporte.Persona.Application.DTO.CargoPersonaDTO;
import com.adrLuceros.transporte.Persona.Application.DTO.PersonaDTO;
import com.adrLuceros.transporte.Persona.Application.Mapper.PersonMapperModelAndDTO;


@Service

public class PersonaService {

    private final PersonMapperModelAndDTO personMapper;
    private final PersonaRepository personaRepository;
    private final CargoService cargoService;
    public PersonaService(PersonMapperModelAndDTO personMapper, PersonaRepository personaRepository,CargoService cargoService) {
        this.personMapper = personMapper;
        this.personaRepository = personaRepository;
        this.cargoService = cargoService;
    }

    public CargoPersonaDTO findbyIdPersona (int idPersona) {
        Persona persona = personaRepository.findPersonaById(idPersona);
       
        if (persona == null) {
            return null; // or throw an exception if you prefer
        } 
         CargoDTO cargos = cargoService.findById(persona.getCargoIdCargo());  
        return personMapper.ModelToCargoPersonaDTO(persona,cargos);
    }
public List<CargoPersonaDTO> findAllPersonasWithCargo() {
    List<Persona> personas = personaRepository.findAllPersonas();
    return personas.stream()
            .map(persona -> {
                CargoDTO cargo = cargoService.findById(persona.getCargoIdCargo());
                return personMapper.ModelToCargoPersonaDTO(persona, cargo);
            })
            .toList();
}
    public void savePersona(PersonaDTO personaDTO) {
        Persona persona = personMapper.DTOToModel(personaDTO);
        personaRepository.savePersona(persona);
    }
    public void saveUpdate(PersonaDTO personaDTO) {
        Persona persona = personaRepository.findPersonaById(personaDTO.getIdPersona());

        personMapper.updateModelFromDTO(personaDTO, persona);
        personaRepository.saveUpdate(persona);
        
    } 
    
        public void saveDelete(PersonaDTO personaDTO) {
        Persona persona = personaRepository.findPersonaById(personaDTO.getIdPersona());

        personMapper.updateModelFromDTO(personaDTO, persona);
        personaRepository.saveDelete(persona);
        
    }   



    
}
