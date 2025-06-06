package com.adrLuceros.transporte.Cargo.Infrastructura.Output.Persistence.Entity;


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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo")

public class CargoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int idCargo;
    @Column(name = "nombre_cargo")
    private String nombre_cargo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "sn_activo")
    private String snActivo;
    
}
