package com.adrLuceros.transporte.ClienteCorporativo.Application.DTO;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CCAndEmpresa {


    private int idClienteCorporativo;
    

    private String nombre;

    private String razonSocial;

    private String direccionFiscal;

    private EmpresaDTO empresa;

    
}
