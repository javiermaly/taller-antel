package com.imm;

import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Ws {
	@WebMethod
	public String venta(String usu, String pwd, String matricula, Calendar inicio, int duracion){
		ManagerTicket mt = new ManagerTicket();
		mt.venta(usu, pwd, matricula, inicio, duracion);
		return "Server-"+"str";
		
		/*
		 public String toString (){
return this.idIMM + delimitador
+ this.matricula + delimitador
+ this.inicioEstacionamiento.toString() + delimitador
+ this.duracionEstacionamiento + delimitador
+ this.fechaVenta.toString() + delimitador
+ this.importe + delimitador
+ this.idIMMAnulacion + delimitador
+ this.terminal.toString();
}
private String delimitador = ",";

		 * */
	}
}
