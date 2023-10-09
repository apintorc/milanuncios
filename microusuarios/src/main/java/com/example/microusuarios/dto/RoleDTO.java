package com.example.microusuarios.dto;

public class RoleDTO {
	private String role;
	private String funcion;

	public RoleDTO() {
	}

	public RoleDTO(String role, String funcion) {
		super();
		this.role = role;
		this.funcion = funcion;
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
}
