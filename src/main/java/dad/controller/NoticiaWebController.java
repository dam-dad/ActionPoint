package dad.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NoticiaWebController implements Initializable{

	private StringProperty url = new SimpleStringProperty();

	public NoticiaWebController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WebNoticiasView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@FXML
	private AnchorPane view;

	@FXML
	private WebView webView;

	@FXML
	private Button loadButton;

	@FXML
	private TextField textField;

	private WebEngine engine;

	@FXML
	void onLoad(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		engine = webView.getEngine();
		url.addListener((o, ov, nv) -> {
			loadPage(nv);
		});

	}

	public void loadPage(String url) {
		
		textField.setText(url);
		engine.load(url);
	}

	public AnchorPane getView() {
		return view;
	}

	public final StringProperty urlProperty() {
		return this.url;
	}

	public final String getUrl() {
		return this.urlProperty().get();
	}

	public final void setUrl(final String url) {
		this.urlProperty().set(url);
	}
}
