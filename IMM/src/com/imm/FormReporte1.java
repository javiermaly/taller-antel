package com.imm;

import org.apache.struts.action.ActionForm;

public class FormReporte1 extends ActionForm {
	
	String f_ini;
	String f_fin;
	
	public String getF_ini() {
		return f_ini;
	}
	public void setF_ini(String fIni) {
		f_ini = fIni;
	}
	public String getF_fin() {
		return f_fin;
	}
	public void setF_fin(String fFin) {
		f_fin = fFin;
	}
	
}
