package com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Unidad.Domain.Models.Unidad;
import com.adrLuceros.transporte.Unidad.Domain.Repository.UnidadRepository;
import com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Entity.UnidadJpa;
import com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Mapper.MapperUnidadInfra;

@Repository
public class MysqlUnidadRepository implements UnidadRepository {

    private final JpaUnidadRepository jpaUnidadRepository;
    private final MapperUnidadInfra mapperUnidadInfra;
    public MysqlUnidadRepository(JpaUnidadRepository jpaUnidadRepository, MapperUnidadInfra mapperUnidadInfra) {
        this.jpaUnidadRepository = jpaUnidadRepository;
        this.mapperUnidadInfra = mapperUnidadInfra;
    }



    @Override
    public List<Unidad> findAll() {
        List<Unidad> unidades = jpaUnidadRepository.findAll().stream()
                .map(mapperUnidadInfra::JpatoModel)
                .toList();
        return unidades;
    }

    @Override
    public Unidad findById(int idUnidad) {
        Unidad unidad = jpaUnidadRepository.findById(idUnidad)
                .map(mapperUnidadInfra::JpatoModel)
                .orElse(null);
        return unidad;
    }



    @Override
    public void save(Unidad unidad) {

        UnidadJpa unidadJpa = mapperUnidadInfra.ModelToJpa(unidad);
        jpaUnidadRepository.save(unidadJpa);

    }



    @Override
    public void delete(Unidad unidad) {
        UnidadJpa unidadJpa = mapperUnidadInfra.ModelToJpa(unidad);
        jpaUnidadRepository.save(unidadJpa);
    }



    @Override
    public void update(Unidad unidad) {
        UnidadJpa unidadJpa = mapperUnidadInfra.ModelToJpa(unidad);
        jpaUnidadRepository.save(unidadJpa);
    }

    @Override
    public Unidad findByPlaca(String placa) {
        return Optional.ofNullable(jpaUnidadRepository.findByPlaca(placa))
                .map(mapperUnidadInfra::JpatoModel)
                .orElse(null);
    }

}
