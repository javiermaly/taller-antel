<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Enumeration,java.util.Vector,com.imm.Agencia"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Agencia" scope="session" class="com.imm.Agencia" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Agencia</title>


</head>
<body>
<form action="BajaAgencia.do" method="get">
	Seleccione la agencia deseada:   
	
	<select name="id" size="1">
		<option value="0"></option>
		<%	
			Vector <Agencia> v  = Agencia.listaAgencias();
			Enumeration <Agencia> e = v.elements();
			Agencia ag=null;
			for (int i=0;e.hasMoreElements();i++){
				ag = (Agencia) e.nextElement();
				System.out.println(ag.getId()+" - "+ag.getdescripcion());
		%>
		
		<option value=<%=ag.getId()%>><%=ag.getdescripcion()%></option>
			<%	
				}
			%>
	</select> 
	<br>
	<input type="submit" value="Eliminar">
</form>
</body>
</html>