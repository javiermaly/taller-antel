package com.imm;

public class ManagerAgencia {
	private Agencia a;
	
	public void altaAgencia(String usu, String pwd, String descripcion){
		this.a = new Agencia(usu, pwd, descripcion);
	}

	
	public int validaAgencia(String usu, String pwd){
		int id;
		
		a = new Agencia(usu, pwd);
		id = a.validaAgencia(a);
		
		return id;
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
	
	public boolean eliminarAgencia(int id){
		boolean eliminada=false;
		AgenciaDB adb=new AgenciaDB();
		Agencia a = new Agencia();
		//a= adb.getAgencia(id);
		//adb=new AgenciaDB();
		a.setId(id);
		if(adb.bajarAgencia(a))
			eliminada=true;
		
		return eliminada;
	}
}
