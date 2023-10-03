package com.example.milanuncios.util;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class Usuario {
	private String user;
	private String email;
	private String password;
	private String rol1;
	private String rol2;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String user, String email, String password, String rol1, String rol2) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.rol1 = rol1;
		this.rol2 = rol2;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol1() {
		return rol1;
	}
	public void setRol1(String rol1) {
		this.rol1 = rol1;
	}
	public String getRol2() {
		return rol2;
	}
	public void setRol2(String rol2) {
		this.rol2 = rol2;
	}
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", email=" + email + ", password=" + password + ", rol1=" + rol1 + ", rol2="
				+ rol2 + "]";
	}
	
}
