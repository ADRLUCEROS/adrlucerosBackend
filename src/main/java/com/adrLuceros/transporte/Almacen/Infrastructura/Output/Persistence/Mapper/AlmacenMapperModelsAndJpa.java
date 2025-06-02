package com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Almacen.Domain.Models.Almacen;
import com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Entity.AlmacenJpa;

@Component
public class AlmacenMapperModelsAndJpa {

    private final ModelMapper modelMapper;
    public AlmacenMapperModelsAndJpa(ModelMapper modelMapper) {
                this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public Almacen jpaToModel(AlmacenJpa almacenJpa) {

        return modelMapper.map(almacenJpa, Almacen.class);
    }
    public AlmacenJpa modelToJpa(Almacen almacen) {

        return modelMapper.map(almacen, AlmacenJpa.class);
    }

    
}
