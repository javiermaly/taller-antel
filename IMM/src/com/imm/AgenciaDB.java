package com.imm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

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
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void closeCn(){
		try {
			cn.close();
		} catch (SQLException e) {
	
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
		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
			
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
				a.setdescripcion(rs.getString("descripcion"));
				a.setHabilitada(rs.getBoolean("habilitada"));
				a.setPwd(rs.getString("password"));
				a.setUsu(rs.getString("usuario"));
				a.setId(rs.getInt("id"));
			}
			
		} catch (SQLException ex) {
		
			ex.printStackTrace();
			closeCn();
		} finally {
			try {
				rs.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
			
				e.printStackTrace();
				closeCn();
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
			pstmt.setBoolean(4, a.isHabilitada());
			pstmt.setInt(5, a.getId());
				
			System.out.println("EJECUTO EL UPDATE");
			
			if(pstmt.executeUpdate()>0)
				guardada=true;
			
			
		} catch (SQLException e) {
			
		
			e.printStackTrace();
			closeCn();
		} finally {
			try {
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				
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
			
			ex.printStackTrace();
		}
		
		return id;
	}
	
	public Vector<Agencia> listaAgencias(){
		String sql = "select * from agencias where habilitada=true";
		ResultSet listaAgencias = null;
		Vector<Agencia> vecAgencias=new Vector<Agencia>();
		
		
		try {
			pstmt = cn.prepareStatement(sql);
			listaAgencias = pstmt.executeQuery();
			
			while(listaAgencias.next()){
				Agencia a = new Agencia();
				a.setId(Integer.parseInt(listaAgencias.getString("id")));
				a.setdescripcion(listaAgencias.getString("descripcion"));
				a.setUsu(listaAgencias.getString("usuario"));
				a.setPwd(listaAgencias.getString("password"));
				a.setHabilitada(listaAgencias.getBoolean("habilitada"));
				vecAgencias.add(a);
			}
						
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} finally {
			try {
				listaAgencias.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return vecAgencias;
		
		
	}
	public Vector<Agencia> listaTodasAgencias(){
		String sql = "select * from agencias";
		ResultSet listaAgencias = null;
		Vector<Agencia> vecAgencias=new Vector<Agencia>();
		
		
		try {
			pstmt = cn.prepareStatement(sql);
			listaAgencias = pstmt.executeQuery();
			
			while(listaAgencias.next()){
				Agencia a = new Agencia();
				a.setId(Integer.parseInt(listaAgencias.getString("id")));
				a.setdescripcion(listaAgencias.getString("descripcion"));
				a.setUsu(listaAgencias.getString("usuario"));
				a.setPwd(listaAgencias.getString("password"));
				a.setHabilitada(listaAgencias.getBoolean("habilitada"));
				vecAgencias.add(a);
			}
						
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} finally {
			try {
				listaAgencias.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return vecAgencias;
		
		
	}
	
	public boolean bajarAgencia(Agencia a){
		boolean retorno=false;
		String sql = "update agencias set habilitada=false where id=? ";
	
		System.out.println("agencia: "+a.toString());
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, a.getId());
						
			if(pstmt.executeUpdate()>0)
				retorno=true;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
				
				e.printStackTrace();
				closeCn();
				
			}
		}
		return retorno;
		
		
	}
	
	
	

}
