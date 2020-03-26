package com.generationc20.redtaqueriaweb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.generationc20.redtaqueriaweb.model.Taquero;



public class DatabaseConsultar {
	 private Connection connection;
	 public DatabaseConsultar(Connection conn) {
		 this.connection=conn;
	 }
	 public Taquero consultarTaquero(String nombre) {
		 
		 String query="select*from taquero where nombre=?";
		 Taquero taquero=null;
		 PreparedStatement chalan=null;
		 ResultSet result=null;
		 try {
			 
		 chalan= connection.prepareStatement(query);
		 chalan.setString(1,nombre);
		 
		 
		 result = chalan.executeQuery();
		  if( result.first()) {
			  taquero=new Taquero();
			  taquero.setId(result.getInt("id"));
			  taquero.setIdTaqueria(result.getInt("idTaqueria"));
			  taquero.setNombre(result.getString("nombre"));
			  taquero.setExperiencia(result.getInt("experiencia"));
			  taquero.setrLimpieza(result.getString("nivelLimpieza"));
			  taquero.setVelocidad(result.getInt("velocidad"));
			  taquero.setCalificacion(result.getInt("calificacion"));
			  taquero.setFrase(result.getString("fraseCliente"));
			  
			  result.close();
			  chalan.close();
			
		  }
		 
		 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		
		 return taquero;
	 }

}
