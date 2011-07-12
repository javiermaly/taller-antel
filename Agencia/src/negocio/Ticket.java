package negocio;

import java.util.Calendar;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import persistencia.TicketDB;

public class Ticket {
	
	private long idIMM = 0;
	private String matricula;
	private Calendar inicioEstacionamiento;
	private int duracionEstacionamiento = 0;
	private Calendar fechaVenta;
	private int importe = 0;
	private long idIMMAnulacion = 0;
	private Terminal terminal;
	
	private String delimitador = ",";
	
	public Ticket (){
		
	}
	
	public Ticket (String mat,Calendar ini,Integer dur){
/*
		this.idIMM = 0;
		this.importe = 5;
		this.idIMMAnulacion = 0;
		this.terminal = new Terminal ();
		this.terminal.setIp("10.0.0.1");
		this.terminal.setNombre("prueba");
*/
		this.fechaVenta = Funciones.string2Calendar("2011-05-26 14:55:33", true);	
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
		String s = "";		
		if (this.idIMM != 0) s = s + this.idIMM + delimitador;
		else s = s + "" + delimitador;
		if (this.matricula != null) s = s + this.matricula + delimitador;
		else s = s + "" + delimitador;
		if (this.inicioEstacionamiento != null) s = s + Funciones.calendar2String(this.inicioEstacionamiento, true) + delimitador;
		else s = s + "" + delimitador;
		if (this.duracionEstacionamiento != 0) s = s + this.duracionEstacionamiento + delimitador;
		else s = s + "" + delimitador;
		if (this.fechaVenta != null) s = s + Funciones.calendar2String(this.fechaVenta, true) + delimitador;
		else s = s + "" + delimitador;
		s = s + this.importe + delimitador;
		s = s + this.idIMMAnulacion + delimitador;
		if (this.terminal != null) s = s + this.terminal.toString();
		else s = s + "";
		return s;
	}
	
	public Ticket String2Ticket (String s){
		String [] datos;
		
		datos = s.split(delimitador); 
		
		if (datos[0].length() == 0) {
			this.setIdIMM(0);
			this.setMatricula(datos[1]);
		} else {
			this.setIdIMM(Long.parseLong(datos[0]));
			this.setMatricula(datos[1]);
			if (this.getIdIMM()!=0){
				this.setInicioEstacionamiento(Funciones.string2Calendar(datos[2], true));
				this.setDuracionEstacionamiento(Integer.parseInt(datos[3]));
				this.setFechaVenta(Funciones.string2Calendar(datos[4], true));
				this.setImporte(Integer.parseInt(datos[5]));
				this.setIdIMMAnulacion(Long.parseLong(datos[6]));
			}
		}
		return this;
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
