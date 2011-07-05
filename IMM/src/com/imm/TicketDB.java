package com.imm;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class TicketDB {
	
	private InitialContext ctx = null;
	private DataSource ds = null;
	private Connection cn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
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
		String sql = "INSERT INTO tickets (matricula, inicioEstacionamiento, duracionEstacionamiento, fecha, importe, idAnulacion, idAgencia) values (?, '" + Funciones.calendar2String(t.getInicioEstacionamiento(), true) + "', ?, sysdate(), ?, 0, ?)";
		int id = -1;
		
		try {
			pstmt = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, t.getMatricula());
			pstmt.setInt(2, t.getDuracionEstacionamiento());
			pstmt.setInt(3, t.getImporte());
			pstmt.setInt(4, t.getIdAgencia());
			
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
					Calendar fecha = new GregorianCalendar(rs.getDate(5).getYear() + 1900, rs.getDate(5).getMonth(), rs.getDate(5).getDay());
					t.setFecha(fecha);
			    }
				
			}
			
		} catch (SQLException e) {		
			closeCn();
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

	public Ticket getTicket(int id) {
		String sql = "select * from tickets where id = ?";
		Ticket t= new Ticket();
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, id);
					
			rs = pstmt.executeQuery();

			Calendar fecha;

			while(rs.next()){
				t.setMatricula(rs.getString(2));
				fecha = new GregorianCalendar(rs.getDate(3).getYear(), rs.getDate(3).getMonth(), rs.getDate(3).getDay());
				t.setInicioEstacionamiento(fecha);
				t.setDuracionEstacionamiento(rs.getInt(4));
				fecha = new GregorianCalendar(rs.getDate(5).getYear(), rs.getDate(5).getMonth(), rs.getDate(5).getDay());
				t.setFecha(fecha);
				t.setImporte(rs.getInt(6));
				t.setIdAnulacion(rs.getInt(7));
				t.setIdAgencia(rs.getInt(8));
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
		
		return t;
	}

	public int anular(int id) {
		int resultado = 0;
		String sql = "select anulacionTicket(?);";
		
		
		try {
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, id);
					
			rs = pstmt.executeQuery();

			while(rs.next()){
				resultado = rs.getInt(1);
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
		
		return resultado;
		
	}

}
