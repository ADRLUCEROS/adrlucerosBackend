package com.adrLuceros.transporte.Almacen.Infrastructura.Output.Persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "almacen")

public class AlmacenJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_almacen")
    private int idAlmacen;

    @Column(name = "nombre_almacen")
    private String nombreAlmacen;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "id_locacion_peru")
    private int id_locacion_peru;

    @Column(name = "cliente_corporativo_id")
    private int clienteCorporativoId;
    
}
