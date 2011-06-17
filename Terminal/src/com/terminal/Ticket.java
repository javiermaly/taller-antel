package com.terminal;

import java.util.Calendar;




public class Ticket {
	
	private String matricula;
	private Calendar inicioEstacionamiento;
	private int duracionEstacionamiento;
	private String idVenta;
	
	
	
	
	public Ticket (){
		
	}
	
	public Ticket (String mat,Calendar ini,Integer dur){
		
		//this.fechaVenta = Funciones.string2Calendar("2011-05-26 14:55:33", true);
		
		this.matricula = mat;
		this.inicioEstacionamiento = ini;
		this.duracionEstacionamiento = dur;
	}
	
	
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Calendar getInicioEstacionamiento() {
		return inicioEstacionamiento;
	}

	public void setInicioEstacionamiento(Calendar inicioEstacionamiento) {
		this.inicioEstacionamiento = inicioEstacionamiento;
	}

	public int getDuracionEstacionamiento() {
		return duracionEstacionamiento;
	}

	public void setDuracionEstacionamiento(int duracionEstacionamiento) {
		this.duracionEstacionamiento = duracionEstacionamiento;
	}
	
	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	@Override
	public String toString(){
		String usu="";
		usu=matricula+","+Funciones.calendar2String(inicioEstacionamiento,true)+","+duracionEstacionamiento;
		return usu;
	}

	


	
}
