package excepciones;

public class ExcepcionAnularTicket extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4923889617274671546L;
	private String mensaje;
	
	public ExcepcionAnularTicket(String mensaje){
		super();
		this.mensaje=mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
