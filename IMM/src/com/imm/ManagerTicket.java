package com.imm;

import java.util.Calendar;
import java.util.Date;

public class ManagerTicket {
	private Ticket t;
	private Tarifa tar;
	
	public String venta(String usu, String pwd, String matricula, Calendar inicio, int duracion){
		String ticketRespuesta = "";
		String delimitador = ",";
		int agVal = -1;
		int valorTicket = 0;
		
		ManagerAgencia ma = new ManagerAgencia();
		
		agVal = ma.validaAgencia(usu, pwd);
		
		if (agVal != -1){
			tar = new Tarifa();
			
			valorTicket = tar.getValor() * duracion;
			t = new Ticket(matricula, inicio, duracion, valorTicket, agVal);
			
			ticketRespuesta = t.getId() + delimitador
			+ t.getMatricula() + delimitador
			+ Funciones.calendar2String(t.getInicioEstacionamiento(), true) + delimitador
			+ t.getDuracionEstacionamiento() + delimitador
			+ Funciones.calendar2String(t.getFecha(), true) + delimitador
			+ t.getImporte() + delimitador
			+ t.getIdAnulacion();
			
		}else{
			ticketRespuesta = "Error en loggin de Agencia";
		}
		
	
		return ticketRespuesta;
	}
}
