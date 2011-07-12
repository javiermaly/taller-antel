package negocio;

public class UsuarioAdministrador extends Usuario {
	
	public UsuarioAdministrador (String usu,String pwd, String nombre){
		this.setId(usu);
		this.setPassword(pwd);
		this.setNombre(nombre);
	}
}
