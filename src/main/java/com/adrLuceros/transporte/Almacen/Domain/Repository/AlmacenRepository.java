package com.adrLuceros.transporte.Almacen.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.Almacen.Domain.Models.Almacen;

public interface AlmacenRepository {

    Almacen findById(int idAlmacen);
    List<Almacen> findAll();
    void save(Almacen almacen);
    void update(Almacen almacen);
    void delete(Almacen almacen);

    
} 
