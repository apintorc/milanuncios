package com.example.milanuncios.util;

import java.util.Date;

public class Anuncio {
	private int id_anuncio;
	private String user;
	private String titulo;
	private String descripcion;
	private double precio;
	private Date fecha_publicacion;
	private Categoria categoria;
	public Anuncio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Anuncio(int id_anuncio, String user, String titulo, String descripcion, double precio,Categoria categoria) {
		super();
		this.id_anuncio = id_anuncio;
		this.user = user;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}
	public int getId_anuncio() {
		return id_anuncio;
	}
	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Anuncio [id_anuncio=" + id_anuncio + ", user=" + user + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", precio=" + precio + ", fecha_publicacion=" + fecha_publicacion + ", categoria="
				+ categoria + "]";
	}
	
	
	
	
}
