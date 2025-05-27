package com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Empresa.Domain.Models.Empresa;
import com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Entity.EmpresaJpa;

@Component

public class MapperEmpresainfra {

        private final ModelMapper modelMapper;

    public MapperEmpresainfra(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public Empresa JpaToModels(EmpresaJpa empresaJpa) {
        Empresa empresa = modelMapper.map(empresaJpa, Empresa.class);
        return empresa;
    }

    public EmpresaJpa ModelsToJpa(Empresa empresa) {
        EmpresaJpa empresaJpa = modelMapper.map(empresa, EmpresaJpa.class);
        return empresaJpa;
    }


    
}
