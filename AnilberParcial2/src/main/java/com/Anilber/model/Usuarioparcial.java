package com.Anilber.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarioparcial database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarioparcial.findAll", query="SELECT u FROM Usuarioparcial u")
public class Usuarioparcial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contrasenia;

	private String nombre;

	public Usuarioparcial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}