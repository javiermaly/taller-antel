package manager;

import negocio.Usuario;
import negocio.UsuarioAdministrador;
import negocio.UsuarioTerminal;

public class ManagerUsuario {

	private Usuario u;
	private final String tipoAdmin = "Administrador";
	private final String tipoTer = "Terminal";
	
	public boolean alta (String usu,String pwd,String nombre,String tipo){
		if (tipo == tipoAdmin){
			u = new UsuarioAdministrador (usu,pwd,nombre);
			return u.guardar();
		}
		else if (tipo == tipoTer){
			u = new UsuarioTerminal (usu,pwd,nombre);
			return u.guardar();			
		}
		else {
			return false;	
		}
	}
	
	public boolean bajar (String usu){
		return true;
	}
	
	public boolean login (String usu,String pwd){
		return true;
	}
}
