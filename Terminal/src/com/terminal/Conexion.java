package com.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import javax.swing.JOptionPane;



public class Conexion {

	Socket socket;	
	
	public String enviar(String accion,String param) throws TimeoutException{
		String retorno="";
		try {
			socket = new Socket("127.0.0.1", 8085);
			socket.setSoTimeout(100000);
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			out.print(accion+","+param+"\n\r");         			
			out.flush();
			
			if((retorno=in.readLine())!=null){
				return retorno;	
			
			}			
			else{
				return retorno;
				
			}
			
//			//esto no va
//			if(accion.equalsIgnoreCase("venta")){
//				return "1001,NAA1310,2011-06-11 21:50:33,60,2011-06-20 21:50:33,18,0";	
//			
//			}			
//			else{
//				return "no";
//				
//			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retorno;		
	}
	
	
}
