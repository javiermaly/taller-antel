package gui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ManagerUsuario;
/**
 * Servlet implementation class Login
 */
public class AtiendeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final int idTipoUsuAdmin = 1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtiendeLogin() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("Login - doPost");
		if (validaUsuario (request.getParameter("txtUsuario"),request.getParameter("passClave"))){		
			System.out.println("Login: Valido");
//			Bean b = new Bean();
//			b.setNombre(request.getParameter("txtUsuario"));
//			request.getSession().setAttribute("Bean", b);
			//System.out.println("AdministradorLogin: Dispatcher");
			RequestDispatcher rd = request.getRequestDispatcher("/Administrador/Menu.html");
			//System.out.println("AdministradorLogin: Forward");
			rd.forward(request, response);
		}
		else {
			System.out.println("Login: NO valido");
			RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
			rd.forward(request, response);
		}
	}

	private boolean validaUsuario (String user, String pass){
		boolean valido=false;
		ManagerUsuario mu = new ManagerUsuario ();
		
		try {
			valido = mu.login (user,pass,idTipoUsuAdmin);
//			valido=true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println("resultado: " + valido);
		return valido;
	}
}
