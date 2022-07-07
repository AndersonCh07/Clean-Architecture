package com.example.demo.Cliente.Dominio.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    //@Column(name = "id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "tipo_identificacion")
	private String tipo_identificacion;
	
	@NotNull(message = "El número de identificación no debe ser nulo")
	@Positive(message = "El número de identificación no debe ser negativo")
	@Column(name = "numero_identificacion")
	private Long numero_identificacion;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "ciudad_nacimiento")
	private String ciudad_nacimiento;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Cliente(int id, String nombre, String apellidos, String tipo_identificacion, Long numero_identificacion,
			int edad, String ciudad_nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo_identificacion = tipo_identificacion;
		this.numero_identificacion = numero_identificacion;
		this.edad = edad;
		this.ciudad_nacimiento = ciudad_nacimiento;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}

	public Long getNumero_identificacion() {
		return numero_identificacion;
	}

	public void setNumero_identificacion(Long numero_identificacion) {
		this.numero_identificacion = numero_identificacion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad_nacimiento() {
		return ciudad_nacimiento;
	}

	public void setCiudad_nacimiento(String ciudad_nacimiento) {
		this.ciudad_nacimiento = ciudad_nacimiento;
	}
	
	

}
