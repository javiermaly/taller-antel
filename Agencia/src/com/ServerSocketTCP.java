package com;

import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Vector;

public class ServerSocketTCP extends Thread{
	public void servicio(){
		//En caso de querer tener en el server socket una referencia a todos los hilos que inicia ("Thread")
		//Vector<Hilo>children= new Vector<Hilo>();		
		try {	
			boolean seguir=true;
			ServerSocket server = new ServerSocket(8085);	
			System.out.println("ServerSocketTCP - servicio - LISTENER");
			while (seguir) {
				try {
					Socket socket = server.accept();	
					System.out.println("ServerSocketTCP - nuevo hilo");
					socket.setSoTimeout(100000);
					Hilo hilo=new Hilo(socket);
					hilo.start();
					//children.add(socketServidor);
					//System.out.println("ServerSocketTCP - servicio - Child creado - total children: "+children.size());
				} catch (Exception e1) {					
					System.out.println("ServerSocketTCP - servicio - Exception "+ e1);
				}
			}
			System.out.println("ServerSocketTCP - fin del while");
		} catch (Exception e) {
			System.out.println("ServerSocketTCP - servicio - Exception"+ e);
			e.printStackTrace();
		}
	}
	public void run(){
		servicio();
	}
}
