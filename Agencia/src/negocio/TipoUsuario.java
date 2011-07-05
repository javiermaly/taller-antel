package negocio;

import java.util.Vector;

import persistencia.TipoUsuarioDB;

public class TipoUsuario {
	private int id;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDescripcion(int id) {
		return new TipoUsuarioDB ().getDescripcion(id);
	}
	
	public Vector <TipoUsuario> getTiposUsuarios(){
		return new TipoUsuarioDB ().getTiposUsuarios();		
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
