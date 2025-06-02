package com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Almacen.Domain.Models.Almacen;
import com.adrLuceros.transporte.Almacen.Domain.Repository.AlmacenRepository;
import com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Entity.AlmacenJpa;
import com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Mapper.AlmacenMapperModelsAndJpa;

@Repository

public class MysqlAlmacenRepository implements AlmacenRepository {

    private final AlmacenMapperModelsAndJpa almacenMapperModelsAndJpa;
    private final AlmacenJpaRepository almacenJpaRepository;
    public MysqlAlmacenRepository(AlmacenMapperModelsAndJpa almacenMapperModelsAndJpa,
            AlmacenJpaRepository almacenJpaRepository) {
        this.almacenMapperModelsAndJpa = almacenMapperModelsAndJpa;
        this.almacenJpaRepository = almacenJpaRepository;
    }

    @Override
    public Almacen findById(int idAlmacen) {
        AlmacenJpa almacenJpa = almacenJpaRepository.findById(idAlmacen)
                .orElseThrow(() -> new RuntimeException("Almacen not found with id: " + idAlmacen));
        return almacenMapperModelsAndJpa.jpaToModel(almacenJpa);




    }

    @Override
    public List<Almacen> findAll() {
        List<Almacen> almacenes = almacenJpaRepository.findAll().stream()
                .map(almacenMapperModelsAndJpa::jpaToModel)
                .toList();
        return almacenes;

    }

    @Override
    public void save(Almacen almacen) {
        AlmacenJpa almacenJpa = almacenMapperModelsAndJpa.modelToJpa(almacen);
        almacenJpaRepository.save(almacenJpa);  
    }

    @Override
    public void update(Almacen almacen) {
         AlmacenJpa almacenJpa = almacenMapperModelsAndJpa.modelToJpa(almacen);
        almacenJpaRepository.save(almacenJpa);  
    }

    @Override
    public void delete(Almacen almacen) {
         AlmacenJpa almacenJpa = almacenMapperModelsAndJpa.modelToJpa(almacen);
        almacenJpaRepository.save(almacenJpa);  
    }
    
}
