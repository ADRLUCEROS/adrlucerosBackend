package com.adrLuceros.transporte.Empresa.Infrastructura.Input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;
import com.adrLuceros.transporte.Empresa.Application.Servicio.EmpresaService;

@RestController
@RequestMapping("api/empresa")

public class EmpresaControllers {

    private final EmpresaService empresaService;
    public EmpresaControllers(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<EmpresaDTO> getEmpresa(@PathVariable int idEmpresa ) {
        EmpresaDTO empresa = empresaService.findById(idEmpresa);
        return ResponseEntity.ok(empresa);
    }
    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresas() {
        List<EmpresaDTO> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping
    public ResponseEntity<Void> saveEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        empresaService.save(empresaDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        empresaService.update(empresaDTO);
        return ResponseEntity.ok().build();
    } 
    
    @DeleteMapping
    public ResponseEntity<Void> deleteEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        empresaService.delete(empresaDTO);
        return ResponseEntity.ok().build();
    }   
    
}
