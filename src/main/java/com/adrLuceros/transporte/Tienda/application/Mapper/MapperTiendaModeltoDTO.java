package com.adrLuceros.transporte.Tienda.application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.domain.models.Tienda;

@Component

public class MapperTiendaModeltoDTO {


        private final ModelMapper modelMapper;
        public MapperTiendaModeltoDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public TiendaDTO modelToDTO(Tienda tienda) {
        TiendaDTO tiendaDTO = modelMapper.map(tienda, TiendaDTO.class);
        return tiendaDTO;
    }

    public Tienda dtoToModel(TiendaDTO tiendaDTO) {
        Tienda tienda = modelMapper.map(tiendaDTO, Tienda.class);
        return tienda;
    }

    public void updateMapper( TiendaDTO tiendaDTO, Tienda tienda) {
        modelMapper.map(tiendaDTO, tienda);
    }
    
}
