package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexion.ConexionPostregsql;
import Model.Profesores;


public class ProfesoresDao {

	private ConexionPostregsql conexion;
	
	public ProfesoresDao() {
		this.conexion = new ConexionPostregsql();
	}
	
	public boolean registrarProfesores (Profesores profesores) {
		
		try {
			
			String SQL= "insert into proyecto_investigacion(nombre,acronimo,programa_financiamiento,presupuesto,descripcion,fecha_inicio,fecha_fin)values(?,?,?,?,?,?,?)";
			
			Connection connection = this.conexion.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(SQL);
			sentencia.setString(1, profesores.getNombre());
			sentencia.setString(2, profesores.getApellido_Paterno());
			sentencia.setString(3, profesores.getApellido_Materno());
			sentencia.setString(4, profesores.getDespacho());
			sentencia.setString(5, profesores.getTelefono());

			sentencia.executeUpdate();
			sentencia.close();
			return true;

			
			
			
			
		}catch (Exception e){
			System.err.println("Ocurrio un error al registrar");
			System.err.println("Mensaje de error: "+e.getMessage());
			System.err.println("Detalle del error");
			e.printStackTrace();
			
			return false;
			
		}
		
	}
}
