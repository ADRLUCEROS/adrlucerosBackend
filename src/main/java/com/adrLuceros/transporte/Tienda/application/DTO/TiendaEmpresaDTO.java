package com.adrLuceros.transporte.Tienda.application.DTO;

import java.time.LocalTime;
import java.util.List;

import com.adrLuceros.transporte.Empresa.Application.DTO.EmpresaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TiendaEmpresaDTO {

        private int idTienda;
    private String nombreTienda;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private int idTiendaUbi;
    private String direccion;
    private String observacion;
    private String sn;
    private List<EmpresaDTO> empresa; 
    
}
