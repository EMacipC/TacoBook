package com.generationc20.redtaqueriaweb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.generationc20.redtaqueriaweb.model.Taqueria;
import com.generationc20.redtaqueriaweb.model.Taquero;

public class DatabaseManager {
	
	private Connection connection;
	public DatabaseManager(Connection conn) {
		this.connection=conn;
	}
	
	public void incertarTaqueria(Taqueria taqueria) {
		
		String queryInsert="insert into taqueria(nombre,popularidad,nivelLimpieza,ubicacion,olor,usuario,contrasena) values(?,?,?,?,?,?,?)";
		
		int result=-1;
		PreparedStatement chalan=null;
		try {
			chalan =connection.prepareStatement(queryInsert);
			chalan.setString(1,taqueria.getNombre());
			chalan.setInt(2, taqueria.getPopularidad());
			chalan.setInt(3, taqueria.getNivelLimpieza());
			chalan.setString(4, taqueria.getUbicacion());
			chalan.setInt(5, taqueria.getOlor());
			chalan.setString(6, taqueria.getUsuario());
			chalan.setString(7, taqueria.getPass());
			
			result=chalan.executeUpdate();
			if(result>0) {
				System.out.println("Se inserto Taqueria");
			}else {
				System.out.println("No Se inserto Taqueria");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(chalan!=null) {
				try {
					chalan.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void insertarTaquero(Taquero taquero) {
		String query="insert into taquero(idTaqueria,nombre,experiencia,nivelLimpieza,velocidad,calificacion,fraseCliente) values(?,?,?,?,?,?,?)";
		
		int result=-1;
		PreparedStatement chalan= null;
		try {
			chalan = connection.prepareStatement(query);
			chalan.setInt(1, taquero.getIdTaqueria());
			chalan.setString(2, taquero.getNombre());
			chalan.setInt(3, taquero.getExperiencia());
			chalan.setInt(4, taquero.getLimpieza());
			chalan.setInt(5, taquero.getVelocidad());
			chalan.setInt(6,taquero.getCalificacion());
			chalan.setString(7,taquero.getFrase());
			
			result=chalan.executeUpdate();
			if(result>0) {
				System.out.println("Se inserto Taqueria");
			}else {
				System.out.println("No Se inserto Taqueria");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(chalan!=null) {
				try {
					chalan.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public List<Taqueria> consultarTaquerias(){
		 String query =" select * from taqueria";
		 Statement chalan= null;
		 ResultSet result=null;
		 List<Taqueria> listaTaquerias= null;
		 try {
			 
			 chalan= connection.createStatement();
			 result = chalan.executeQuery(query);
			 
			 listaTaquerias= new ArrayList<>();
			 while (result.next()) {
				 Taqueria taqueria =new Taqueria();
				 taqueria.setId(result.getInt("id"));
				 taqueria.setNombre(result.getString("nombre"));
				 taqueria.setPopularidad(result.getInt("popularidad"));
				 taqueria.setNivelLimpieza(result.getInt("nivelLimpieza"));
				 taqueria.setUbicacion(result.getString("ubicacion"));
				 taqueria.setOlor(result.getInt("olor"));
				 taqueria.setFechaCreacion(result.getDate("fecahCreacion"));
				 listaTaquerias.add(taqueria);	 
			 }
			
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 if(chalan!=null) {
				 try {
					 result.close();
					 chalan.close();
					 
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
			 }
		 }
		return listaTaquerias;
	}
	public void editarTaquero(Taquero taquero) {
		
		String query ="update taquero set idTaqueria=?,experiencia=?,nivelLimpieza=?,velocidad=?,calificacion=?,fraseCliente=? where nombre=?";
		PreparedStatement chalan= null;
		int result= -1;
		try {
		chalan= connection.prepareStatement(query);
		chalan.setInt(1,taquero.getIdTaqueria());
		chalan.setInt(2, taquero.getExperiencia());
		chalan.setInt(3,taquero.getLimpieza());
		chalan.setInt(4, taquero.getVelocidad());
		chalan.setInt(5, taquero.getCalificacion());
		chalan.setString(6, taquero.getFrase());
		chalan.setString(7, taquero.getNombre());
		result= chalan.executeUpdate();
		if(result>0) {
			System.out.println("Se a Cambiado Correctamente");
		}else {
			System.out.println("Error");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean verificarUsuarioPass(String usu, String pass) {
		 String query ="select usuario from taqueria";
		 String queryC="select contrasena from taqueria";
		 Statement chalan= null;
		 Statement chalanC=null;
		 ResultSet result=null;
		 ResultSet resultC=null;
		 try {
			 chalan= connection.createStatement();
			 result= chalan.executeQuery(query);
			 while(result.next()) {
				 String usuario= result.getString("usuario");
				 if(usuario.equals(usu)) {
					 chalanC=connection.createStatement();
					 resultC=chalanC.executeQuery(queryC);
					 while(resultC.next()) {
						 String cont= resultC.getString("contrasena");
						 if(cont.equals(pass)) {
							 return true;
						 }
					 }
					 
				 }
			 }
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	}
}
