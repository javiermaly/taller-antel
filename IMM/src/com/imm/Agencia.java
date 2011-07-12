package com.imm;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class Agencia {
	private int id;
	private String usu;
	private String pwd;
	private String descripcion;
	private boolean habilitada;
	
	//private AgenciaDB adb = new AgenciaDB();
	
	public Agencia(String usu, String pwd, String descripcion){
		this.usu = usu;
		this.pwd = pwd;
		this.descripcion = descripcion;
		this.habilitada = true;
		
		new AgenciaDB().guardar(this);
		
	}

	public Agencia(String usu, String pwd) {
		this.usu = usu;
		this.pwd = pwd;
	}

	public Agencia() {
		// TODO Auto-generated constructor stub
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

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	public int validaAgencia(Agencia a) {
		return new AgenciaDB().validaAgencia(a);
	}
	
	public Vector<Agencia> listaAgencias(){
		Vector<Agencia> vecAgencias;
		vecAgencias= new AgenciaDB().listaAgencias();
		return vecAgencias;
	}
	

	
}
