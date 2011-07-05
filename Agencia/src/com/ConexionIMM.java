package com;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.imm.Ws;
import com.imm.WsServiceLocator;

import negocio.Ticket;

public class ConexionIMM {

	public Ticket ventaTicket (Ticket t,String usuarioAgencia,String passwordAgencia){
/*
// 		Ws (usu,pas,mat,ini,dur)
*/
		String res = "";
		WsServiceLocator wssl = new WsServiceLocator();
		try {  
			Ws ws = wssl.getWsPort();
			res = ws.venta(usuarioAgencia, passwordAgencia, t.getMatricula(), t.getInicioEstacionamiento(), t.getDuracionEstacionamiento());
			System.out.println(res);
			if (res.equals("")){
				t.setIdIMM(0);
				t.setMatricula("WS Timeout");
			} else {
				t = t.String2Ticket(res);
			}
			//t.setIdIMM(35001);
		} catch (ServiceException e) {
			e.printStackTrace();
			t.setIdIMM(0);
			t.setMatricula(e.getMessage());
		} catch (RemoteException e) {
			e.printStackTrace();
			t.setIdIMM(0);
			t.setMatricula(e.getMessage());
		}
		return t;
	}
	
	public Ticket anulaTicket(Ticket t,String usuarioAgencia,String passwordAgencia){
		// Invoco al  WS y retorno el Ticket
		
		String res = "";
		WsServiceLocator wssl = new WsServiceLocator();
		try {  
			Ws ws = wssl.getWsPort();
			//res = ws.anulacion(usuarioAgencia, passwordAgencia, t.getIdIMM());
			System.out.println(res);
			if (res.equals("")){
				t.setIdIMM(0);
				t.setMatricula("WS Timeout");
			} else {
				t = t.String2Ticket(res);
			}
			//t.setIdIMM(35001);
		} catch (ServiceException e) {
			e.printStackTrace();
			t.setIdIMM(0);
			t.setMatricula(e.getMessage());
//		} catch (RemoteException e) {
			e.printStackTrace();
			t.setIdIMM(0);
			t.setMatricula(e.getMessage());
		}
		return t;
	}
	
}
