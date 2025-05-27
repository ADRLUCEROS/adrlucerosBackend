package com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Tienda.domain.models.Tienda;
import com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Entity.TiendaJpa;

@Component

public class TiendaMapperJpaToModel {

    private final ModelMapper modelMapper;

    public TiendaMapperJpaToModel(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public Tienda JpaToModels (TiendaJpa tiendaJpa) {
        Tienda tienda = modelMapper.map(tiendaJpa, Tienda.class);

        return tienda;
    }

    public TiendaJpa ModelsToJpa (Tienda tienda) {
        TiendaJpa tiendaJpa = modelMapper.map(tienda, TiendaJpa.class);

        return tiendaJpa;
    }
    
}
