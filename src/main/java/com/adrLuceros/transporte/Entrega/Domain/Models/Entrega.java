package com.adrLuceros.transporte.Entrega.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Entrega {

    private int idEntrega;
    private String metroCubico;
    private String observaciones;
    private int idTienda;
    
}
