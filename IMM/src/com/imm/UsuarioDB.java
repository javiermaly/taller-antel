package com.imm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UsuarioDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	
	public UsuarioDB(){
		try {
			ctx = new InitialContext();
		    ds = (DataSource)ctx.lookup("java:MySqlDS");
		    cn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeCn(){
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(Usuario u){
		String sql = "select * from usuarios where usuario = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean e = false;
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, u.getUsu());
			pstmt.setString(2, u.getPwd());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				e = true;
			}
			
			rs.close();
			pstmt.close();
			closeCn();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return e;
	}
}
