package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

	OpcionesController opcionesController = new OpcionesController();
	NoticiasController noticiasController = new NoticiasController();

	@FXML
	private BorderPane View;

	@FXML
	private TextField busquedaField;

	@FXML
	private Button buscarButton;

	@FXML
	private Button borrarButton;

	@FXML
	private Tab periodicoTab;

	@FXML
	private Tab tvTab;

	@FXML
	private TabPane noticiasTabPane;

	@FXML
	private BorderPane leftPane;

	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

		leftPane.setTop(opcionesController.getView());
		periodicoTab.setContent(noticiasController.getRootGridPane());

	}

	public BorderPane getView() {
		return View;
	}

	

}
