package com.adrLuceros.transporte.Tienda.infraestructura.output.persistence.Entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tienda")

public class TiendaJpa {

    @Column(name = "id_tienda")
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idTienda;
    @Column(name = "nombre")
    private String nombreTienda;

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "horario_fin")
    private LocalTime horarioFin;

    @Column(name = "id_tienda_ubi")
    private int idTiendaUbi;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "sn")
    private String sn;

    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "codigo_tienda")
    private String codigoTienda;

    
}
