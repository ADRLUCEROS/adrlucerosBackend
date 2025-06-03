package com.adrLuceros.transporte.Tienda.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Empresa.Application.Servicio.EmpresaService;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaEmpresaDTO;
import com.adrLuceros.transporte.Tienda.application.Mapper.MapperRelacionTiendaEmpresa;
import com.adrLuceros.transporte.Tienda.application.Mapper.MapperTiendaModeltoDTO;
import com.adrLuceros.transporte.Tienda.domain.models.Tienda;
import com.adrLuceros.transporte.Tienda.domain.repository.TiendaRepository;


@Service
public class TiendaService {

    private final TiendaRepository tiendaRepository;
    private final MapperTiendaModeltoDTO mapperTiendaModeltoDTO;
    private final EmpresaService empresaService;
    private final MapperRelacionTiendaEmpresa mapperRelacionTiendaEmpresa;

    public TiendaService(TiendaRepository tiendaRepository, MapperTiendaModeltoDTO mapperTiendaModeltoDTO,EmpresaService empresaService,MapperRelacionTiendaEmpresa mapperRelacionTiendaEmpresa) {
        this.tiendaRepository = tiendaRepository;
        this.mapperTiendaModeltoDTO = mapperTiendaModeltoDTO;
        this.empresaService = empresaService;
        this.mapperRelacionTiendaEmpresa = mapperRelacionTiendaEmpresa;
    }

    public List<TiendaEmpresaDTO> findAllTiendas() {
        List<Tienda> tiendas = tiendaRepository.findAllTiendas();
        List<TiendaEmpresaDTO> tiendaEmpresaList = new ArrayList<>();
        
        for (Tienda tienda : tiendas) {
            TiendaDTO tiendaDTO = mapperTiendaModeltoDTO.modelToDTO(tienda);
            
            if(tiendaDTO.getSn() == null) continue;

            if (tiendaDTO.getIdEmpresa() == null || tiendaDTO.getIdEmpresa() == 0) {
                tiendaEmpresaList.add(mapperRelacionTiendaEmpresa.mapToTiendaEmpresaDTOListSinEmpresa(tiendaDTO));
            } else {
                EmpresaDTO empresa = empresaService.findById(tiendaDTO.getIdEmpresa());

                if (empresa == null) {
                    // Puedes decidir omitirla o lanzar una excepción
                    tiendaEmpresaList.add(mapperRelacionTiendaEmpresa.mapToTiendaEmpresaDTOListSinEmpresa(tiendaDTO));
                } else {
                    tiendaEmpresaList.add(mapperRelacionTiendaEmpresa.mapToTiendaEmpresaDTOList(empresa, tiendaDTO));
                }
            }
        }
        
        return tiendaEmpresaList;
    }

    public TiendaEmpresaDTO findTiendaById(int idTienda) {
        TiendaDTO tiendaDTO = mapperTiendaModeltoDTO.modelToDTO(tiendaRepository.findTiendaById(idTienda));
    
        
        EmpresaDTO empresa = empresaService.findById(tiendaDTO.getIdEmpresa());
         

         return mapperRelacionTiendaEmpresa.mapToTiendaEmpresaDTOList(empresa, tiendaDTO);
    }

    public void saveTienda(TiendaDTO tiendaDTO) {
        Tienda tienda = mapperTiendaModeltoDTO.dtoToModel(tiendaDTO);
         tiendaRepository.saveTienda(tienda);
        
    }
    public void updateTienda(TiendaDTO tiendaDTO) {
        Tienda tienda = mapperTiendaModeltoDTO.dtoToModel(tiendaDTO);
        
        mapperTiendaModeltoDTO.updateMapper(tiendaDTO, tienda);
        tiendaRepository.updateTienda(tienda);

    }   
    
        public void deleteTienda(TiendaDTO tiendaDTO) {
        Tienda tienda = mapperTiendaModeltoDTO.dtoToModel(tiendaDTO);
        
        mapperTiendaModeltoDTO.updateMapper(tiendaDTO, tienda);
        tiendaRepository.updateTienda(tienda);

    }  
    
    public TiendaDTO findByNombreTiendaAndCodigoTienda(String nombreTienda, String codigoTienda) {
        Tienda tienda = tiendaRepository.findByNombreTiendaAndCodigoTienda(nombreTienda, codigoTienda);
        if (tienda != null) {
            return mapperTiendaModeltoDTO.modelToDTO(tienda);
        }
        return null;
    }   

    
}
