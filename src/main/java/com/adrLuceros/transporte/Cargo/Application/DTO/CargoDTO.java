package com.adrLuceros.transporte.Cargo.Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CargoDTO {

    private int idCargo;
    private String nombre_cargo;
    private String descripcion;
    
}
