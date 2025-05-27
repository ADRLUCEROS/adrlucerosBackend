package com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Entity.UnidadJpa;

@Repository
public interface JpaUnidadRepository extends JpaRepository<UnidadJpa, Integer> {


    
} 
