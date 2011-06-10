package com.imm;

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Ws {
	@WebMethod
	public String venta(String usu, String pwd, String matricula, Calendar inicio, int duracion){
		ManagerTicket mt = new ManagerTicket();
		
		return mt.venta(usu, pwd, matricula, inicio, duracion);
	}
}
