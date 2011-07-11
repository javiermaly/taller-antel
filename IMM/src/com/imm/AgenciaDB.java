package com.imm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AgenciaDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
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
		
		String sql = "INSERT INTO agencias (usuario, password, descripcion, habilitada) values (?, ?, ?, ?)";
		int id = -1;
		
		try {
			pstmt = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, a.getUsu());
			pstmt.setString(2, a.getPwd());
			pstmt.setString(3, a.getdescripcion());
			pstmt.setInt(4, 1);
			
			pstmt.executeUpdate();

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
		} finally {
			try {
				rs.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return id;
	}

	
	public Agencia getAgencia (int id){
		String sql = "select * from agencias where id = ?";
		Agencia a= new Agencia();
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, id);
					
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				a.setdescripcion(rs.getString(4));
				a.setHabilitada(rs.getBoolean(5));
				a.setPwd(rs.getString(3));
				a.setUsu(rs.getString(2));
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			//closeCn();
		} finally {
			try {
				rs.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
		
		
	}
	
	public boolean guardarAg(Agencia a){
		
		boolean guardada=false;
		String sql = "update agencias set descripcion = ?, usuario = ? , password = ? , habilitada = ? where id = ?";

		System.out.println(sql);
		
		try {
						
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, a.getdescripcion());
			pstmt.setString(2, a.getUsu());
			pstmt.setString(3, a.getPwd());
			pstmt.setInt(4, 1);
			pstmt.setInt(5, a.getId());
				
			System.out.println("EJECUTO EL UPDATE");
			
			pstmt.executeUpdate();
			
			guardada=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			//closeCn();
		} finally {
			try {
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return guardada;
		
	}

	public int validaAgencia(Agencia a) {
		String sql = "select * from agencias where usuario = ? and password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		int id = -1;
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, a.getUsu());
			pstmt.setString(2, a.getPwd());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				id = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			closeCn();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return id;
	}
	
	public ResultSet listaAgencias(){
		String sql = "select * from agencias";
		ResultSet listaAgencias=null;
		
		try {
			pstmt = cn.prepareStatement(sql);
			listaAgencias = pstmt.executeQuery();
						
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			//closeCn();
		} finally {
			try {
				listaAgencias.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listaAgencias;
		
		
	}
	
	

}
