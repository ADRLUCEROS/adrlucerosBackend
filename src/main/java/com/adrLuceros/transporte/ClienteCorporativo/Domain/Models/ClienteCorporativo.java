package com.adrLuceros.transporte.ClienteCorporativo.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ClienteCorporativo {

    private int idClienteCorporativo;
    

    private String nombre;

    private String razonSocial;

    private String direccionFiscal;

    private int empresaId;
    
}
