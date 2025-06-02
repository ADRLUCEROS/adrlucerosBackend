package com.adrLuceros.transporte.ClienteCorporativo.Application.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndEmpresa;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.ClienteCorporativoDTO;
import com.adrLuceros.transporte.ClienteCorporativo.Application.Mapper.CCMapperModelsAndDTO;
import com.adrLuceros.transporte.ClienteCorporativo.Domain.Models.ClienteCorporativo;
import com.adrLuceros.transporte.ClienteCorporativo.Domain.Repository.ClienteCorporativoRepository;
import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Empresa.Application.Servicio.EmpresaService;

@Service
public class ClienteCorporativoService {

    private final ClienteCorporativoRepository clienteCorporativoRepository;
    private final CCMapperModelsAndDTO ccMapperModelsAndDTO;
    private final EmpresaService empresaService;
    public ClienteCorporativoService(ClienteCorporativoRepository clienteCorporativoRepository, CCMapperModelsAndDTO ccMapperModelsAndDTO,EmpresaService empresaService) {
        this.clienteCorporativoRepository = clienteCorporativoRepository;
        this.ccMapperModelsAndDTO = ccMapperModelsAndDTO;
        this.empresaService = empresaService;
    }

    public CCAndEmpresa findById(int idClienteCorporativo){
      ClienteCorporativo clienteCorporativo =  clienteCorporativoRepository.findById(idClienteCorporativo);
        EmpresaDTO empresaDTO = empresaService.findById(clienteCorporativo.getEmpresaId());

        if (clienteCorporativo != null && empresaDTO != null) {
            return ccMapperModelsAndDTO.ModelsToDTO(clienteCorporativo, empresaDTO);
        } else {
            return null; // or throw an exception if preferred                                          
            
        }   
    }
    public List<CCAndEmpresa> findAll() {
        List<ClienteCorporativo> clienteCorporativos = clienteCorporativoRepository.findAll();
        return clienteCorporativos.stream()
                .map(cliente -> {
                    EmpresaDTO empresaDTO = empresaService.findById(cliente.getEmpresaId());
                    return ccMapperModelsAndDTO.ModelsToDTO(cliente, empresaDTO);
                })
                .toList();
    }

    public void save(ClienteCorporativoDTO clienteCorporativodDTO) {
        ClienteCorporativo clienteCorporativo = ccMapperModelsAndDTO.DTOToModels(clienteCorporativodDTO);
        clienteCorporativoRepository.save(clienteCorporativo);
        
    }
    public void update(ClienteCorporativoDTO clienteCorporativodDTO) {
        ClienteCorporativo clienteCorporativo =  clienteCorporativoRepository.findById(clienteCorporativodDTO.getIdClienteCorporativo());
        if (clienteCorporativo != null) {
            ccMapperModelsAndDTO.updateModelsFromDTO(clienteCorporativodDTO, clienteCorporativo);
            clienteCorporativoRepository.update(clienteCorporativo);
        } else {
            throw new RuntimeException("Cliente Corporativo not found with id: " + clienteCorporativodDTO.getIdClienteCorporativo());
        }   

    }
    public void delete(ClienteCorporativoDTO clienteCorporativodDTO) {
        ClienteCorporativo clienteCorporativo =  clienteCorporativoRepository.findById(clienteCorporativodDTO.getIdClienteCorporativo());
        if (clienteCorporativo != null) {
            ccMapperModelsAndDTO.updateModelsFromDTO(clienteCorporativodDTO, clienteCorporativo);
            clienteCorporativoRepository.delete(clienteCorporativo);
        } else {
            throw new RuntimeException("Cliente Corporativo not found with id: " + clienteCorporativodDTO.getIdClienteCorporativo());
        }  
    }
    
}
