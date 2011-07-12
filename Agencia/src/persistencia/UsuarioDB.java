package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
	//private final String tipoUsuAg = "UsuarioAgencia";
	private final int idTipoUsuAdmin = 1;
	private final int idTipoUsuTer = 2;
	private final int idTipoUsuAgencia = 3;
	
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

	public boolean bajar (Usuario u){
 		String strSQL = "";
		int i = 0;
		
		try {
			this.abrirConexion();
			Statement stmt = con.createStatement();

			strSQL = " DELETE " +
						" FROM Usuarios " +
						" WHERE usuario = '" + u.getId() + "'";
			
			i = stmt.executeUpdate(strSQL);
			this.cerrarConexion();
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return (i!=0);
	}
	
	public Usuario getUsuario (String usu, int idTipo){
		Usuario u = null;
		
		try {
			String strSQL = "SELECT * " +
						" FROM Usuarios ";
			
			if ((usu.length() == 0) && (idTipo != 0)) 
				strSQL = strSQL +
						" WHERE tipo = " + idTipo;
			else if (idTipo != 0)
				strSQL = strSQL +
						" WHERE usuario = '" + usu + "'" +
						" 	AND tipo = " + idTipo;
			else
				strSQL = strSQL +
					" WHERE usuario = '" + usu + "'";

			this.abrirConexion();
			Statement stmt;
			stmt = con.createStatement();

			ResultSet r = stmt.executeQuery(strSQL);
		
			if (r.next()){
				idTipo = r.getInt("tipo");
				switch (idTipo) {
					case idTipoUsuAdmin:
						u = new UsuarioAdministrador(r.getString("usuario"),r.getString("password"),r.getString("nombre"));
						break;
					case idTipoUsuTer:
						u = new UsuarioTerminal(r.getString("usuario"),r.getString("password"),r.getString("nombre"));
						break;
					case idTipoUsuAgencia:
						u = new Usuario();
						u.setId(r.getString("usuario"));
						u.setPassword(r.getString("password"));
						u.setNombre(r.getString("nombre"));
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
	
	public Vector <Usuario> getUsuarios(int idTipo){
		Vector <Usuario> v = new Vector <Usuario> ();
		Usuario u = null;

		try {
			String strSQL = "SELECT * " +
				" FROM Usuarios";

			if (idTipo != 0)
				strSQL = strSQL +
					" WHERE tipo = " + idTipo;
					
			this.abrirConexion();
			
			Statement stmt;
			stmt = con.createStatement();
			ResultSet r = stmt.executeQuery(strSQL);

			while (r.next()){
				switch (idTipo) {
					case 0:
					case idTipoUsuAgencia:
						u = new Usuario();
						u.setId(r.getString("usuario"));
						u.setPassword(r.getString("password"));
						u.setNombre(r.getString("nombre"));
						break;						
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
				v.addElement((Usuario)u);
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
}