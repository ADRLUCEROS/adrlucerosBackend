package com.adrLuceros.transporte.Persona.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.Persona.Domain.Modal.Persona;

public interface PersonaRepository {

    Persona findPersonaById(int idPersona);

    List<Persona> findAllPersonas();

    void savePersona(Persona persona);

    void saveUpdate(Persona persona);

    void saveDelete(Persona persona);



    
}
