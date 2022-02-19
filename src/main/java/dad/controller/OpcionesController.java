package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		temaToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (temaToggle.isSelected() == true) {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets()
							.add(getClass().getResource("/css/moderno.css").toString());
				} else {
					view.getStylesheets().clear();
					temaToggle.getScene().getRoot().getStylesheets()
							.remove((getClass().getResource("/css/moderno.css").toString()));
				}

			}
		});
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
