package com.imm;

import java.util.Calendar;

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

	public String anulacion(String usu, String pwd, int id) {
		String ticketRespuesta = "";
		String delimitador = ",";
		int agVal = -1;
		
		
		ManagerAgencia ma = new ManagerAgencia();
		
		agVal = ma.validaAgencia(usu, pwd);
		
		if (agVal != -1){
			
			if (checkTicketAgencia(agVal, id) == true){
				if (t.getIdAnulacion() == 0) {
					t.anular();
					
					ticketRespuesta = t.getId() + delimitador
					+ t.getMatricula() + delimitador
					+ Funciones.calendar2String(t.getInicioEstacionamiento(), true) + delimitador
					+ t.getDuracionEstacionamiento() + delimitador
					+ Funciones.calendar2String(t.getFecha(), true) + delimitador
					+ t.getImporte() + delimitador
					+ t.getIdAnulacion();
				} else {
					ticketRespuesta = "Error, el ticket ya fue anulado";
				}
			} else{
				ticketRespuesta = "Error, el ticket no fue vendido en la agencia dada";
			}
		}else{
			ticketRespuesta = "Error en loggin de Agencia";
		}
		
	
		return ticketRespuesta;
	}

	private boolean checkTicketAgencia(int agVal, int id) {
		boolean result = false;
		
		t = new Ticket(id);
		if (t.getIdAgencia() == agVal){
			result = true;
		}
		
		return result;
	}
}
