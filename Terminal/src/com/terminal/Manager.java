package com.terminal;

import java.util.Calendar;
import java.util.concurrent.TimeoutException;

import javax.swing.JOptionPane;

public class Manager {
	Conexion con = new Conexion();
	String resp="";
	
	public boolean login(String usu, String pwd){
		boolean uVal=false;
		String resp="";
		Usuario u = new Usuario(usu,pwd);
		
		
//		try {
//			resp=con.enviar("login" ,u.toString());
//		} catch (TimeoutException e) {
//			JOptionPane.showMessageDialog(null, "Error en la operacion. Intente mas tarde.","Time Out", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
		uVal=true;
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
		try {
			tick=con.enviar("venta", ticket.toString());
		} catch (TimeoutException e) {
			JOptionPane.showMessageDialog(null, "Error en la operación, intente mas tarde.","Time Out", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		ticket=null;
		ticket=formateaRespuesta(tick);
				
		
		return ticket;
	}
	
public String anulaTicket(long idTicket){
		
		Ticket ticket=new Ticket();
		
		String tick="";
		ticket.setIdAnulacion(idTicket); 
		
		try {
			
			tick=con.enviar("anula", ticket.anula());
			
		} catch (TimeoutException e) {
			JOptionPane.showMessageDialog(null, "Error en la operación, intente mas tarde.","Time Out", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
				
		return tick;
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
