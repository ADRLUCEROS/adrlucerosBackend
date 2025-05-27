package com.adrLuceros.transporte.Tienda.domain.repository;

import java.util.List;

import com.adrLuceros.transporte.Tienda.domain.models.Tienda;

public interface TiendaRepository {

    void saveTienda(Tienda tienda);
    Tienda findTiendaById(int id);
    List<Tienda> findAllTiendas();
    void updateTienda(Tienda tienda);
    void deleteTienda(Tienda tienda);
}
