package com.adrLuceros.transporte.Unidad.Infrastructura.Output.Persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad")
    private int idUnidad;

    @Column(name = "placa")
    private String placa;

    @Column(name = "año_fab")
    private int añoFab;

    @Column(name = "altura")
    private double altura;

    @Column(name = "ancho")
    private double ancho;

    @Column(name = "longitud")
    private double longitud;

    @Column(name = "peso_neto")
    private double pesoNeto;

    @Column(name = "peso_util")
    private double pesoUtil;

    @Column(name = "peso_bruto")
    private double pesoBruto;

    @Column(name = "metro_cubico")
    private double metroCubico;

    @Column(name = "cod_tarj_circu")
    private String codTarjCircu;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_tienda")
    private int idTienda;
}