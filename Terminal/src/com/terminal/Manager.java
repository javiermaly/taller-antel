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
		ticket=null;
		ticket=formateaRespuesta(tick);
				
		
		return ticket;
	}
	
	private Ticket formateaRespuesta(String resp){
		Ticket t=new Ticket();
		int importe;
		String [] datos;
		datos=resp.split(",");
		//FORMATO TICKET DEVUELTO 1001,NAA1310,2011-06-11 21:50:33,60,2011-06-20 21:50:33,18,0
//		idVenta,matricula,fechaInicioEst,duracion,fechaVenta,importe,idAnulacion
		t.setIdVenta(datos[0]);
		t.setMatricula(datos[1]);
		t.setInicioEstacionamiento(Funciones.string2Calendar(datos[2],true));
		t.setDuracionEstacionamiento(Integer.parseInt(datos[3]));
		t.setFechaVenta(Funciones.string2Calendar(datos[4], true));
		importe=Integer.parseInt(datos[5]);
		t.setImporte(importe);
		t.setIdAnulacion(Integer.parseInt(datos[6]));
	
		return t;
	}
	

}
