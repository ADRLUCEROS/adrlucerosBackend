package com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Cargo.Domain.Models.Cargo;
import com.adrLuceros.transporte.Cargo.Domain.Repository.CargoRepository;
import com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Entity.CargoJpa;
import com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Mapper.MapperModelAndJpa;

@Service
public class CargoMysqlCargo implements CargoRepository {

    private final CargoJpaRepository cargoJpaRepository;
    private final MapperModelAndJpa mapperModelAndJpa;

    public CargoMysqlCargo(CargoJpaRepository cargoJpaRepository, MapperModelAndJpa mapperModelAndJpa) {
        this.cargoJpaRepository = cargoJpaRepository;
        this.mapperModelAndJpa = mapperModelAndJpa;
    }   

    @Override
    public Cargo findById(int idCargo) {
        CargoJpa cargoJpa = cargoJpaRepository.findById(idCargo)
                .orElseThrow(() -> new RuntimeException("Cargo not found with id: " + idCargo));
        return mapperModelAndJpa.JpaToModels(cargoJpa); 
    }

    @Override
    public List<Cargo> findAll() {
        List<CargoJpa> cargoJpas = cargoJpaRepository.findAll();
        return cargoJpas.stream()
                .map(mapperModelAndJpa::JpaToModels)
                .toList();

    }

    @Override
    public void save(Cargo cargo) {
        CargoJpa cargoJpa = mapperModelAndJpa.ModelsToJpa(cargo);
        cargoJpaRepository.save(cargoJpa);  

    }

    @Override
    public void update(Cargo cargo) {
        CargoJpa cargoJpa = mapperModelAndJpa.ModelsToJpa(cargo);
        cargoJpaRepository.save(cargoJpa);  
    }

    @Override
    public void delete(Cargo cargo) {
        CargoJpa cargoJpa = mapperModelAndJpa.ModelsToJpa(cargo);
        cargoJpaRepository.save(cargoJpa);  
    }
    
}
