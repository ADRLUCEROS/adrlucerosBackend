package com.adrLuceros.transporte.Tienda.domain.models;


import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tienda {

    private int idTienda;
    private String nombreTienda;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private int idTiendaUbi;
    private String direccion;
    private String observacion;
    private String sn_activo;
    private Integer idEmpresa;
    private String codigoTienda;

    
}
