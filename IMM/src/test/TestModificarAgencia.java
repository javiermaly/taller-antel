package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imm.Agencia;
import com.imm.AgenciaDB;
import com.imm.ManagerAgencia;

/**
 * Servlet implementation class TestModificarAgencia
 */
public class TestModificarAgencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestModificarAgencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("Llamada al Servlet de modificar agencia");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ManagerAgencia ma= new ManagerAgencia();
		Agencia a=new Agencia();
		AgenciaDB adb=new AgenciaDB();
		
		a=adb.getAgencia(2);

		
		System.out.println(a.getdescripcion());
		System.out.println(a.getUsu());
		System.out.println(a.getPwd());
		
		a.setUsu("usuario");
		a.setdescripcion("DESCRIPCION");
		a.setPwd("password");
		a.setHabilitada(true);
		
		adb=new AgenciaDB();
		
		if(adb.guardarAg(a)){
			out.println("AGENCIA MODIFICADA");
			
		}
		else
		{
			out.println("IMPOSIBLE MODIFICAR");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
