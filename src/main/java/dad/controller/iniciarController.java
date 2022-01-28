package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class iniciarController implements Initializable {
	crearController crear = new crearController();
	

	Stage primaryStage = new Stage();

	public iniciarController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/iniciarView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
	private BorderPane view;

	@FXML
	private VBox central;

	@FXML
	private ImageView avatarImage;

	@FXML
	private TextField usuarioText;

	@FXML
	private PasswordField contraPassField;

	@FXML
	private Button cesionButton;

	@FXML
	private Button crearButton;

	@FXML
	void onCrearAction(ActionEvent event) {
		view.setCenter(crear.getView());
	}

	@FXML
	void onIniciarAction(ActionEvent event) {

	}

	public BorderPane getView() {
		return view;
	}

	@SuppressWarnings("static-access")
	public void initialize(URL location, ResourceBundle resources) {
		view.setAlignment(view, Pos.CENTER);
	}

}
