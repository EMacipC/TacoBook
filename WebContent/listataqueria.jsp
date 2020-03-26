<%@page import="com.generationc20.redtaqueriaweb.model.Taqueria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista taquerias</h2>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Popularidad</th>
				<th>Nivel Limpieza</th>
				<th>Ubicacion</th>
				<th>Olor</th>
				<th>Fecha</th>
			</tr>
		</thead>
		<tbody>
		<!-- Ejecutar instrucciones java -->
		<%
	
			List<Taqueria> taquerias = (List<Taqueria>)request.getAttribute("listaTaqueria");
		for(Taqueria taqueria:taquerias){
			out.write("<tr>");
			out.write("<td>"+taqueria.getId()+"</td>");
			out.write("<td>"+taqueria.getNombre()+"</td>");
			out.write("<td>"+taqueria.getPopularidad()+"</td>");
			out.write("<td>"+taqueria.getNivelLimpieza()+"</td>");
			out.write("<td>"+taqueria.getUbicacion()+"</td>");
			out.write("<td>"+taqueria.getOlor()+"</td>");
			out.write("<td>"+taqueria.getFechaCreacion()+"</td>");
			out.write("</tr>");
		}
		
		%>
		</tbody>
</table>
</body>
</html>