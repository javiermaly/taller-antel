package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Vector;

import negocio.Funciones;
import negocio.Terminal;
import negocio.Ticket;

public class TicketDB {

	private Connection con = null;
	
	private void abrirConexion (){
		try {
			if (this.con == null || this.con.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/agencia", "root", "");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}				
	}
	
	private void cerrarConexion (){
		try {
			if (!(this.con == null || this.con.isClosed())) {
				this.con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public boolean guardar(Ticket t){
		
 		String strSQL = "";
		String strSQLValues = "";
		int i = 0;
		
		try {
			this.abrirConexion();
			Statement stmt = con.createStatement();

			strSQL = "INSERT INTO Tickets (idIMM, matricula,inicioEstacionamiento,duracionEstacionamiento,fecha,importe,terminal";
			strSQLValues = "values (" + t.getIdIMM() + ", '" + t.getMatricula() + "', '" + Funciones.calendar2String(t.getInicioEstacionamiento(),true) + "', " + t.getDuracionEstacionamiento() + ", '" + Funciones.calendar2String(t.getFechaVenta(),true) + "', " + t.getImporte() + ", '" + t.getTerminal().getIp() + "'";
			
			if (t.getIdIMMAnulacion() != 0) {
				strSQL = strSQL + ", idIMMAnulacion";
				strSQLValues = strSQLValues + ", " + t.getIdIMMAnulacion();
			}
			
			strSQL = strSQL + ") ";
			strSQLValues = strSQLValues + ")";
			//strSQL = "UPDATE Terminales SET nombre = 'Prueba' WHERE ipTerminal = '10.0.0.1'";

			System.out.println(strSQL);
			System.out.println(strSQLValues);
			
			i = stmt.executeUpdate(strSQL + strSQLValues);
			this.cerrarConexion();
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return (i!=0);
	}

	
	public Ticket getTicket(long id){
		Ticket t = null;
		try {
			String strSQL = "SELECT * " +
						" FROM Tickets " +
						" WHERE idIMM = " + id;
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				t = new Ticket ();
				t.setIdIMM(id);
				t.setMatricula(r.getString("matricula"));
				t.setInicioEstacionamiento(Funciones.string2Calendar(r.getDate("inicioEstacionamiento").toString(), true));
				t.setDuracionEstacionamiento(r.getInt("duracionEstacionamiento"));
				t.setFechaVenta(Funciones.string2Calendar(r.getDate("fecha").toString(),true));
				t.setImporte(r.getInt("importe"));
				Terminal ter = (Terminal)r.getObject("terminal");
				t.setTerminal(ter);
				t.setIdIMMAnulacion(r.getLong("idIMMAnulacion"));
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

/*	
	public static Vector <Cliente> selectClientes(int sexo){		
		Vector <Cliente> vec = new Vector <Cliente> ();
		try {
			Conexion conexion = Conexion.getInstancia();
			Connection con = conexion.getCon();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM clientes WHERE sexo = " + sexo + " ORDER BY apellido, nombre");
			if (sexo == 1) {
				while(rs.next()) {
					Hombre h = new Hombre();
					h.setCedula(rs.getString("cedula"));
					h.setNombre(rs.getString("nombre"));
					h.setApellido(rs.getString("apellido"));
					h.setDireccion(rs.getString("direccion"));
					h.setDepartamento(rs.getString("departamento"));
					h.setCelular(rs.getString("celular"));
					h.setFechaNacimiento(Funciones.string2Calendar(rs.getDate("fechaNacimiento").toString()));
					h.setTalleCalzado(rs.getInt("talleCalzado"));
					h.setDeporte(rs.getString("deporte"));
					h.setCuadro(rs.getString("cuadro"));
					vec.add(h);
				}
			}
			else {
				Mujer m = null;
				while(rs.next()) {
					m = new Mujer();
					m.setCedula(rs.getString("cedula"));
					m.setNombre(rs.getString("nombre"));
					m.setApellido(rs.getString("apellido"));
					m.setDireccion(rs.getString("direccion"));
					m.setDepartamento(rs.getString("departamento"));
					m.setCelular(rs.getString("celular"));
					m.setFechaNacimiento(Funciones.string2Calendar(rs.getDate("fechaNacimiento").toString()));
					m.setEstadoCivil(rs.getString("estadoCivil"));
					m.setCantHijos(rs.getInt("cantHijos"));
					m.setProfesion(rs.getString("profesion"));
					vec.add(m);
				}
			}
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return vec;
	}
*/
}
