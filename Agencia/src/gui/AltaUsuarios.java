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

	private ManagerUsuario mu;
	
    /**
     * Default constructor. 
     */
    public AltaUsuarios() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usu;
		String pwd;
		String nom;
		Long idTipo;
		
		System.out.println("AltaUsuarios");
		
		usu = request.getParameter("txtId").toString();
		pwd = request.getParameter("passClave").toString();
		nom = request.getParameter("txtNombre").toString();
		idTipo = Long.parseLong(request.getParameter("comboTipo").toString());
		//Integer.parseInt(request.getParameter("txtId").toString()), request.getParameter("txtNombre").toString(), Integer.parseInt(request.getParameter("comboCategoria").toString()), Long.parseLong(request.getParameter("txtPrecio").toString()), request.getParameter("txtDescripcion").toString());
		if (validaFormato (usu,pwd,nom,idTipo)) {

				mu.alta(usu, pwd, nom, idTipo);
		}
		else
			System.out.println("ERROR de formato en los valores ingresados");

		RequestDispatcher rd = request.getRequestDispatcher("/Administrador/Menu.html");
		rd.forward(request, response);
	}

	private boolean validaFormato (String usuario, String password, String nombre, Long idTipo){
		boolean valido = false;
		try {
			if (usuario.length()>0 && usuario.length()<= 10 && password.length()>0 && password.length()<= 20 && nombre.length()>0 && nombre.length()<= 255 && idTipo > 0)
				mu = new ManagerUsuario();
				valido = (mu.getUsuario(usuario,idTipo) == null);
		} catch (Exception e){
			valido = false;
		}
		return valido;
	}
}
