<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Usuarios</title>
</head>
<body>
		<form name="form1" method="post" action="/Agencia/Administrador/AltaUsuarios">
			<table border="0" align ="center">
				<tr>
					<td colspan="2" align ="center">Alta de Usuarios</td>
				</tr>
				<tr> 
					<td>Usuario: </td>
					<td><input type="text" name="txtId"></td>
				</tr>
				<tr> 
					<td>Clave: </td>
					<td><input type="password" name="passClave"></td>
				</tr>
				<tr> 
					<td>Nombre: </td>
					<td><input type="text" name="txtNombre"></td>
				</tr>				
				<tr> 
					<td>Tipo: </td>
					<td>
						<select name="Tipo">
						 <option value="admin">Administrador</option>
						 <option value="ter">Terminal</option>
						</select>
					</td>
				</tr>
				<tr> 
					<td colspan="2" align ="center">
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