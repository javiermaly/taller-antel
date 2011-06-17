package com.terminal;

import java.util.Calendar;

public class Manager {
	Conexion con = new Conexion();
	String resp="";
	
	public boolean login(String usu, String pwd){
		boolean uVal=false;
		String resp="";
		Usuario u = new Usuario(usu,pwd);
		
		
		resp=con.enviar("login" ,u.toString());
		
		if(resp.equals("no")){
			uVal=false;
		}
		if(resp.equals("si")){
			uVal=true;
		}
		return uVal;
	}
	
	
	
	public Ticket altaTicket(String matricula, Calendar inicio, int duracion){
		
		Ticket ticket=new Ticket();
		
		String tick="";
		//Calendar c=Funciones.string2Calendar(inicio, true);
		ticket.setMatricula(matricula);
		ticket.setDuracionEstacionamiento(duracion);
		ticket.setInicioEstacionamiento(inicio);
		
		tick=con.enviar("venta", ticket.toString());
		ticket=formateaRespuesta(tick);
				
		
		return ticket;
	}
	
	private Ticket formateaRespuesta(String resp){
		Ticket t=new Ticket();
		String [] datos;
		datos=resp.split(",");
		t.setMatricula(datos[1]);
		
		return t;
	}
	

}
