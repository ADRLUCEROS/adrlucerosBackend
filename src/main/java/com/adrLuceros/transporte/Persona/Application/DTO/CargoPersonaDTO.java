package com.adrLuceros.transporte.Persona.Application.DTO;

import java.time.LocalDate;

import com.adrLuceros.transporte.Cargo.Application.DTO.CargoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CargoPersonaDTO {

    private int idPersona;
    private String nombres;
    private String apellidos;
    private int numDoc;
    private int numContacto;
    private int numWpp;
    private LocalDate fechaNac; 
    private String correo;
    private String direccion;
    private String sexo;
    private CargoDTO cargos;
    
}
