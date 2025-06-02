package com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;

import com.adrLuceros.transporte.ClienteCorporativo.Domain.Models.ClienteCorporativo;
import com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Entity.ClienteCorporativoJpa;

public class MapperCCModelAndJpa {

    private final ModelMapper modelMapper;

     public MapperCCModelAndJpa(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public ClienteCorporativo JpaToModels(ClienteCorporativoJpa clienteCorporativoJpa) {

        return modelMapper.map(clienteCorporativoJpa, ClienteCorporativo.class);
    }
    public ClienteCorporativoJpa ModelsToJpa(ClienteCorporativo clienteCorporativo) {

        return modelMapper.map(clienteCorporativo, ClienteCorporativoJpa.class);
    }       
    
}
