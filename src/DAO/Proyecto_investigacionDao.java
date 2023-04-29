package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Conexion.ConexionPostregsql;
import Model.Proyecto_investigacion;


public class Proyecto_investigacionDao {

	private ConexionPostregsql conexion;
	
	public Proyecto_investigacionDao() {
		this.conexion = new ConexionPostregsql();
	}
	
	public boolean registrarProyecto_Investigacion (Proyecto_investigacion proyecto_investigacion) {
		
		try {
			
			String SQL= "insert into proyecto_investigacion(nombre,acronimo,programa_financiamiento,presupuesto,descripcion,fecha_inicio,fecha_fin)values(?,?,?,?,?,?,?)";
			
			Connection connection = this.conexion.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(SQL);
			sentencia.setString(1, proyecto_investigacion.getNombre());
			sentencia.setString(2, proyecto_investigacion.getAcronimo());
			sentencia.setString(3, proyecto_investigacion.getPrograma_Financiamiento());
			sentencia.setString(4, proyecto_investigacion.getPresupuesto());
			sentencia.setString(5, proyecto_investigacion.getDescripcion());
			sentencia.setDate(6 ,proyecto_investigacion.getFecha_Inicio());
			sentencia.setDate(7 ,proyecto_investigacion.getFecha_Fin());
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
