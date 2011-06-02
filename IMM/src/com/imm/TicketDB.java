package com.imm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TicketDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	
	public TicketDB(){
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
	
	public int guardar(Ticket t){
		String sql = "INSERT INTO tickets (matricula, inicioEstacionamiento, duracionEstacionamiento, fecha, importe, idAgencia) values (?, ?, ?, sysdate(), ?, ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = -1;
		
		try {
			pstmt = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, t.getMatricula());
			pstmt.setDate(2, new java.sql.Date(t.getInicioEstacionamiento().getTime()));
			pstmt.setInt(3, t.getDuracionEstacionamiento());
			pstmt.setInt(4, t.getImporte());
			pstmt.setInt(5, t.getIdAgencia());
			
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
		        id = rs.getInt(1);
		    }
			
			if (id != -1) {
				pstmt = cn.prepareStatement("select * from tickets where id = ?");
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					t.setId(id);
					t.setFecha(rs.getDate(5));
			    }
				
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

}
