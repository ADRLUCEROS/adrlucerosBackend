package com.adrLuceros.transporte.Unidad.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.Unidad.Domain.Models.Unidad;

public interface UnidadRepository {

    List<Unidad> findAll();
    Unidad findById(int idUnidad);
    void save(Unidad unidad);
    void delete(Unidad unidad);
    void update(Unidad unidad);
    Unidad findByPlaca(String placa);
    
}
