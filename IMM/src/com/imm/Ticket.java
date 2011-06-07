package com.imm;

import java.util.Calendar;
import java.util.Date;

public class Ticket {
	private int id;
	private String matricula;
	private Calendar inicioEstacionamiento;
	private int duracionEstacionamiento;
	private Calendar fecha;
	private int importe;
	private int idAnulacion;
	private int idAgencia;
	
	private TicketDB tdb = new TicketDB();
	
	public Ticket(String matricula, Calendar inicioEstacionamiento,
			int duracionEstacionamiento, int importe,
			int idAgencia) {
		
		this.matricula = matricula;
		this.inicioEstacionamiento = inicioEstacionamiento;
		this.duracionEstacionamiento = duracionEstacionamiento;
		this.importe = importe;
		this.idAgencia = idAgencia;
		
		this.id = tdb.guardar(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public int getIdAnulacion() {
		return idAnulacion;
	}
	public void setIdAnulacion(int idAnulacion) {
		this.idAnulacion = idAnulacion;
	}
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
}
