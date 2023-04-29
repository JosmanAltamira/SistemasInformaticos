package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Profesores {

	private int id;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String despacho;
	private String telefono;
	private Boolean es_doctor;
	
	
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
	
	public String getApellido_Paterno() {
		return apellido_paterno;
	}
	public void setApelllido_Paterno(String acronimo) {
		this.apellido_paterno = acronimo;
	}
	
	public String getApellido_Materno() {
		return apellido_materno;
	}
	public void setApellido_Materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	
	public String getDespacho() {
		return despacho;
	}
	public void setDespacho( String despacho) {
		this.despacho = despacho;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Boolean getEs_Doctor() {
		return es_doctor;
	}
	public void setFecha_Inicio(Boolean es_doctor) {
		this.es_doctor = es_doctor;
	}
	
	
	@Override
	public String toString() {
		return "profesores{" + "id" + id +", Nombre:" + nombre +"Apellido_Paterno:"+ apellido_paterno + "Apellido_Materno:"+ apellido_materno + "Despacho:"+ despacho + "Telefono:" + telefono + "Es_Doctor:" + es_doctor + "}";
	}
}
