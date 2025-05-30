package com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Unidad.Domain.Models.Unidad;
import com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Entity.UnidadJpa;


@Component
public class MapperUnidadInfra {

            private final ModelMapper modelMapper;
        public MapperUnidadInfra(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public Unidad JpatoModel(UnidadJpa unidadJpa) {
        Unidad unidad = modelMapper.map(unidadJpa, Unidad.class);
        return unidad;
    }
    public UnidadJpa ModelToJpa(Unidad unidad) {
        UnidadJpa unidadJpa = modelMapper.map(unidad, UnidadJpa.class);
        return unidadJpa;
    }
    
}
