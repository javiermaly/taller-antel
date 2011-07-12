package gui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ManagerUsuario;

/**
 * Servlet implementation class AltaUsuarios
 */
public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public AltaUsuarios() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usu;
		String pwd;
		String nom;
		int idTipo;
		ManagerUsuario mu;
		RequestDispatcher rd;
		
		System.out.println("AltaUsuarios");
		
		usu = request.getParameter("txtId").toString();
		pwd = request.getParameter("passClave").toString();
		nom = request.getParameter("txtNombre").toString();
		idTipo = Integer.parseInt(request.getParameter("comboTipo").toString());
		//Integer.parseInt(request.getParameter("txtId").toString()), request.getParameter("txtNombre").toString(), Integer.parseInt(request.getParameter("comboCategoria").toString()), Long.parseLong(request.getParameter("txtPrecio").toString()), request.getParameter("txtDescripcion").toString());
		if (validaFormato (usu,pwd,nom,idTipo)){
			mu = new ManagerUsuario();
			if (mu.alta(usu, pwd, nom, idTipo))
				rd = request.getRequestDispatcher("/Administrador/Menu.html");
			else
				rd = request.getRequestDispatcher("/Administrador/Error.html");
		}
		else {
			System.out.println("ERROR de formato en los valores ingresados");
			rd = request.getRequestDispatcher("/Administrador/Error.html");
		}
		rd.forward(request, response);
	}

	private boolean validaFormato (String usuario, String password, String nombre, int idTipo){
		boolean valido = false;
		try {
			if (usuario.length()>0 && usuario.length()<= 10 && password.length()>0 && password.length()<= 20 && nombre.length()>0 && nombre.length()<= 255 && idTipo > 0)
				valido = (new ManagerUsuario().getUsuario(usuario,idTipo) == null);
		} catch (Exception e){
			valido = false;
		}
		return valido;
	}
}
