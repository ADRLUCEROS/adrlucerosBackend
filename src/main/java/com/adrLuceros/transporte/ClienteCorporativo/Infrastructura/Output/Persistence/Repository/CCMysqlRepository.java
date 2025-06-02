package com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.ClienteCorporativo.Domain.Models.ClienteCorporativo;
import com.adrLuceros.transporte.ClienteCorporativo.Domain.Repository.ClienteCorporativoRepository;
import com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Entity.ClienteCorporativoJpa;
import com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Mapper.MapperCCModelAndJpa;

@Repository

public class CCMysqlRepository implements ClienteCorporativoRepository {

        private final CCJpaRepository ccJpaRepository;
    private final MapperCCModelAndJpa mapperCCModelAndJpa;
    public CCMysqlRepository(CCJpaRepository ccJpaRepository, MapperCCModelAndJpa mapperCCModelAndJpa) {
        this.ccJpaRepository = ccJpaRepository;
        this.mapperCCModelAndJpa = mapperCCModelAndJpa;
    }

    @Override
    public ClienteCorporativo findById(int idClienteCorporativo) {
        ClienteCorporativoJpa  clienteCorporativoJpa = ccJpaRepository.findById(idClienteCorporativo).orElse(null);
        return mapperCCModelAndJpa.JpaToModels(clienteCorporativoJpa);
    }

    @Override
    public List<ClienteCorporativo> findAll() {
        List<ClienteCorporativoJpa> clienteCorporativoJpas = ccJpaRepository.findAll();
        return clienteCorporativoJpas.stream()
                .map(mapperCCModelAndJpa::JpaToModels)
                .toList();
    }

    @Override
    public void save(ClienteCorporativo clienteCorporativo) {
        ClienteCorporativoJpa clienteCorporativoJpa = mapperCCModelAndJpa.ModelsToJpa(clienteCorporativo);
        ccJpaRepository.save(clienteCorporativoJpa);
    }

    @Override
    public void update(ClienteCorporativo clienteCorporativo) {
        ClienteCorporativoJpa clienteCorporativoJpa = mapperCCModelAndJpa.ModelsToJpa(clienteCorporativo);
        ccJpaRepository.save(clienteCorporativoJpa);
    }

    @Override
    public void delete(ClienteCorporativo clienteCorporativo) {
        ClienteCorporativoJpa clienteCorporativoJpa = mapperCCModelAndJpa.ModelsToJpa(clienteCorporativo);
        ccJpaRepository.save(clienteCorporativoJpa);
    }

    
}
