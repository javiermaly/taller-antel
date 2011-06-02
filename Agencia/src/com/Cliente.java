package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	Socket socket;	
	
	public void send(){
		try {
			socket = new Socket("localhost", 8080);
			socket.setSoTimeout(100000);
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			out.print("Solicitud de orden venta\n\r");         			
			out.flush();
			String retorno;
			if((retorno=in.readLine())!=null){
				System.out.println("Cliente - send - Respuesta: "+retorno);	
			}			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		new Cliente().send();
	}
}
