package com.imm;

public class ManagerAgencia {
	private Agencia a;
	
	public void altaAgencia(String usu, String pwd, String descripcion){
		this.a = new Agencia(usu, pwd, descripcion);
	}

	
	// FIXME - Terminar el metodo validaAgencia
	public int validaAgencia(String usu, String pwd){
		return 1;
	}
}
