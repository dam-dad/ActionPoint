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
/**
 * Controller para el menu lateral de opciones
 * @author Juan2
 *
 */
public class OpcionesController implements Initializable {

	@FXML
	private VBox view;

	@FXML
	private JFXToggleButton temaToggle;

	@FXML
	private ImageView avatarImages;

	@FXML
	private Button cerrarCesionButton;

	Stage stage;

	String css = this.getClass().getResource("/css/moderno.css").toString();

	/**
	 * Constructor que carga la interfaz
	 * @throws IOException
	 */
	public OpcionesController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OpcionesView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

		temaToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (temaToggle.isSelected() == true) {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets().add(css);
				} else {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets().remove((css));
				}

			}
		});

	}

	@FXML
	void onCerrarAction(ActionEvent event) {

		salidaSesion();

	}

	public VBox getView() {
		return view;
	}
	/**
	 * Metodo que te solicita confirmacion para cerrar la aplicacion
	 */
	private void salidaSesion() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Cerrar aplicacion");
		alert.setHeaderText("Vas a cerrar la aplicacion");
		

		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) view.getScene().getWindow();
			stage.close();
		}
	}

}
