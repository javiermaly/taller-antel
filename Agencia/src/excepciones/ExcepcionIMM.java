package excepciones;

public class ExcepcionIMM extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527278347183121013L;
	private String mensaje;
	
	public ExcepcionIMM(String mensaje){
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
