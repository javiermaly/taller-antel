package com.imm;

import java.util.Date;

public class Tarifa {
	
	private TarifaDB udb = new TarifaDB();
	
	private int valor;
	private Date fechaInicio;
	private Date fechaFin;
	
	//FIXME Obtener el valor de la base.
	public Tarifa(){
		this.valor = 5;
		//this.valor = udb.obtenerTarifa();
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
