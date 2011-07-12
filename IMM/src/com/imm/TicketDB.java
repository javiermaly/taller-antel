package com.imm;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

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
					
					Calendar fecha = Calendar.getInstance();
					fecha.setTimeInMillis(rs.getTimestamp("fecha").getTime());
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

			Calendar fecha = Calendar.getInstance();

			while(rs.next()){
				t.setMatricula(rs.getString(2));
				
				fecha.setTimeInMillis(rs.getDate(3).getTime());
				t.setInicioEstacionamiento(fecha);
				
				t.setDuracionEstacionamiento(rs.getInt(4));
				
				fecha.setTimeInMillis(rs.getDate(5).getTime());
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
	
	public Vector<Ticket> reporte1(String [] f_ini, String [] f_fin){
		String sql = "select * from tickets where fecha between '" + f_ini[2] + "-" + f_ini[1] + "-" + f_ini[0] + " 00:00:00' and '" + f_fin[2] + "-" + f_fin[1] + "-" + f_fin[0] + " 23:59:59'";
		Vector<Ticket> vec=new Vector<Ticket>();
		
		try {
			pstmt = cn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Calendar fecha = Calendar.getInstance();
			
			while(rs.next()){
				
				Ticket t = new Ticket();
				t.setId(Integer.parseInt(rs.getString("id")));
				
				t.setMatricula(rs.getString(2));
				
				fecha.setTimeInMillis(rs.getDate(3).getTime());
				t.setInicioEstacionamiento(fecha);
				
				t.setDuracionEstacionamiento(rs.getInt(4));
				
				fecha.setTimeInMillis(rs.getDate(5).getTime());
				t.setFecha(fecha);
				
				t.setImporte(rs.getInt(6));
				t.setIdAnulacion(rs.getInt(7));
				t.setIdAgencia(rs.getInt(8));
				
				vec.add(t);
			}
						
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				closeCn();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return vec;
	}

}
