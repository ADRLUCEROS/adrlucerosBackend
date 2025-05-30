package com.adrLuceros.transporte.Empresa.Application.Servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Empresa.Application.Mapper.MapperEmpresaApp;
import com.adrLuceros.transporte.Empresa.Domain.Models.Empresa;
import com.adrLuceros.transporte.Empresa.Domain.Repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final MapperEmpresaApp mapperEmpresaApp;
    private final EmpresaRepository empresaRepository;

    public EmpresaService(MapperEmpresaApp mapperEmpresaApp, EmpresaRepository empresaRepository) {
        this.mapperEmpresaApp = mapperEmpresaApp;
        this.empresaRepository = empresaRepository;
    }

    public EmpresaDTO findById(int idEmpresa) {
        return mapperEmpresaApp.modelToDTO(empresaRepository.findById(idEmpresa));
    }

    public List<EmpresaDTO> findAll() {
        return empresaRepository.findAll().stream()
                .map(mapperEmpresaApp::modelToDTO)
                .toList();
    }
    public void save(EmpresaDTO empresaDTO) {
        empresaRepository.save(mapperEmpresaApp.dtoToModel(empresaDTO));
    }

    public void update(EmpresaDTO empresaDTO) {

        Empresa empresa = empresaRepository.findById(empresaDTO.getIdEmpresa());

        mapperEmpresaApp.updateMapper(empresaDTO, empresa);
        empresaRepository.update(empresa);

    }
    public void delete(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findById(empresaDTO.getIdEmpresa());
         mapperEmpresaApp.updateMapper(empresaDTO, empresa);
        empresaRepository.update(empresa);
    }
    
}
