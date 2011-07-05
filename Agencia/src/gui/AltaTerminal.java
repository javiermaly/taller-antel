package gui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ManagerTerminal;

/**
 * Servlet implementation class AltaUsuarios
 */
public class AltaTerminal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaTerminal() {
    	
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
		ManagerTerminal mter = null;
		int ip1;
		int ip2;
		int ip3;
		int ip4;
		String nom;
		RequestDispatcher rd;
		
		System.out.println("AltaTerminal");
		
		ip1 = Integer.parseInt(request.getParameter("txtIp1").toString());
		ip2 = Integer.parseInt(request.getParameter("txtIp2").toString());
		ip3 = Integer.parseInt(request.getParameter("txtIp3").toString());
		ip4 = Integer.parseInt(request.getParameter("txtIp4").toString());		
		nom = request.getParameter("txtNombre").toString();

		//Integer.parseInt(request.getParameter("txtId").toString()), request.getParameter("txtNombre").toString(), Integer.parseInt(request.getParameter("comboCategoria").toString()), Long.parseLong(request.getParameter("txtPrecio").toString()), request.getParameter("txtDescripcion").toString());
		if (validaFormato (ip1, ip2, ip3, ip4, nom)) {
			mter = new ManagerTerminal();
			if (mter.alta(ip1+"."+ip2+"."+ip3+"."+ip4, nom))
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

	private boolean validaFormato (int ip1, int ip2, int ip3, int ip4, String nombre){
		boolean valido = false;
		try {
			valido = ip1>0 && ip1<=255 && ip2>=0 && ip2<=255 && ip3>=0 && ip3<=255 && ip4>0 && ip4<255 && nombre.length()>0 && nombre.length()<= 45;
		} catch (Exception e){
			valido = false;
		}
		return valido;
	}
}
