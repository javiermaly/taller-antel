package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import persistencia.TipoUsuarioDB;
import persistencia.UsuarioDB;

public class TipoUsuario {
	private long id;
	private String descripcion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDescripcion(long id) {
		TipoUsuarioDB tudb = new TipoUsuarioDB ();
		return tudb.getDescripcion(id);
	}
	
	public Vector <TipoUsuario> getTiposUsuarios(){
		TipoUsuarioDB tudb = new TipoUsuarioDB ();
		return tudb.getTiposUsuarios();		
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
