package com.imm;

public class ManagerUsuario {
	private Usuario u;
	
	public boolean login(String usu, String pass){
		boolean e = false;
		
		u = new Usuario(usu, pass);
		e = u.existeUsuario(u);
		
		return e;
	}
}
