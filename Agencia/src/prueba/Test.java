package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import manager.ManagerTerminal;
import manager.ManagerTicket;
import manager.ManagerUsuario;
import negocio.Funciones;
import negocio.Terminal;

public class Test {


	/**
	 * @param args
	 */
	
	private static Connection con = null;
	
	private static void abrirConexion (){
		try {
			if (con == null || con.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/agencia", "root", "");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}				
	}
//main para insertar en BD terminal
/*
	public static void main(String[] args) {
		
		abrirConexion();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			int i = stmt.executeUpdate("INSERT INTO Terminales (ip, nombre, habilitado) values ('127.0.0.1', 'localhost', true)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
*/

//Corre el WS contra IMM	
	
	public static void main(String[] args) {
		
		String [] datos;
		
		String matricula;
		Calendar inicio;
		int duracion;
		
		String delimitador = "#";
		String op;
		String opVenta = "venta";
		String opLogin = "login";
		Terminal ter;

		ManagerTerminal mter;
		ManagerTicket mt;
		ManagerUsuario mu;
		
		String mensaje = "venta#mat01#2011-05-31 11:22:33#30";
		String respuesta="";
		try {						
			System.out.println("Ejecutando");
				if (mensaje != null) {
					System.out.println("Mensaje enviado: "+mensaje);
					//System.out.println("Hilo - run - Chequeo Terminal");
					mter = new ManagerTerminal ();
					ter = mter.getTerminal ("127.0.0.1");
					if (ter == null){
						//terminal innexistente
						System.out.println("Terminal innexistente: 127.0.0.1");
					}
					else {
						//terminal existente
						System.out.println("Terminal existente");						
						datos = mensaje.split(delimitador); 
						op = datos [0];
						//System.out.println(op);
						if (op.equalsIgnoreCase(opVenta)){
							// datos supone el siguiente orden para 'venta':
							//		operacion
							//		matricula
							//		inicio estacionamiento
							//		duracion estacionamiento
							System.out.println("Venta");
							mt = new ManagerTicket ();
							respuesta = mt.venta(datos[1], Funciones.string2Calendar(datos[2], true), Integer.parseInt(datos[3]), ter);
						}
						else if (op.equalsIgnoreCase(opLogin)){
							mu = new ManagerUsuario ();
							if (mu.alta(datos[1], datos[2], datos[3], datos[4]))
								respuesta = "ok";
						}
					}												
				}					
				System.out.println("Respuesta recibida: " + respuesta);									
		} catch (Exception e){
			System.out.println("Hilo - run - IOException: "+e.getMessage());
		}finally{						
			System.out.println("Hilo - run - CLOSE SOCKET");			
		}
	}
	
}
