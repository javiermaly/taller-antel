<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.imm.Agencia"%> 
<jsp:useBean id="Agencias" scope="session" class="com.imm.Agencia" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Agencia</title>
<b>Datos de la agencia.</b>
</head>
<body>

<form action="modificaAgencia.do"> 
		<%
			Agencia ag=null;
					
			ag=Agencias.getAgencia(Integer.parseInt(request.getParameter("id")));
			
		%>
		Id: <input type="text" name="id" disabled="disabled" value=<%= ag.getId() %>>
		<br>
		Descripcion: <input type="text" name="descripcion" value=<%=ag.getdescripcion() %>>
		<br>
		Usuario: <input type="text" name="usuario" value=<%=ag.getUsu() %>>
		<br>
		Password: <input type="password" name="password" value=<%=ag.getPwd() %>>
		<br>
		<%if(ag.isHabilitada()){ %>
		Habilitada: <select name="habilitada">
					<option value=1 selected="selected"> SI </option>
					<option value=0> NO </option>
		<%}else{%>
		Habilitada: <select name="habilitada">
					<option value=1> SI </option>
					<option value=0 selected="selected"> NO </option>
		<%}%>
			</select>
		<br>
	<input type="submit" value="Modificar">
	</form>

</body>
</html>