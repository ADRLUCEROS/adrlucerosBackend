package com.adrLuceros.transporte.Almacen.Application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Almacen.Application.DTO.AlamcenDTO;
import com.adrLuceros.transporte.Almacen.Application.DTO.AlmacenAndCC;
import com.adrLuceros.transporte.Almacen.Domain.Models.Almacen;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndAlmacen;

@Component

public class AlmacenMapperModelAndDTO {

    private final ModelMapper modelMapper;
    public AlmacenMapperModelAndDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public AlmacenAndCC modelToDTO(Almacen almacen, CCAndAlmacen clienteCorporativo) {
        AlmacenAndCC almacenAndCC = modelMapper.map(almacen, AlmacenAndCC.class);
        almacenAndCC.setClienteCorporativo(clienteCorporativo);

        return almacenAndCC;
    }

    public Almacen dtoToModel(AlamcenDTO almacenDTO) {
        Almacen almacen = modelMapper.map(almacenDTO, Almacen.class);
        return almacen;
    }

    public void updateModelFromDTO(Almacen almacen, AlamcenDTO almacenDTO) {
        modelMapper.map(almacenDTO, almacen);
    }   

    
}
