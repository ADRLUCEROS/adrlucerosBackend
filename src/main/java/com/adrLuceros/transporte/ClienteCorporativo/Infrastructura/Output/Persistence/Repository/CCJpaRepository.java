package com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Entity.ClienteCorporativoJpa;

@Repository
public interface CCJpaRepository extends JpaRepository<ClienteCorporativoJpa, Integer> {

    
}
