package com.imm;

public class Usuario {
	private String usu;
	private String pwd;
	private String nombre;
	
	private UsuarioDB udb = new UsuarioDB();
	
	public Usuario(String usu, String pwd){
		this.usu = usu;
		this.pwd = pwd;
	}
	
	public boolean existeUsuario(Usuario u){
		return udb.existeUsuario(u);
	}

	public String getUsu() {
		return usu;
	}

	public void setUsu(String usu) {
		this.usu = usu;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UsuarioDB getUdb() {
		return udb;
	}

	public void setUdb(UsuarioDB udb) {
		this.udb = udb;
	}
}
