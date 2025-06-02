package com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Input.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndEmpresa;
import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.ClienteCorporativoDTO;
import com.adrLuceros.transporte.ClienteCorporativo.Application.Service.ClienteCorporativoService;

@RestController
@RequestMapping("/api/clientecorporativo")


public class ClienteCorporativo {


    private final ClienteCorporativoService clienteCorporativoService;
    public ClienteCorporativo(ClienteCorporativoService clienteCorporativoService) {
        this.clienteCorporativoService = clienteCorporativoService;
    }

    @GetMapping
    public ResponseEntity<CCAndEmpresa> findById(@PathVariable int idClienteCorporativo) {
        CCAndEmpresa ccAndEmpresa = clienteCorporativoService.findById(idClienteCorporativo);
        if (ccAndEmpresa != null) {
            return ResponseEntity.ok(ccAndEmpresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping()
    public ResponseEntity<List<CCAndEmpresa>> findAll() {
        List<CCAndEmpresa> ccAndEmpresas = clienteCorporativoService.findAll();
        return ResponseEntity.ok(ccAndEmpresas);
    }

    @PostMapping
    public ResponseEntity<Void> save(ClienteCorporativoDTO clienteCorporativodDTO) {
        clienteCorporativoService.save(clienteCorporativodDTO);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> update(ClienteCorporativoDTO clienteCorporativodDTO) {
        clienteCorporativoService.update(clienteCorporativodDTO);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> delete(ClienteCorporativoDTO clienteCorporativodDTO) {
        clienteCorporativoService.delete(clienteCorporativodDTO);
        return ResponseEntity.ok().build();
    }
    
}
