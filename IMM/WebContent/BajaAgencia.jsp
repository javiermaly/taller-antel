<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Agencia" scope="page" class="com.imm.Agencia" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Agencia</title>


</head>
<body>
	Seleccione la agencia deseada:   
	<select name="agencias" size="1" > 
	<% 
		ResultSet rs=null;
		rs=Agencia.listaAgencias();
	%>
		
	<%
		while ( rs.next()) { 
			out.println("<option value=\"" + rs.getString(0) + "\">" + 
			rs.getString(1) + "</option>\n"); 
		} 
	%>
</select> 

</body>
</html>