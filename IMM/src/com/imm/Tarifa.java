package com.imm;

import java.util.Date;

public class Tarifa {
	private int valor;
	private Date fechaInicio;
	private Date fechaFin;
	
	// FIXME terminar la clase
	public Tarifa(){
		this.valor = 5;
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
