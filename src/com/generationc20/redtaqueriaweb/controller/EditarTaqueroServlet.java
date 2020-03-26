package com.generationc20.redtaqueriaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generationc20.redtaqueriaweb.db.DatabaseConection;
import com.generationc20.redtaqueriaweb.db.DatabaseManager;
import com.generationc20.redtaqueriaweb.model.Taquero;

@WebServlet(name="EditarTaqueroServlet",urlPatterns = "/cambiar")
public class EditarTaqueroServlet extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Taquero taquero=null;
		Connection puente=null;
		DatabaseManager chalan=null;
		
		
		String nombre= req.getParameter("txtNombre");
		int experiencia= Integer.parseInt(req.getParameter("txtExperiencia"));
		int limpieza =Integer.parseInt( req.getParameter("txtLimpieza"));
		int velocidad = Integer.parseInt(req.getParameter("txtVelocidad"));
		int calificacion= Integer.parseInt(req.getParameter("txtCalificacion"));
		String frase = req.getParameter("txtFrase");
		int idTaqueria= Integer.parseInt(req.getParameter("txtTaqueria"));
		
		taquero=new Taquero();
		taquero.setNombre(nombre);
		taquero.setExperiencia(experiencia);
		taquero.setLimpieza(limpieza);
		taquero.setVelocidad(velocidad);
		taquero.setCalificacion(calificacion);
		taquero.setFrase(frase);
		taquero.setIdTaqueria(idTaqueria);
		
		puente= DatabaseConection.getConnection();
		chalan= new DatabaseManager(puente);
		chalan.editarTaquero(taquero);
		DatabaseConection.colseConnection(puente);
		
		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_CREATED);
		
		PrintWriter salida= resp.getWriter();
		salida.write("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Saludame</title>"
				+ "</head>"
				+ "<body>"
				+ "<h2>Se edito correctamente</h2>"
				+ "</body>"
				+ "</html>");
		
		
	}
	

}
