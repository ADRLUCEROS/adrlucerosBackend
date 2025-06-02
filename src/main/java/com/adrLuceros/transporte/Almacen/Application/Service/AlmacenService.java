package com.adrLuceros.transporte.Almacen.Application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Almacen.Application.DTO.AlamcenDTO;
import com.adrLuceros.transporte.Almacen.Application.DTO.AlmacenAndCC;
import com.adrLuceros.transporte.Almacen.Application.Mapper.AlmacenMapperModelAndDTO;
import com.adrLuceros.transporte.Almacen.Domain.Models.Almacen;
import com.adrLuceros.transporte.Almacen.Domain.Repository.AlmacenRepository;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndAlmacen;
import com.adrLuceros.transporte.ClienteCorporativo.Application.Service.ClienteCorporativoService;

@Service

public class AlmacenService {

    private final AlmacenMapperModelAndDTO almacenMapperModelAndDTO;
    private final AlmacenRepository almacenRepository;
    private final ClienteCorporativoService clienteCorporativoService;

    public AlmacenService(AlmacenMapperModelAndDTO almacenMapperModelAndDTO, AlmacenRepository almacenRepository,
            ClienteCorporativoService clienteCorporativoService) {
        this.almacenMapperModelAndDTO = almacenMapperModelAndDTO;
        this.almacenRepository = almacenRepository;
        this.clienteCorporativoService = clienteCorporativoService;
    }

    public AlmacenAndCC getAlmacenAndCCById(int idAlmacen) {

        Almacen almacen = almacenRepository.findById(idAlmacen);

        CCAndAlmacen ccAndAlmacen = clienteCorporativoService.findByidforAlmacen(almacen.getIdAlmacen());
        AlmacenAndCC almacenAndCC = almacenMapperModelAndDTO.modelToDTO(almacen, ccAndAlmacen);
        return almacenAndCC;

    }

    public List<AlmacenAndCC> getAllAlmacenesAndCC() {
        List<Almacen> almacenes = almacenRepository.findAll();
        return almacenes.stream()
                .map(almacen -> {
                    CCAndAlmacen ccAndAlmacen = clienteCorporativoService.findByidforAlmacen(almacen.getIdAlmacen());
                    return almacenMapperModelAndDTO.modelToDTO(almacen, ccAndAlmacen);
                })
                .toList();  

    }

    public void save(AlamcenDTO almacenDTO) {
        Almacen almacen = almacenMapperModelAndDTO.dtoToModel(almacenDTO);
        almacenRepository.save(almacen);
    }
    
    public void update(AlamcenDTO almacenDTO) {
        Almacen almacen = almacenRepository.findById(almacenDTO.getIdAlmacen());
        
        almacenMapperModelAndDTO.updateModelFromDTO(almacen, almacenDTO);
    }
        public void delete(AlamcenDTO almacenDTO) {
        Almacen almacen = almacenRepository.findById(almacenDTO.getIdAlmacen());
        
        almacenMapperModelAndDTO.updateModelFromDTO(almacen, almacenDTO);
    }

}
