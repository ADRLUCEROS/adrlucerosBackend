package com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Entity.EmpresaJpa;


@Repository
public interface JpaEmpresaRepository extends JpaRepository<EmpresaJpa, Integer> {

    
} 
