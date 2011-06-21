package negocio;

import persistencia.UsuarioDB;

public class Usuario {
	private String id;
	private String password;
	private String nombre;
	
	public Usuario getUsuario (String usu, Long idTipo){
		UsuarioDB udb = new UsuarioDB ();
		return udb.getUsuario(usu, idTipo);
	}		
		
	public boolean guardar (){
		UsuarioDB udb = new UsuarioDB ();
		return udb.guardar(this);
	}
	
	public boolean bajar (){
		return true;
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
