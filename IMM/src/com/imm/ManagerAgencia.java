package com.imm;

public class ManagerAgencia {
	private Agencia a;
	
	public void altaAgencia(String usu, String pwd, String descripcion){
		this.a = new Agencia(usu, pwd, descripcion);
	}

	
	// FIXME - Terminar el metodo validaAgencia
	public int validaAgencia(String usu, String pwd){
		return 5;
	}
	
	
	
	public boolean modificarAgencia(int id, String nom, String usu, String pwd){
		boolean modificada=false;
		
		Agencia a=new Agencia();
		AgenciaDB adb=new AgenciaDB();
		
		a=adb.getAgencia(id);
		
		a.setdescripcion(nom);
		a.setUsu(usu);
		a.setPwd(pwd);
		
		adb=new AgenciaDB();
		if(adb.guardarAg(a)){
			modificada=true;
		}
			
		return modificada;
		
		
	}
}
