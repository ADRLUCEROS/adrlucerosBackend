package com.adrLuceros.transporte.Cargo.Application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;
import com.adrLuceros.transporte.Cargo.Application.Mapper.MapperCargoModelAndDTO;
import com.adrLuceros.transporte.Cargo.Domain.Models.Cargo;
import com.adrLuceros.transporte.Cargo.Domain.Repository.CargoRepository;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    private final MapperCargoModelAndDTO mapperCargoModelAndDTO;
    public CargoService(CargoRepository cargoRepository, MapperCargoModelAndDTO mapperCargoModelAndDTO) {
        this.cargoRepository = cargoRepository;
        this.mapperCargoModelAndDTO = mapperCargoModelAndDTO;
    }

    public CargoDTO findById(int idCargo) {
        Cargo cargo = cargoRepository.findById(idCargo);
        return mapperCargoModelAndDTO.ModelsToDTO(cargo);
    }
    public List<CargoDTO> findAll() {
        List<Cargo> cargos = cargoRepository.findAll();
        return cargos.stream()
                .map(mapperCargoModelAndDTO::ModelsToDTO)
                .toList();
    }
    public void save(CargoDTO cargoDTO) {
        Cargo cargo = mapperCargoModelAndDTO.DTOToModels(cargoDTO);
        cargoRepository.save(cargo);
    }
    public void update(CargoDTO cargoDTO) {
        Cargo cargo = cargoRepository.findById(cargoDTO.getIdCargo());
        mapperCargoModelAndDTO.updateCargoFromDTO(cargoDTO, cargo);
        cargoRepository.update(cargo);
    }
    public void delete(CargoDTO cargoDTO) {
        Cargo cargo = cargoRepository.findById(cargoDTO.getIdCargo());
        mapperCargoModelAndDTO.updateCargoFromDTO(cargoDTO, cargo);
        cargoRepository.delete(cargo);
    }   
    
}
