package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import manager.ManagerTerminal;
import manager.ManagerTicket;
import manager.ManagerUsuario;
import negocio.Funciones;
import negocio.Terminal;

public class Hilo extends Thread {
	Socket socket;

	private String [] datos;
	private String delimitador = ",";
	private String op;
	private String opVenta = "venta";
	private String opLogin = "login";
	private Terminal ter;

	private ManagerTerminal mter;
	private ManagerTicket mt;
	private ManagerUsuario mu;

/*
	private String texto;
	private boolean l;
	private String textoTicket;
	private String mat;
	private Calendar iniEst;
	private int durEst;
*/
	
	public Hilo(Socket s){
		socket=s;
	}
	
	public void run(){				
		try {					
			PrintWriter out= new PrintWriter(socket.getOutputStream());			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//boolean seguir=true;	
			String mensaje;
			String respuesta="";		
			System.out.println("Hilo - run - Ejecutando");
			//En caso que querer dejar la conexion abierta y quedar a la espera de la llegada de nuevas ordenes por el socket
			//while (seguir){
				if ((mensaje = in.readLine()) != null) {
					System.out.println("Hilo - run - Mensaje recibido: "+mensaje);
					System.out.println("Hilo - run - Chequeo Terminal");
					mter = new ManagerTerminal ();
					ter = mter.getTerminal (socket.getInetAddress().getHostAddress());
					if (ter == null){
						//terminal innexistente
						System.out.println("Hilo - run - Terminal innexistente: "+socket.getInetAddress().getHostAddress());
					}
					else {
						//terminal existente
						System.out.println("Hilo - run - Terminal existente: "+socket.getInetAddress().getHostAddress());						
						datos = mensaje.split(delimitador); 
						op = datos [0];
						if (op.equalsIgnoreCase(opVenta)){
							// datos supone el siguiente orden para 'venta':
							//		operacion
							//		matricula
							//		inicio estacionamiento
							//		duracion estacionamiento
							mt = new ManagerTicket ();
							respuesta = mt.venta(datos[1], Funciones.string2Calendar(datos[2], true), Integer.parseInt(datos[3]), ter);
						}
						else if (op.equalsIgnoreCase(opLogin)){
							mu = new ManagerUsuario ();
							if (mu.login(datos[1],datos[2]))
								respuesta = "si";
							else
								respuesta = "no";
						}
					}												
				}					
				out.print(respuesta+"\r\n");		
				out.flush();					
				System.out.println("Hilo - run - Respuesta Enviada: "+respuesta);
			//}									
		} catch (IOException e){
			System.out.println("Hilo - run - IOException: "+e.getMessage());
		}finally{						
			try{
				socket.close();
			}catch (IOException e) {
				System.out.println("Hilo - run - IOException: "+e.getMessage());
			}
			System.out.println("Hilo - run - CLOSE SOCKET");			
		}
	}
/*	
	private String obtenerComando (){
		return "";
	}

	private String getOperacion (String texto){
		return "";
	}
	
	private String getDatos (String texto){
		return "";
	}
*/
}
