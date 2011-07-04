package manager;

import java.util.Vector;

import negocio.TipoUsuario;
import negocio.Usuario;
import negocio.UsuarioAdministrador;
import negocio.UsuarioTerminal;

public class ManagerUsuario {

	private Usuario u;
/*
	private final String tipoAdmin = "Administrador";
	private final String tipoTer = "Terminal";
*/	
//	private final String tipoUsuAdmin = "UsuarioAdministrador";
//	private final String tipoUsuTer = "UsuarioTerminal";
	private final int idTipoUsuAdmin = 1;
	private final int idTipoUsuTer = 2;
	
	public boolean alta (String usu,String pwd,String nombre,Long idTipo){
		
		if (idTipo == idTipoUsuAdmin){
			u = new UsuarioAdministrador (usu,pwd,nombre);
			return u.guardar();
		}
		else if (idTipo == idTipoUsuTer){
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
	
	public boolean login (String usu, String pwd, long idTipo){
		boolean res = false;
		u = this.getUsuario(usu,idTipo);
//		try {
			if (u != null)
				System.out.println(u.getClass().getName());
				TipoUsuario tu = new TipoUsuario ();
				//u.getClass().isInstance(UsuarioTerminal.class);
				if (u.getClass().getName().endsWith(tu.getDescripcion(idTipo)))
				//if (Class.forName(tipo).isInstance(u))
					if (u.getPassword().equalsIgnoreCase(pwd))
						res = true;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
		return res;
	}
	
	public Vector <TipoUsuario> getTiposUsuarios (){
		TipoUsuario tu = new TipoUsuario();
		return tu.getTiposUsuarios();
	}
	
	public Usuario getUsuario (String usu, Long idTipo){
		u = new Usuario ();
		return u.getUsuario(usu, idTipo);
	}
}
