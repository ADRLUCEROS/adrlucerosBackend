package com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Tienda.domain.models.Tienda;
import com.adrLuceros.transporte.Tienda.domain.repository.TiendaRepository;
import com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Entity.TiendaJpa;
import com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Mapper.TiendaMapperJpaToModel;

@Repository

public class TiendaRepositoryInfra implements TiendaRepository {

    private final MysqlTiendaRepository mysqlTiendaRepository;
    private final TiendaMapperJpaToModel mapperJpaToModels;

    public TiendaRepositoryInfra(MysqlTiendaRepository mysqlTiendaRepository,
            TiendaMapperJpaToModel mapperJpaToModels) {
        this.mysqlTiendaRepository = mysqlTiendaRepository;
        this.mapperJpaToModels = mapperJpaToModels;
    }

    @Override
    public void saveTienda(Tienda tienda) {

        TiendaJpa tiendaJpa = mapperJpaToModels.ModelsToJpa(tienda);
        mysqlTiendaRepository.save(tiendaJpa);

    }

    @Override
    public Tienda findTiendaById(int id) {
        Tienda tienda = mysqlTiendaRepository.findById(id)
                .map(mapperJpaToModels::JpaToModels)
                .orElse(null);
        return tienda;
    }

    @Override
    public List<Tienda> findAllTiendas() {
        List<Tienda> tiendas = mysqlTiendaRepository.findAll().stream()
                .map(mapperJpaToModels::JpaToModels)
                .toList();
        return tiendas;

    }

    @Override
    public void updateTienda(Tienda tienda) {
        TiendaJpa tiendaJpa = mapperJpaToModels.ModelsToJpa(tienda);
        mysqlTiendaRepository.save(tiendaJpa);
    }

    @Override
    public void deleteTienda(Tienda tienda) {
        TiendaJpa tiendaJpa = mapperJpaToModels.ModelsToJpa(tienda);
        mysqlTiendaRepository.save(tiendaJpa);
    }

}
