package com.adrLuceros.transporte.Tienda.application.Mapper;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaEmpresaDTO;


@Component
public class MapperRelacionTiendaEmpresa {
    
        private final ModelMapper modelMapper;
        public MapperRelacionTiendaEmpresa(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

    public TiendaEmpresaDTO mapToTiendaEmpresaDTOList(List<EmpresaDTO> empresas,TiendaDTO tiendaDTO) {
      
        TiendaEmpresaDTO tiendaEmpresaDTO = new TiendaEmpresaDTO();
        tiendaEmpresaDTO.setIdTienda(tiendaDTO.getIdTienda());
        tiendaEmpresaDTO.setNombreTienda(tiendaDTO.getNombreTienda());
        tiendaEmpresaDTO.setHorarioInicio(tiendaDTO.getHorarioInicio());
        tiendaEmpresaDTO.setHorarioFin(tiendaDTO.getHorarioFin());
        tiendaEmpresaDTO.setIdTiendaUbi(tiendaDTO.getIdTiendaUbi());
        tiendaEmpresaDTO.setDireccion(tiendaDTO.getDireccion());
        tiendaEmpresaDTO.setObservacion(tiendaDTO.getObservacion());
        tiendaEmpresaDTO.setSn(tiendaDTO.getSn());
        tiendaEmpresaDTO.setEmpresa(empresas);
        
        return tiendaEmpresaDTO;

    }

    
}
