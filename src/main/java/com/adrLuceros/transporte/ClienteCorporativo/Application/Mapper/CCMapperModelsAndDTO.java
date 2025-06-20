package com.adrLuceros.transporte.ClienteCorporativo.Application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndAlmacen;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndEmpresa;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.ClienteCorporativoDTO;
import com.adrLuceros.transporte.ClienteCorporativo.Domain.Models.ClienteCorporativo;
import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;


@Component

public class CCMapperModelsAndDTO {

        private final ModelMapper modelMapper;

     public CCMapperModelsAndDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public CCAndEmpresa ModelsToDTO(ClienteCorporativo clienteCorporativo, EmpresaDTO empresaDTO) {

        CCAndEmpresa ccAndEmpresa = modelMapper.map(clienteCorporativo, CCAndEmpresa.class);
        ccAndEmpresa.setEmpresa(empresaDTO);
        return ccAndEmpresa;

    }

    public ClienteCorporativo DTOToModels(ClienteCorporativoDTO clienteCorporativoDTO) {

        return modelMapper.map(clienteCorporativoDTO, ClienteCorporativo.class);

    }

    public void updateModelsFromDTO(ClienteCorporativoDTO clienteCorporativoDTO, ClienteCorporativo clienteCorporativo) {

        modelMapper.map(clienteCorporativoDTO, clienteCorporativo);

    }

    public CCAndAlmacen ModelsToDTO(ClienteCorporativo clienteCorporativo) {

        return modelMapper.map(clienteCorporativo, CCAndAlmacen.class);

    }          


    
}
