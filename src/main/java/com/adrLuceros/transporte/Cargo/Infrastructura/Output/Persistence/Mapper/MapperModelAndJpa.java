package com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Cargo.Domain.Models.Cargo;
import com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Entity.CargoJpa;

@Component

public class MapperModelAndJpa {

    private final ModelMapper modelMapper;
    public MapperModelAndJpa(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }
    
    public Cargo JpaToModels(CargoJpa cargoJpa) {
        Cargo cargo = modelMapper.map(cargoJpa, Cargo.class);
        return cargo;
    }
    public CargoJpa ModelsToJpa(Cargo cargo) {
        CargoJpa cargoJpa = modelMapper.map(cargo, CargoJpa.class);
        return cargoJpa;
    }
    
}
