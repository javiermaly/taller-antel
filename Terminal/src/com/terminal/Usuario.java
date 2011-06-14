package com.terminal;

public class Usuario {
	private String id;
	private String password;
	private String nombre;
	
	public Usuario(){
		
	}
	public Usuario(String usu, String pwd){
		this.id=usu;
		this.password=pwd;
	}
	
	public Usuario getUsuario (String id){
		return this;
	}
	
	public String getId () {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString(){
		String retorno="";
		retorno=this.id+"#"+this.password;
		return retorno;
	}
}
