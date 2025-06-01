package com.adrLuceros.transporte.Cargo.Application.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Cargo.Domain.Models.Cargo;
import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;


@Component
public class MapperCargoModelAndDTO {

        private final ModelMapper modelMapper;
    public MapperCargoModelAndDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }
    public Cargo DTOToModels(CargoDTO cargoDTO) {
        Cargo cargo = modelMapper.map(cargoDTO, Cargo.class);
        return cargo;
    }
    public CargoDTO ModelsToDTO(Cargo cargo) {
        CargoDTO cargoDTO = modelMapper.map(cargo, CargoDTO.class);
        return cargoDTO;
    }
    public void updateCargoFromDTO(CargoDTO cargoDTO, Cargo cargo) {
        modelMapper.map(cargoDTO, cargo);   
    }


    
}
