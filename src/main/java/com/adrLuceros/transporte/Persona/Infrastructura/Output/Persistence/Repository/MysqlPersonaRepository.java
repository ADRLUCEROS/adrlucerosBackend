package com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;
import com.adrLuceros.transporte.Persona.Domain.Repository.PersonaRepository;
import com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Entity.PersonaJpa;
import com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Mappers.PersonaMapperJpaToModel;

@Repository

public class MysqlPersonaRepository implements PersonaRepository  {

    private final PersonaMapperJpaToModel personaMapperJpaToModel;
    private final PersonaJpaRepository personaJpaRepository;

    public MysqlPersonaRepository(PersonaMapperJpaToModel personaMapperJpaToModel, PersonaJpaRepository personaJpaRepository) {
        this.personaMapperJpaToModel = personaMapperJpaToModel;
        this.personaJpaRepository = personaJpaRepository;
    }   


    @Override
    public Persona findPersonaById(int idPersona) {
        PersonaJpa personaJpa = personaJpaRepository.findById(idPersona).orElse(null);

        return personaMapperJpaToModel.JpaToModels(personaJpa);  

    }

    @Override
    public List<Persona> findAllPersonas() {
        
        List<PersonaJpa> personasJpa = personaJpaRepository.findAll();
        return personasJpa.stream()
                          .map(personaMapperJpaToModel::JpaToModels)
                          .toList();

    }

    @Override
    public void savePersona(Persona persona) {
        
        PersonaJpa personaJpa = personaMapperJpaToModel.ModelsToJpa(persona);
        personaJpaRepository.save(personaJpa);  

    }

    @Override
    public void saveUpdate(Persona persona) {
        PersonaJpa personaJpa = personaMapperJpaToModel.ModelsToJpa(persona);
        personaJpaRepository.save(personaJpa);
    }

    @Override
    public void saveDelete(Persona persona) {
        PersonaJpa personaJpa = personaMapperJpaToModel.ModelsToJpa(persona);
        personaJpaRepository.save(personaJpa);
    }
    
}
