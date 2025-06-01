package com.adrLuceros.transporte.Persona.Application.Service;

import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;
import com.adrLuceros.transporte.Persona.Domain.Repository.PersonaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Persona.Application.DTO.PersonaDTO;
import com.adrLuceros.transporte.Persona.Application.Mapper.PersonMapperModelAndDTO;


@Service

public class PersonaService {

    private final PersonMapperModelAndDTO personMapper;
    private final PersonaRepository personaRepository;
    public PersonaService(PersonMapperModelAndDTO personMapper, PersonaRepository personaRepository) {
        this.personMapper = personMapper;
        this.personaRepository = personaRepository;
    }

    public PersonaDTO findbyIdPersona (int idPersona) {
        Persona persona = personaRepository.findPersonaById(idPersona);
        if (persona == null) {
            return null; // or throw an exception if you prefer
        }   
        return personMapper.ModelToDTO(persona);
    }
    public List <PersonaDTO> findAllPersonas() {
        List<Persona> personas = personaRepository.findAllPersonas();
        return personas.stream()
                .map(personMapper::ModelToDTO)
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
