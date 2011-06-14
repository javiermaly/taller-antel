package com.imm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TarifaDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	
	public TarifaDB(){
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

	public int obtenerTarifa() {
		String sql = "select * from tarifas where usuario = ? and password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		
		return 0;
	}
	
	

}
