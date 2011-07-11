package negocio;

import persistencia.TerminalDB;

public class Terminal {
	private String ip;
	private String nombre;
	private boolean habilitado;
/*	
	public Terminal (){
		this.setIp("0.0.0.0");
		this.setNombre("");
		this.habilitado = true;
	}
*/	
	public Terminal getTerminal(String ip){
		TerminalDB tdb = new TerminalDB ();
		return tdb.getTerminal(ip); 
	}
	
	public boolean guardar (){
		TerminalDB tdb = new TerminalDB ();
		return tdb.guardar(this);
	}
	
	public String toString (){
		return this.getIp();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
