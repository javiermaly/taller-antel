package manager;

import java.util.Calendar;

import com.ConexionIMM;

import excepciones.ExcepcionAnularTicket;

import negocio.Terminal;
import negocio.Ticket;
import negocio.Usuario;

public class ManagerTicket {

	private Ticket t;
	private ConexionIMM c = new ConexionIMM ();
	private Usuario uAg ;
	private final int idTipoUsuAgencia = 3;
/*
 	private String uAg;
	private String pAg;
*/

	
	
	public String venta (String mat, Calendar ini,int dur, Terminal ter){
		System.out.println("MT - venta");
		System.out.println(mat+", "+ini.toString()+", "+dur+", "+ter.toString());
		String res = "";
		t = new Ticket(mat,ini,dur);
		
		System.out.println("inicio conexion");
		t = c.ventaTicket(t,this.getUsuarioAgencia(),this.getPasswordAgencia());
		System.out.println("fin conexion");
		
		if (t.getIdIMM()!=0){ // puede convenir t != null
			t.setTerminal(ter);
			//System.out.println("ticket completo");
			if (t.guardar()){
				//System.out.println("ticket guardado");
				res = t.toString();
			}
		}
		return res;
	}

	public String anula(long idIMM) throws ExcepcionAnularTicket{
		String res = "";
		String strExcepcion = null;
		
		t = new Ticket().getTicket(idIMM);
		
		if(t!=null){
			if (t.getIdIMMAnulacion()==0){
				// El ticket no está anulado, debo proceder a anularlo.
				t = c.anulaTicket(t, this.getUsuarioAgencia(),this.getPasswordAgencia());
				
				if(t.getIdIMMAnulacion()!=0){
					if (t.guardar())
						res = t.toString();
					else
						strExcepcion = "No se pudo guardar en la Agencia";
				} else 
					strExcepcion = "Ticket previamente anulado en la IMM";
			} else 
				strExcepcion = "Ticket previamente anulado en la Agencia";
		} else 
			strExcepcion = "Ticket no tramitado por esta Agencia";

		if (strExcepcion != null) {
			ExcepcionAnularTicket e= new ExcepcionAnularTicket(strExcepcion);
			throw e;			
		}
		return res;
	}
	
	private String getUsuarioAgencia(){
		if (uAg == null)
			uAg = new Usuario().getUsuario("", idTipoUsuAgencia);
		return uAg.getId();
	}
	
	private String getPasswordAgencia(){
		if (uAg == null)
			uAg = new Usuario().getUsuario("", idTipoUsuAgencia);
		return uAg.getPassword();
	}
}