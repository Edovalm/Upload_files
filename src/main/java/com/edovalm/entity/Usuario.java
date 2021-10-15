package com.edovalm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	@Id
	private Integer id_usuario;
	private String nombre_usuario;
	private String img_usuario;
	private String email_usuario;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getImg_usuario() {
		return img_usuario;
	}
	public void setImg_usuario(String img_usuario) {
		this.img_usuario = img_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public Usuario(Integer id_usuario, String nombre_usuario, String img_usuario, String email_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.img_usuario = img_usuario;
		this.email_usuario = email_usuario;
	}
	public Usuario() {
		super();
	}
	private static final long serialVersionUID = 1L;
}
