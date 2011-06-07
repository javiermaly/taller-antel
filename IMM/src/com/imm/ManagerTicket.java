package com.imm;

import java.util.Calendar;
import java.util.Date;

public class ManagerTicket {
	private Ticket t;
	private Tarifa tar;
	
	public String venta(String usu, String pwd, String matricula, Calendar inicio, int duracion){
		int agVal = -1;
		int valorTicket = 0;
		
		ManagerAgencia ma = new ManagerAgencia();
		
		agVal = ma.validaAgencia(usu, pwd);
		
		if (agVal != -1){
			tar = new Tarifa();
			
			valorTicket = tar.getValor() * duracion;
			t = new Ticket(matricula, inicio, duracion, valorTicket, agVal);
			
			
		}else{
			
		}
		
		
		return "";
	}
}
