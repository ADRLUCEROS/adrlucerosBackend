package com.adrLuceros.transporte.ClienteCorporativo.Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteCorporativoDTO {

    private int idClienteCorporativo;
    

    private String nombre;

    private String razonSocial;

    private String direccionFiscal;


    private String snActivo;
    
}
