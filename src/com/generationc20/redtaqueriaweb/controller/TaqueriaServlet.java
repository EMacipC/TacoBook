package com.generationc20.redtaqueriaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generationc20.redtaqueriaweb.db.DatabaseConection;
import com.generationc20.redtaqueriaweb.db.DatabaseManager;
import com.generationc20.redtaqueriaweb.model.Taqueria;

@WebServlet(name="TaqueriaServlet",urlPatterns="/taqueria")
public class TaqueriaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection puente=null;
		DatabaseManager dBManager=null;
		List<Taqueria> listaTaqueria= null;
		
		//delegacion de vistas(jsp)o Servlet
		RequestDispatcher dispatcher= null;
		
		puente=DatabaseConection.getConnection();
		dBManager= new DatabaseManager(puente);
		listaTaqueria= dBManager.consultarTaquerias();
		DatabaseConection.colseConnection(puente);
		
		dispatcher =req.getRequestDispatcher("listataqueria.jsp");
		req.setAttribute("listaTaqueria", listaTaqueria);
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Taqueria taqueria=null;
		Connection puenteConn=null;
		DatabaseManager chalanDB=null;
		
		//Optencion de datos
		String nombre= req.getParameter("txtNombre");
		int popularidad= Integer.parseInt(req.getParameter("txtPopularidad"));
		int Limpieza= Integer.parseInt(req.getParameter("txtLimpieza"));
		String ubicacion= req.getParameter("txtUbicacion");
		int olor= Integer.parseInt(req.getParameter("txtOlor"));
		
		//Moldear Datos
		taqueria = new Taqueria();
		
		taqueria.setNombre(nombre);
		taqueria.setPopularidad(popularidad);
		taqueria.setNivelLimpieza(Limpieza);
		taqueria.setUbicacion(ubicacion);
		taqueria.setOlor(olor);
		
		//Procesar Datos(Agregarlo a base de datos)
		 puenteConn= DatabaseConection.getConnection();
		 chalanDB=new DatabaseManager(puenteConn);
		 chalanDB.incertarTaqueria(taqueria);
		 DatabaseConection.colseConnection(puenteConn);
		 
		 resp.setContentType("text/html");
		 resp.setStatus(HttpServletResponse.SC_CREATED);
		 
		 PrintWriter salida=resp.getWriter();
		 
		 salida.write("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<title>Saludame</title>"
					+ "</head>"
					+ "<body>"
					+ "<h2>Se Creo Con Exito</h2>"
					+ "</body>"
					+ "</html>");
		
	}

}
