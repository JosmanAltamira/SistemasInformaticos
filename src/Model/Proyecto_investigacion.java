package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Proyecto_investigacion {

	private int id;
	private String nombre;
	private String acronimo;
	private String programa_financiamiento;
	private String presupuesto;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_fin;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	public String getPrograma_Financiamiento() {
		return programa_financiamiento;
	}
	public void setPrograma_Financiamiento(String programa_financiamiento) {
		this.programa_financiamiento = programa_financiamiento;
	}
	
	public String getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto( String presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFecha_Inicio() {
		return fecha_inicio;
	}
	public void setFecha_Inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
	public Date getFecha_Fin(){
		return fecha_fin;
	}
	public void setFecha_Fin (Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	
	@Override
	public String toString() {
		return "proyecto_investigacion{" + "id" + id +", Nombre:" + nombre +"Acronimo:"+ acronimo + "Programa_Financiamiento:"+ programa_financiamiento + "Presupuesto:"+ presupuesto + "Descripcion:" + descripcion + "Fecha_Inicio:" + fecha_inicio + "Fecha_Fin:" + fecha_fin + "}";
	}
}
