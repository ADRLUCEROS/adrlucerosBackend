package com.adrLuceros.transporte.ProgramacionPreeliminar.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ModelExcel {

    private String clienteCorporativo;
    private String placa;
    private String almacen;
    private String psex;
    private String destinatario; // codigo de tienda
    private String tienda; //Nombre de la tienda
    private String distrito;
    private String direccion;
    private String vh; // horario de la tienda
    private String observaciones;
    
}
