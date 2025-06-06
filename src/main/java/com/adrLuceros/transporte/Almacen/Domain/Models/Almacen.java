package com.adrLuceros.transporte.Almacen.Domain.Models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Almacen {

    private int idAlmacen;
    private String nombreAlmacen;
    private String direccion;
    private int id_locacion_peru;
    private int clienteCorporativoId;
    private String snActivo;

    
}
