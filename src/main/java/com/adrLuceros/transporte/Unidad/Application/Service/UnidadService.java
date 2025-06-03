package com.adrLuceros.transporte.Unidad.Application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Unidad.Application.DTO.UnidadDTO;
import com.adrLuceros.transporte.Unidad.Application.Mapper.MapperUnidadApp;
import com.adrLuceros.transporte.Unidad.Domain.Models.Unidad;
import com.adrLuceros.transporte.Unidad.Domain.Repository.UnidadRepository;

@Service
public class UnidadService  {

    private final MapperUnidadApp mapperUnidadApp;
    private final UnidadRepository unidadRepository;
    public UnidadService(MapperUnidadApp mapperUnidadApp, UnidadRepository unidadRepository) {
        this.mapperUnidadApp = mapperUnidadApp;
        this.unidadRepository = unidadRepository;
    }   

    public List<UnidadDTO> findAll() {
        List<Unidad> unidades = unidadRepository.findAll();
        return unidades.stream()
                .map(mapperUnidadApp::modelToDTO)
                .toList();
    }
    public UnidadDTO findById(int idUnidad) {
        Unidad unidad = unidadRepository.findById(idUnidad);
        if (unidad != null) {
            return mapperUnidadApp.modelToDTO(unidad);
        }
        return null;
    }

    public void save(UnidadDTO unidadDTO) {
        Unidad unidad = mapperUnidadApp.dtoToModel(unidadDTO);
        unidadRepository.save(unidad);
    }

        public void delete(UnidadDTO unidadDTO) {
        Unidad unidadExistente = unidadRepository.findById(unidadDTO.getIdUnidad());

         mapperUnidadApp.updateMapper(unidadDTO, unidadExistente);
        unidadRepository.update(unidadExistente);
    }

        public void update(UnidadDTO unidadDTO) {
        
        Unidad unidadExistente = unidadRepository.findById(unidadDTO.getIdUnidad());

         mapperUnidadApp.updateMapper(unidadDTO, unidadExistente);
        unidadRepository.update(unidadExistente);
    }

    public UnidadDTO findByPlaca(String placa) {
        Unidad unidad = unidadRepository.findByPlaca(placa);
        if (unidad != null) {
            return mapperUnidadApp.modelToDTO(unidad);
        }
        return null;
    }

    
}
