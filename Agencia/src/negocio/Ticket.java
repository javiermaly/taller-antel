package negocio;

import java.util.Calendar;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import persistencia.TicketDB;

public class Ticket {
	
	private long idIMM;
	private String matricula;
	private Calendar inicioEstacionamiento;
	private int duracionEstacionamiento;
	private Calendar fechaVenta;
	private int importe;
	private long idIMMAnulacion;
	private Terminal terminal;
	
	private String delimitador = ",";
	
	public Ticket (){
		
	}
	
	public Ticket (String mat,Calendar ini,Integer dur){
		this.idIMM = 0;
		this.fechaVenta = Funciones.string2Calendar("2011-05-26 14:55:33", true);
		this.importe = 5;
		this.idIMMAnulacion = 0;
		this.terminal = new Terminal ();
		this.terminal.setIp("10.0.0.1");
		this.terminal.setNombre("prueba");
	
		this.matricula = mat;
		this.inicioEstacionamiento = ini;
		this.duracionEstacionamiento = dur;
	}
	
	public Ticket getTicket (long id) {
		TicketDB tdb = new TicketDB ();
		return tdb.getTicket(id);
	}
	
	public boolean guardar (){
		TicketDB tdb = new TicketDB ();
		return tdb.guardar(this);
	}
	
	public String toString (){	
		return this.idIMM + delimitador 
			+ this.matricula + delimitador
			+ this.inicioEstacionamiento.toString() + delimitador
			+ this.duracionEstacionamiento + delimitador
			+ this.fechaVenta.toString() + delimitador
			+ this.importe + delimitador
			+ this.idIMMAnulacion + delimitador
			+ this.terminal.toString();
	}
	
	public long getIdIMM() {
		return idIMM;
	}

	public void setIdIMM(long idIMM) {
		this.idIMM = idIMM;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Calendar getInicioEstacionamiento() {
		return inicioEstacionamiento;
	}

	public void setInicioEstacionamiento(Calendar inicioEstacionamiento) {
		this.inicioEstacionamiento = inicioEstacionamiento;
	}

	public int getDuracionEstacionamiento() {
		return duracionEstacionamiento;
	}

	public void setDuracionEstacionamiento(int duracionEstacionamiento) {
		this.duracionEstacionamiento = duracionEstacionamiento;
	}

	public Calendar getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Calendar fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public long getIdIMMAnulacion() {
		return idIMMAnulacion;
	}

	public void setIdIMMAnulacion(long idIMMAnulacion) {
		this.idIMMAnulacion = idIMMAnulacion;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	
}
