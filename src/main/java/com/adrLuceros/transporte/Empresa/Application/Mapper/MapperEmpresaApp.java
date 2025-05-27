package com.adrLuceros.transporte.Empresa.Application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Empresa.Domain.Models.Empresa;


@Component
public class MapperEmpresaApp {

            private final ModelMapper modelMapper;

    public MapperEmpresaApp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public EmpresaDTO modelToDTO(Empresa empresa) {
        EmpresaDTO empresaDTO = modelMapper.map(empresa, EmpresaDTO.class);
        return empresaDTO;
    } 
    public Empresa dtoToModel(EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
        return empresa;
    }

    public void updateMapper(EmpresaDTO empresaDTO, Empresa empresa) {
        modelMapper.map(empresaDTO, empresa);
    }
    
}
