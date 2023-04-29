package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.time.LocalDate;

import DAO.Proyecto_investigacionDao;
import Model.Proyecto_investigacion;

public class Page1Controller {
	@FXML
	private TextField txtNombre;
	@FXML
	private Button btbEnviarProyecto_Investigacion;
	@FXML
	private TextField txtAcronimo;
	@FXML
	private TextField txtPrograma_Financiamiento;
	@FXML
	private TextField txtPresupuesto;
	@FXML
	private DatePicker txtFecha_Inicio;
	@FXML
	private DatePicker txtFecha_Fin;
	@FXML
	private TextField txtDescripcion;

	// Event Listener on Button[#btbEnviarProyecto_Investigacion].onAction
	@FXML
	private Proyecto_investigacionDao	proyecto_investigacionDao;
	@FXML
    void initialize() {
        this.proyecto_investigacionDao=new Proyecto_investigacionDao();
    }

	// Event Listener on Button[#btbEnviarProyecto_Investigacion].onAction
	@FXML
	public void btnGuardarProyecto_InvestigacionOnAction(ActionEvent event) {

		String nombre = txtNombre.getText();
		String acronimo = txtAcronimo.getText();
		String programa_financiamiento = txtPrograma_Financiamiento.getText();
		String presupuesto = txtPresupuesto.getText();
		String descripcion = txtDescripcion.getText();
		LocalDate fecha_inicio = txtFecha_Inicio.getValue();
		LocalDate fecha_fin = txtFecha_Fin.getValue();
		

		if (nombre.isEmpty() || acronimo.isEmpty() || fecha_inicio == null || fecha_fin == null || programa_financiamiento.isEmpty()|| presupuesto.isEmpty() || descripcion.isEmpty() ) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error en los datos");
			alert.setHeaderText(null);
			alert.setContentText("Por favor, completa todos los campos");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
		String pattern = "^[a-zA-Z\\\\s]+$";
		if (!nombre.matches(pattern) || !acronimo.matches(pattern) || !descripcion.matches(pattern) || !programa_financiamiento.matches(pattern)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error en los datos");
			alert.setHeaderText(null);
			alert.setContentText("No se pueden contener caracteres especiales");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			return;
		}
		
	    try {
	        Integer.parseInt(txtPresupuesto.getText());
	    } catch (NumberFormatException e) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Formato invalido");
	        alert.setContentText("El presupuesto debe ser un número");
	        alert.showAndWait();
	        return;
	    }
		
		
	    Proyecto_investigacion proyecto_investigacion = new Proyecto_investigacion();
		proyecto_investigacion.setNombre(nombre);
		proyecto_investigacion.setAcronimo(acronimo);
		proyecto_investigacion.setPrograma_Financiamiento(programa_financiamiento);
		proyecto_investigacion.setPresupuesto(presupuesto);
		proyecto_investigacion.setDescripcion(descripcion);
		proyecto_investigacion.setFecha_Inicio(Date.valueOf(fecha_inicio));
		proyecto_investigacion.setFecha_Fin(Date.valueOf(fecha_fin));
		

		boolean rsp = this.proyecto_investigacionDao.registrarProyecto_Investigacion(proyecto_investigacion);
		
		if(rsp) {
			Alert alert = new Alert (Alert.AlertType.INFORMATION);
			alert.setTitle("Operacion correcta");
			alert.setHeaderText(null);
			alert.setContentText("Registrado correctamente :)");
			alert.initStyle(StageStyle.UTILITY);
			alert.showAndWait();
			
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Operacion incorrecta");
			 alert.setHeaderText(null);
			 alert.setContentText("Revise la informacion");
			 alert.initStyle(StageStyle.UTILITY);
			 alert.showAndWait();
		}
	}
}
