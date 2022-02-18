package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class OpcionesController implements Initializable {

	@FXML
	private VBox view;

	@FXML
	private ImageView avatarImages;

	@FXML
	private JFXToggleButton temaToggle;

	@FXML
	private ComboBox<?> filtrosCombo;

	@FXML
	private Button historialButton;

	@FXML
	private Button avatarButton;

	@FXML
	private Button cerrarCesionButton;

	public OpcionesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OpcionesView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
//		view.getStylesheets().add(getClass().getResource("/css/clasico.css").toExternalForm());

	}

	@FXML
	void onCambiarAction(ActionEvent event) {

	}

	@FXML
	void onCerrarAction(ActionEvent event) {

	}

	@FXML
	void onHistorialAction(ActionEvent event) {

	}

	public VBox getView() {
		return view;
	}

}
