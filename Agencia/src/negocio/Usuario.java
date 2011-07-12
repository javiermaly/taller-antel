package negocio;

import java.util.Vector;

import persistencia.UsuarioDB;

public class Usuario {
	private String id;
	private String password;
	private String nombre;
	
	public Usuario getUsuario (String usu, int idTipo){
		return new UsuarioDB ().getUsuario(usu, idTipo);
	}
	
	public Vector <Usuario> getUsuarios(int idTipo){
		return new UsuarioDB ().getUsuarios(idTipo);
	}
		
	public boolean guardar (){
		return new UsuarioDB().guardar(this);
	}
	
	public boolean bajar (){
		return new UsuarioDB().bajar(this);
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
}
