package com.imm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AgenciaDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	
	public AgenciaDB(){
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
	
	public int guardar(Agencia a){
		String sql = "INSERT INTO agencias (usuario, password, descripcion, habilitada) values (?, ?, ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = -1;
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, a.getUsu());
			pstmt.setString(2, a.getPwd());
			pstmt.setString(3, a.getdescripcion());
			pstmt.setInt(4, 1);
			
			pstmt.executeUpdate();
			
			//pstmt.executeUpdate("INSERT INTO agencias (usuario, password, descripcion, habilitada) values ('usuario', 'password', 'descripcion', 1)", Statement.RETURN_GENERATED_KEYS);
			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
		        id = rs.getInt(1);
		    }
			
			rs.close();
			pstmt.close();
			closeCn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void select(){
		String sql = "select * from agencias";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()){
				System.out.print("consulta exitosa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(){
		Statement stmt = null;
		ResultSet rs = null;
		int autoIncKeyFromApi = -1;
		
		try {
			stmt = cn.createStatement();
			stmt.executeUpdate("INSERT INTO agencias (usuario, password, descripcion, habilitada) values ('usuario', 'password', 'descripcion', 1)", Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
		        autoIncKeyFromApi = rs.getInt(1);
		    }
			
			rs.close();
			stmt.close();
			closeCn();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return autoIncKeyFromApi;
	}




}
