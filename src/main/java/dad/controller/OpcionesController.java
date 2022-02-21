package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class OpcionesController implements Initializable {

	@FXML
	private VBox view;

	@FXML
	private ImageView avatarImages;

	@FXML
	private JFXToggleButton temaToggle;

	@FXML
	private ComboBox<String> filtrosCombo;
	
	ObservableList<String> items = FXCollections.observableArrayList("Deporte", "Moda", "Motor", "Politica", "Covid", "Inmigracion", "eSports");	

	@FXML
	private Button historialButton;

	@FXML
	private Button avatarButton;

	@FXML
	private Button cerrarCesionButton;
	
	Stage stage;
	
	String css=this.getClass().getResource("/css/moderno.css").toString();

	public OpcionesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OpcionesView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		
		
		 filtrosCombo.setItems(items);
		
			
		temaToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (temaToggle.isSelected() == true) {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets()
							.add(css);
				} else {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets()
							.remove((css));
				}

			}
		});
		
		
	}

	@FXML
	void onCambiarAction(ActionEvent event) {

	}

	@FXML
	void onCerrarAction(ActionEvent event) {

		salidaSesion();
		
	}
	

	@FXML
	void onHistorialAction(ActionEvent event) {

	}

	public VBox getView() {
		return view;
	}

	
	private void salidaSesion() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cerrar Sesion");
		alert.setHeaderText("Vas a cerrar sesion");
		alert.setContentText("¿Quieres guardar antes de salir?");
		
			if(alert.showAndWait().get()== ButtonType.OK) {
				stage = (Stage) view.getScene().getWindow();
				stage.close();
			}
	}
	
}
