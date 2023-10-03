package com.example.milanuncios.util;

import java.util.List;


public class Role {
	private String role;
	private String funcion;
	private List<Usuario> usuarios;

	public Role(String role, String funcion) {
		super();
		this.role = role;
		this.funcion = funcion;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", funcion=" + funcion + ", usuarios=" + usuarios + "]";
	}
	
	
	
}
