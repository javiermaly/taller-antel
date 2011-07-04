package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import negocio.Terminal;


public class TerminalDB {

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

	
	public boolean guardar(Terminal t){
		
 		String strSQL = "";
		String strSQLValues = "";
		int i = 0;
		
		try {
			this.abrirConexion();
			Statement stmt = con.createStatement();

			strSQL = "INSERT INTO Terminales (ip, nombre, habilitado)";
			strSQLValues = "values ('" + t.getIp() + "', '" + t.getNombre() + "', " + t.isHabilitado() + ")";
			
			//strSQL = "UPDATE Terminales SET nombre = 'Prueba' WHERE ipTerminal = '10.0.0.1'";
//				System.out.println(strSQL);
//				System.out.println(strSQLValues);
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

	public Terminal getTerminal(String ip){
		Terminal t = null;
		try {
			String strSQL = "SELECT * " +
						" FROM Terminales " +
						" WHERE ip = '" + ip + "'" +
						"	AND habilitado = true";
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				t = new Terminal();
				t.setIp(ip);
				t.setHabilitado(true);
				t.setNombre(r.getString("nombre"));
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
/*
 * 	public Terminal getTerminal(Terminal t){
		try {
			String strSQL = "SELECT * " +
						" FROM Terminales " +
						" WHERE ipTerminal = '" + t.getIp() + "'" +
						"	AND habilitado = true";
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				t.setHabilitado(true);
				t.setNombre(r.getString("nombre"));
			}
			else {
				t = null;
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
 */
}
