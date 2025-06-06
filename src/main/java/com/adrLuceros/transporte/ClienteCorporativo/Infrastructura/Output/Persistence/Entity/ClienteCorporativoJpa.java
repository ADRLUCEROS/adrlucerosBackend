package com.adrLuceros.transporte.ClienteCorporativo.Infrastructura.Output.Persistence.Entity;

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
@Table(name = "cliente_corporativo")

public class ClienteCorporativoJpa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_corporativo")
    private int idClienteCorporativo;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion_fiscal")
    private String direccionFiscal;

    @Column(name = "empresa_id")
    private int empresaId;

    @Column(name = "sn_activo")
    private String snActivo;
    
}
