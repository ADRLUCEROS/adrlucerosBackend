package com.adrLuceros.transporte.Unidad.Application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Unidad.Application.DTO.UnidadDTO;
import com.adrLuceros.transporte.Unidad.Domain.Models.Unidad;

@Component
public class MapperUnidadApp {

            private final ModelMapper modelMapper;
        public MapperUnidadApp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public UnidadDTO modelToDTO(Unidad unidad) {
        UnidadDTO unidadDTO = modelMapper.map(unidad, UnidadDTO.class);
        return unidadDTO;
    }
    public Unidad dtoToModel(UnidadDTO unidadDTO) {
        Unidad unidad = modelMapper.map(unidadDTO, Unidad.class);
        return unidad;
    }
    public void updateMapper(UnidadDTO unidadDTO, Unidad unidad) {
        modelMapper.map(unidadDTO, unidad);
    }
    
}
