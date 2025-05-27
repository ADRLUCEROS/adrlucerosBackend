package com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrLuceros.transporte.Empresa.Domain.Models.Empresa;
import com.adrLuceros.transporte.Empresa.Domain.Repository.EmpresaRepository;
import com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Entity.EmpresaJpa;
import com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Mapper.MapperEmpresainfra;

@Repository

public class MysqlEmpresaRepository implements EmpresaRepository {

    private final MapperEmpresainfra mapperEmpresainfra;
    private final JpaEmpresaRepository jpaEmpresaRepository;

    public MysqlEmpresaRepository(MapperEmpresainfra mapperEmpresainfra, JpaEmpresaRepository jpaEmpresaRepository) {
        this.mapperEmpresainfra = mapperEmpresainfra;
        this.jpaEmpresaRepository = jpaEmpresaRepository;
    }

    @Override
    public Empresa findById(int idEmpresa) {
       
        EmpresaJpa empresajpa = jpaEmpresaRepository.findById(idEmpresa).orElse(null);

        return mapperEmpresainfra.JpaToModels(empresajpa);

    }

    @Override
    public List<Empresa> findAll() {
        List<EmpresaJpa> empresasJpa = jpaEmpresaRepository.findAll();
        return empresasJpa.stream()
                .map(mapperEmpresainfra::JpaToModels)
                .toList();
    }

    @Override
    public void save(Empresa empresa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Empresa empresa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Empresa empresa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
