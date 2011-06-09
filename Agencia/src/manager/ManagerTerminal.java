package manager;

import negocio.Terminal;

public class ManagerTerminal {

	private Terminal ter;
	
	public Terminal getTerminal (String ip){
		ter = new Terminal();
		return ter.getTerminal(ip);
	}
	
	public boolean alta (String ip, String nombre){
		ter = new Terminal ();
		ter.setIp(ip);
		ter.setNombre(nombre);
		return ter.guardar();
	}
	
	public boolean baja (String ip){
		return true;
	}
}
