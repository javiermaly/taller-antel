package prueba;

import negocio.Funciones;
import negocio.Ticket;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket t = new Ticket ("mat01",Funciones.string2Calendar("2011-05-31 11:22:33",true),30);
		if (t.guardar()){
			System.out.println("ok");
		}
		else {
			System.out.println("mal");
		}
	}

}
