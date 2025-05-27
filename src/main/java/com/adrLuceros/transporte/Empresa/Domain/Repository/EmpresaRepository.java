package com.adrLuceros.transporte.Empresa.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.Empresa.Domain.Models.Empresa;

public interface EmpresaRepository {

    Empresa findById(int idEmpresa);

    List<Empresa> findAll();

    void save(Empresa empresa);

    void update(Empresa empresa);

    void delete(Empresa empresa);
    
}
