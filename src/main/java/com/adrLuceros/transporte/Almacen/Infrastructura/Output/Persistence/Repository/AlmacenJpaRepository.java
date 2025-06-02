package com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Entity.AlmacenJpa;

@Repository

public interface AlmacenJpaRepository extends JpaRepository<AlmacenJpa, Integer> {


    
}
