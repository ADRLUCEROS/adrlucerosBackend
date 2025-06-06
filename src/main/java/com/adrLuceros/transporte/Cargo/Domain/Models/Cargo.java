package com.adrLuceros.transporte.Cargo.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Cargo {

    private int idCargo;
    private String nombre_cargo;
    private String descripcion;
    private String snActivo;
    
}
