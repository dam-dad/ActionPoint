package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class IniciarController implements Initializable {
	
	private CrearController crearController = new CrearController();
	private RootController rootController = new RootController();

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

	public IniciarController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/IniciarView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

	}
	
	@FXML
	void onCrearAction(ActionEvent event) {
		view.setCenter(crearController.getView());
	}

	@FXML
	void onIniciarAction(ActionEvent event) {
		view.setCenter(rootController.getView());
	}

	public BorderPane getView() {
		return view;
	}


}
