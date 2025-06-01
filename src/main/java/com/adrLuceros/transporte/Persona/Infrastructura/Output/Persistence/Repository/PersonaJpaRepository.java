package com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Entity.PersonaJpa;


@Repository

public interface PersonaJpaRepository extends JpaRepository<PersonaJpa, Integer> {
    
    
    
}
