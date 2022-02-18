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

public class CrearController implements Initializable {

	@FXML
	private BorderPane view;

	@FXML
	private VBox center;

	@FXML
	private ImageView avatarImage;

	@FXML
	private TextField usuarioText;

	@FXML
	private PasswordField contraPassField;

	@FXML
	private PasswordField confirmarContraPassField;

	@FXML
	private Button crearButton;

	public CrearController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CrearView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void onCrearAction(ActionEvent event) throws IOException {
		IniciarController inicio = new IniciarController();
		view.setCenter(inicio.getView());
	}

	public BorderPane getView() {
		return view;
	}

}