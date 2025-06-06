package com.adrLuceros.transporte.Persona.Infrastructura.Output.Persistence.Entity;

import java.time.LocalDate;

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
@Table(name = "persona")
@Entity


public class PersonaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")   
    private int idPersona;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "num_doc")   
    private int numDoc;
    @Column(name = "num_contacto")
    private int numContacto;
    @Column(name = "num_wpp")
    private int numWpp;
    @Column(name = "fecha_nac")
    private LocalDate fechaNac; 
    @Column(name = "correo")
    private String correo;
    private String direccion;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "cargo_id_cargo")    
    private int cargoIdCargo;
    @Column(name = "sn_activo")
    private String snActivo;

    
    
}
