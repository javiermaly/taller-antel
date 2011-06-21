package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import negocio.TipoUsuario;

public class TipoUsuarioDB {

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

	public String getDescripcion(long id) {
		String descripcion = "";
		try {
			String strSQL = "SELECT * " +
						" FROM TipoUsuarios " +
						" WHERE id = " + id;
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				descripcion = r.getString("descripcion");
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descripcion;
	}
	
	public Vector <TipoUsuario> getTiposUsuarios(){
		Vector <TipoUsuario> v = new Vector <TipoUsuario> ();
		TipoUsuario tu = null;

		try {
			String strSQL = "SELECT * " +
						" FROM TipoUsuarios";
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				tu = new TipoUsuario();
				tu.setId(r.getLong("id"));
				tu.setDescripcion(r.getString("descripcion"));
				v.addElement(tu);
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
}
