<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration,java.util.Vector,com.imm.Agencia"%> 
<jsp:useBean id="Agencia" scope="session" class="com.imm.Agencia" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Agencia</title>
toy aca
</head>
<body>

<form action="modificaAgencia.do">
		<%
			Agencia ag=null;
			String idA=request.getAttribute("id").toString();
			ag=Agencia.getAgencia(Integer.parseInt(idA));
			
		%>
		Descripcion: <input type="text">
		<br>
		Usuario: <input type="text">
		<br>
		Password: <input type="text">
		<br>
		Habilitada: <select>
					<option value=1 selected="selected"> SI </option>
					<option value=0> NO </option>
		
			</select>
		<br>
	<input type="submit" value="Ver Datos">
	</form>

</body>
</html>