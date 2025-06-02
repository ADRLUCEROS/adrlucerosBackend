package com.adrLuceros.transporte.ClienteCorporativo.Domain.Repository;

import java.util.List;

import com.adrLuceros.transporte.ClienteCorporativo.Domain.Models.ClienteCorporativo;

public interface ClienteCorporativoRepository {

    ClienteCorporativo findById(int idClienteCorporativo);  
    List<ClienteCorporativo> findAll();
    void save(ClienteCorporativo clienteCorporativo);
    void update(ClienteCorporativo clienteCorporativo);
    void delete(ClienteCorporativo clienteCorporativo);

    
}
