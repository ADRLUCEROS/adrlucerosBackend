package com.adrLuceros.transporte.Tienda.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.Mapper.MapperTiendaModeltoDTO;
import com.adrLuceros.transporte.Tienda.domain.models.Tienda;
import com.adrLuceros.transporte.Tienda.domain.repository.TiendaRepository;


@Service
public class TiendaService {

    private final TiendaRepository tiendaRepository;
    private final MapperTiendaModeltoDTO mapperTiendaModeltoDTO;

    public TiendaService(TiendaRepository tiendaRepository, MapperTiendaModeltoDTO mapperTiendaModeltoDTO) {
        this.tiendaRepository = tiendaRepository;
        this.mapperTiendaModeltoDTO = mapperTiendaModeltoDTO;
    }

    public List<TiendaDTO> findAllTiendas() {
        List<Tienda> tiendas = tiendaRepository.findAllTiendas();
        return tiendas.stream()
                .map(mapperTiendaModeltoDTO::modelToDTO)
                .toList();
    }

    
}
