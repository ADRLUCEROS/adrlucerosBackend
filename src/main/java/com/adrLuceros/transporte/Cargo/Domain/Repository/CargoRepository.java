package com.adrLuceros.transporte.Cargo.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.Cargo.Domain.Models.Cargo;

public interface CargoRepository {

    Cargo findById(int idCargo);
    List<Cargo> findAll();
    void save(Cargo cargo);
    void update(Cargo cargo);   
    void delete(Cargo cargo); 
    
}
