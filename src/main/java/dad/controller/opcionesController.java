package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class opcionesController implements Initializable {

		public opcionesController() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/opcionesView.fxml"));
			loader.setController(this);
			loader.load();
		}

		@FXML
		private VBox view;

		   @FXML
		    private ImageView avatarImages;

		@FXML
		private Slider temaOscuroSlider;

		@FXML
		private ComboBox<?> filtrosCombo;

		@FXML
		private Button historialButton;

		@FXML
		private Button avatarButton;

		@FXML
		private Button cerrarCesionButton;

		public VBox getView() {
			return view;
		}

		public void initialize(URL location, ResourceBundle resources) {
//			view.getStylesheets().add(getClass().getResource("/css/clasico.css").toExternalForm());

		}
}
