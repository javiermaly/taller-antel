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
		ter.setHabilitado(true);
		return ter.guardar();
	}
	
	public boolean baja (String ip){
		ter = new Terminal ().getTerminal(ip);
		if (ter==null)
			return false;
		else {
			ter.setHabilitado(false);
			return ter.guardar();
		}
	}
}
