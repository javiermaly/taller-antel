package com.imm;

import org.apache.struts.action.ActionForm;

public class FormLoggin extends ActionForm {
	String usu;
	String pass;
	
	public String getUsu() {
		return usu;
	}
	public void setUsu(String usu) {
		this.usu = usu;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
