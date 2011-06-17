package manager;

import java.util.Calendar;

import com.ConexionIMM;

import excepciones.ExcepcionAnularTicket;

import negocio.Terminal;
import negocio.Ticket;

public class ManagerTicket {

	private Ticket t;
	private ConexionIMM c = new ConexionIMM ();
/*
 	private String uAg;
	private String pAg;
*/

	
	public String venta (String mat, Calendar ini,int dur, Terminal ter){
		System.out.println("MT - venta");
		System.out.println(mat+", "+ini.toString()+", "+dur+", "+ter.toString());
		String res = "";
		t = new Ticket(mat,ini,dur);
//		c = new ConexionIMM ();
		System.out.println("inicio conexion");
		t = c.ventaTicket(t,this.getUsuarioAgencia(),this.getPasswordAgencia());
		System.out.println("fin conexion");
		if (t.getIdIMM()!=0){ // puede convenir t != null
			t.setTerminal(ter);
			System.out.println("ticket completo");
			if (t.guardar()){
				System.out.println("ticket guardado");
				res = t.toString();
			}
		}
		return res;
	}

	//Diego
	public String anula(long idIMM) throws ExcepcionAnularTicket{
		String res = "";
		String strExcepcion = null;
		t = new Ticket();
		
		t = t.getTicket(idIMM);
		
		if(t!=null && t.getIdIMMAnulacion()==0){
			// El ticket no está anulado, debo proceder a anularlo.
//			ConexionIMM c = new ConexionIMM();
			t = c.anulaTicket(t, this.getUsuarioAgencia(),this.getPasswordAgencia());
			if(t.getIdIMMAnulacion()!=0){
				if (t.guardar()){
					res = t.toString();
				}
				else strExcepcion = "No se pudo guardar";
			}
			else strExcepcion = "Ticket previamente anulado en la IMM";
		}
		else strExcepcion = "Ticket previamente anulado en la Agencia";
/*			
		}else {
			ExcepcionAnularTicket e= new ExcepcionAnularTicket("TICKET YA ANULADO");
			throw e;
		}
*/
		if (strExcepcion != null) {
			ExcepcionAnularTicket e= new ExcepcionAnularTicket(strExcepcion);
			throw e;			
		}
		return res;
	}
	
	private String getUsuarioAgencia(){
		return "us";
	}
	
	private String getPasswordAgencia(){
		return "ps";
	}
}
