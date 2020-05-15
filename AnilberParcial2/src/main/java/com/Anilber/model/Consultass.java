package com.Anilber.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consultass database table.
 * 
 */
@Entity
@NamedQuery(name="Consultass.findAll", query="SELECT c FROM Consultass c")
public class Consultass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String nombre;

	public Consultass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}