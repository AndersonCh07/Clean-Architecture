package com.example.demo.Cliente.Aplicacion.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDto implements Serializable{
	
    private String nombre;
	private String apellidos;
	private String tipo_identificacion;
	private Long numero_identificacion;
	private int edad;
	private String ciudad_nacimiento;
	
}
