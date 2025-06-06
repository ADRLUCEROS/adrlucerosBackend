package com.adrLuceros.transporte.Empresa.Application.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmpresaDTO {
    private int idEmpresa;
    private String razonSocial;
    private String ruc; 
    private String snActivo;
    
    
}
