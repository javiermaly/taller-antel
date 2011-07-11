<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Enumeration,java.util.Vector;"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Terminal</title>
</head>
<body>
		<form name="form1" method="post" action="/Agencia/AltaTerminal">
			<table border="0" align ="center">
				<tr>
					<td colspan="5" align ="center">Alta de Terminal</td>
				</tr>
				<tr> 
					<td colspan="1" align ="left">IP: </td>
					<td><input type="text" name="txtIp1" style=" width : 44px;"></td>
					<td><input type="text" name="txtIp2" style=" width : 44px;"></td>
					<td><input type="text" name="txtIp3" style=" width : 44px;"></td>
					<td><input type="text" name="txtIp4" style=" width : 44px;"></td>
					
				</tr>
				<tr> 
					<td colspan="1" align ="left">Nombre: </td>
					<td colspan="4" align ="left"><input type="text" name="txtNombre" style=" width : 210px;"></td>
				</tr>				
				<tr> 
					<td colspan="5" align ="center">
					<input type="submit" name="Submit" value="Agregar">
					</td>
				</tr>          
			</table>
		</form>

		<table border="0" align ="center">
			<tr>
				<td  align='center'>
					<a href="/Agencia/Administrador/Menu.html">Volver</a>
				</td>
			</tr>
		</table>
</body>
</html>