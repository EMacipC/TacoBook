package com.generationc20.redtaqueriaweb.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generationc20.redtaqueriaweb.db.DatabaseManager;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pass= req.getParameter("txtContrasena");
		String usuario= req.getParameter("txtUsuario");
		Connection puente=null;
		DatabaseManager chalan=null;
		
	}

}
