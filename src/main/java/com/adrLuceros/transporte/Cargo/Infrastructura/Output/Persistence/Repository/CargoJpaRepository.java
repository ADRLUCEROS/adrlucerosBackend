package com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Entity.CargoJpa;

@Repository
public interface CargoJpaRepository extends JpaRepository<CargoJpa, Integer> {
    

    
}
