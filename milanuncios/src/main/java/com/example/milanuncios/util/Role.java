package com.example.milanuncios.util;

import java.util.List;
import java.util.Objects;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
	


	
}
