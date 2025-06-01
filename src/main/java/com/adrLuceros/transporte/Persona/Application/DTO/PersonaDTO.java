package com.adrLuceros.transporte.Persona.Application.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class PersonaDTO {
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
    private int cargoIdCargo;
    
}
