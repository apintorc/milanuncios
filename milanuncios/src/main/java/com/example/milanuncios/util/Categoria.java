package com.example.milanuncios.util;
import java.util.List;

public class Categoria {
	private Integer id_categoria;
	private String descripcion;
	private List<Anuncio> anuncios;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(Integer id_categoria, String descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}
	public Categoria(Integer id_categoria, String descripcion, List<Anuncio> anuncios) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
		this.anuncios = anuncios;
	}
	
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Anuncio> getProductos() {
		return anuncios;
	}

	public void setProductos(List<Anuncio> productos) {
		this.anuncios = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", descripcion=" + descripcion + ", anuncios=" + anuncios
				+ "]";
	}
	
	
	
}
