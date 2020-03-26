package com.generationc20.redtaqueriaweb.consultar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generationc20.redtaqueriaweb.db.DatabaseConection;
import com.generationc20.redtaqueriaweb.db.DatabaseConsultar;
import com.generationc20.redtaqueriaweb.model.Taquero;

@WebServlet(name="ConsultarTaquero", urlPatterns = "/cTaquero")

public class ConsultarTaquero  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Taquero taquero=null;
		Connection puente= null;	
		DatabaseConsultar chalan=null;
		String nombre= req.getParameter("txtNombre");
		
		puente=DatabaseConection.getConnection();
		chalan= new DatabaseConsultar(puente);
		taquero= chalan.consultarTaquero(nombre);
		DatabaseConection.colseConnection(puente);
		
		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_CREATED);
		PrintWriter salida= resp.getWriter();
		
		salida.write("<DOCTYPE html>");
		salida.write("<html>");
		salida.write("<head>");
		salida.write("<title>Consulta Taquero</title>");
		salida.write("</head>");
		salida.write("<body>");
		salida.write("<p>id= "+taquero.getId()+" </p>");
		salida.write("<p>Nombre= "+taquero.getNombre()+" </p>");
		salida.write("<p>idTaqueria= "+taquero.getIdTaqueria()+" </p>");
		salida.write("<p>Experiencia= "+taquero.getExperiencia()+" </p>");
		salida.write("<p>Limpieza= "+taquero.getrLimpieza()+" </p>");
		salida.write("<p>Velocidad= "+taquero.getVelocidad()+" </p>");
		salida.write("<p>Calificacion= "+taquero.getCalificacion()+" </p>");
		salida.write("<p>Frase= "+taquero.getFrase()+" </p>");
		salida.write("<a href='consultarTaquero.html'>Regresar</a>");
		salida.write("</body>");
		salida.write("</head>");
	}
}
