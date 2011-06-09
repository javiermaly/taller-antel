package negocio;

public class UsuarioTerminal extends Usuario {

	public UsuarioTerminal (String usu,String pwd, String nombre){
		this.setId(usu);
		this.setPassword(pwd);
		this.setNombre(nombre);
	}
}
