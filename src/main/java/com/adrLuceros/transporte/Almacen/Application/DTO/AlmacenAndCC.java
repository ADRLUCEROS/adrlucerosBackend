package com.adrLuceros.transporte.Almacen.Application.DTO;

import com.adrLuceros.transporte.ClienteCorporativo.Application.DTO.CCAndAlmacen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlmacenAndCC {

    
    private int idAlmacen;
    private String nombreAlmacen;
    private String direccion;
    private int id_locacion_peru;
    private CCAndAlmacen clienteCorporativo;
    private String snActivo;
    
}
