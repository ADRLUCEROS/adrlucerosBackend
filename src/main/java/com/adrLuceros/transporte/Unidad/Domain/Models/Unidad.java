package com.adrLuceros.transporte.Unidad.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Unidad {
    

    private int idUnidad;


    private String placa;


    private int anoFab;


    private double altura;


    private double ancho;


    private double longitud;


    private double pesoNeto;


    private double pesoUtil;


    private double pesoBruto;


    private double metroCubico;


    private String codTarjCircu;


    private String estado;


    private int idTienda;
    
}
