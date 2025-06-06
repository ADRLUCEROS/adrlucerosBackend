package com.adrLuceros.transporte.Empresa.Domain.Models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Empresa {

    private int idEmpresa;
    private String razonSocial;
    private String ruc; 
    private String snActivo;
    
}
