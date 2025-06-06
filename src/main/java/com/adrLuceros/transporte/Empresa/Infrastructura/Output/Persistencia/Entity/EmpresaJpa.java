package com.adrLuceros.transporte.Empresa.Infrastructura.Output.Persistencia.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "empresa")

public class EmpresaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int idEmpresa;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "ruc")
    private String ruc; 

    @Column(name = "sn_activo")
    private String snActivo;
    
}
