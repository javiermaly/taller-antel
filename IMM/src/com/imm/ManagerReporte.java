package com.imm;

import java.util.Vector;

public class ManagerReporte {
	
	public Vector<Ticket> reporte1(String [] f_ini, String [] f_fin){
		TicketDB tdb = new TicketDB();
		return tdb.reporte1(f_ini, f_fin);
	}

}
