package com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;
import com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Entity.PersonaJpa;




@Component

public class PersonaMapperJpaToModel {

    private final ModelMapper modelMapper;


        public PersonaMapperJpaToModel(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public Persona JpaToModels(PersonaJpa personaJpa) {
        Persona persona = modelMapper.map(personaJpa, Persona.class);
        return persona;
    }

    public PersonaJpa ModelsToJpa(Persona persona) {
        PersonaJpa personaJpa = modelMapper.map(persona, PersonaJpa.class);
        return personaJpa;
    }

    
}
