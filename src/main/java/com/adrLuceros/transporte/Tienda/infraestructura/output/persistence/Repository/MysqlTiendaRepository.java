package com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Entity.TiendaJpa;

@Repository

public interface MysqlTiendaRepository extends JpaRepository<TiendaJpa, Integer> {

    
    
}
