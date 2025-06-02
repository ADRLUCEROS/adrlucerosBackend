package com.adrLuceros.transporte.Persona.Application.Mapper;

import org.modelmapper.ModelMapper;
import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;
import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;
import com.adrLuceros.transporte.Persona.Application.DTO.CargoPersonaDTO;
import com.adrLuceros.transporte.Persona.Application.DTO.PersonaDTO;

public class PersonMapperModelAndDTO {

    
    private final ModelMapper modelMapper;


        public PersonMapperModelAndDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }
    public Persona DTOToModel(PersonaDTO personaDTO) {
        return modelMapper.map(personaDTO, Persona.class);
    }   

    public PersonaDTO ModelToDTO(Persona persona) {
        return modelMapper.map(persona, PersonaDTO.class);
    }   

    public void updateModelFromDTO(PersonaDTO personaDTO, Persona persona) {
        modelMapper.map(personaDTO, persona);
    }
    
    public CargoPersonaDTO ModelToCargoPersonaDTO(Persona persona, CargoDTO cargoDTO) {
        CargoPersonaDTO cargoPersonaDTO = modelMapper.map(persona, CargoPersonaDTO.class);
        cargoPersonaDTO.setCargos(cargoDTO);
        return cargoPersonaDTO;     



        
    }


    
}
