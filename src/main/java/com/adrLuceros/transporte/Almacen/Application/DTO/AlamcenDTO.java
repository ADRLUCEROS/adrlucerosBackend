package com.adrLuceros.transporte.Almacen.Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlamcenDTO {

    private int idAlmacen;
    private String nombreAlmacen;
    private String direccion;
    private int id_locacion_peru;
    private int clienteCorporativoId;
    
}
