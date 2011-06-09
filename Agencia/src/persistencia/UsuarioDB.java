package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import negocio.Usuario;
import negocio.UsuarioAdministrador;
import negocio.UsuarioTerminal;

public class UsuarioDB {
/*	
	usuario: varchar (10) PK
	password: varchar (20)
	nombre: varchar (255)
	tipo: int FK TipoUsuario
*/	
	private final String tipoUsuAdmin = "UsuarioAdministrador";
	private final String tipoUsuTer = "UsuarioTerminal";
	private final int idTipoUsuAdmin = 1;
	private final int idTipoUsuTer = 2;
	
	private Connection con = null;
	
	private void abrirConexion (){
		try {
			if (this.con == null || this.con.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/agencia", "root", "root");
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

	
	public boolean guardar(Usuario u){
		
 		String strSQL = "";
		String strSQLValues = "";
		int i = 0;
		
		try {
			this.abrirConexion();
			Statement stmt = con.createStatement();

			strSQL = "INSERT INTO Usuarios (usuario,password,nombre,tipo)";
			strSQLValues = "values ('" + u.getId() + "', '" + u.getPassword() +  "', '" + u.getNombre() + "'";
			
			if (Class.forName(tipoUsuAdmin).isInstance(u)) {
				strSQLValues = strSQLValues + ", " + idTipoUsuAdmin + ")";
			}
			else if (Class.forName(tipoUsuTer).isInstance(u)) {
				strSQLValues = strSQLValues + ", " + idTipoUsuTer + ")";
			}
			else {
				strSQL = "";
				strSQLValues = "";
			}
			if (strSQL == "") i = 0;
			else i = stmt.executeUpdate(strSQL + strSQLValues);
			this.cerrarConexion();
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return (i!=0);
	}

	
	public Usuario getUsuario (String usu){
		Usuario u = null;
		int tipo;
		try {
			String strSQL = "SELECT * " +
						" FROM Usuarios " +
						" WHERE usuario = '" + usu + "'";
			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				tipo = r.getInt("tipo");
				switch (tipo) {
					case idTipoUsuAdmin:
						u = new UsuarioAdministrador(r.getString("usuario"),r.getString("password"),r.getString("nombre"));
						break;
					case idTipoUsuTer:
						u = new UsuarioTerminal(r.getString("usuario"),r.getString("password"),r.getString("nombre"));
						break;
					default:
						u = null;
						break;
				}
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}