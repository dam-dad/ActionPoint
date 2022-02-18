package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class NoticiasController implements Initializable {

	@FXML
	private GridPane RootGridPane;

	@FXML
	private ImageView imagen1ImageView;

	@FXML
	private TextArea primerTextArea;

	public NoticiasController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NoticiasView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		primerTextArea.setText(dad.actionpoint.newsapi.Main.getTitulo());
		System.out.println(dad.actionpoint.newsapi.Main.getTitulo());
	}

	public GridPane getRootGridPane() {
		return RootGridPane;
	}

	public void setRootGridPane(GridPane rootGridPane) {
		RootGridPane = rootGridPane;
	}

	public ImageView getImagen1ImageView() {
		return imagen1ImageView;
	}

	public void setImagen1ImageView(ImageView imagen1ImageView) {
		this.imagen1ImageView = imagen1ImageView;
	}

	public TextArea getPrimerTextArea() {
		return primerTextArea;
	}

	public void setPrimerTextArea(TextArea primerTextArea) {
		this.primerTextArea = primerTextArea;
	}

}
