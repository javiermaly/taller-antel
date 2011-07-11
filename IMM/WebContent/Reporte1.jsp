<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte 1</title>
	<link rel="stylesheet" type="text/css" media="all" href="skins/aqua/theme.css" title="Aqua" />
	<script type="text/javascript" src="jscript/calendar.js"></script>
	<script type="text/javascript" src="jscript/calendar-es.js"></script>
	<script type="text/javascript" src="jscript/calendar-setup.js"></script>
	<script type="text/javascript" src="jscript/validaciones.js"></script>

</head>
<body>
Fecha inicio:
<table>
	<tr>
		<td>
			<input type="text" id="f_ini" onchange="datevalid(this)" title="Formato: dd/mm/aa , ddmmaa" />
		</td>
		<td>
			<img src="imagenes/calendar-img.gif" id="f_ini_trigger" style="cursor: pointer;" title="Seleccione la fecha" />
		</td>
</table>

<script type="text/javascript">
		Calendar.setup({
    		inputField     :    "f_ini",     		
    		ifFormat       :    "%d/%m/%Y",      				
      		button         :    "f_ini_trigger", 	
      		align          :    "Tl",           				
		    singleClick    :    true
		});
</script>
</body>
</html>