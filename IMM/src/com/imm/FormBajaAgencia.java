package com.imm;

import org.apache.struts.action.ActionForm;

public class FormBajaAgencia extends ActionForm {
	int id;
	String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
