package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

	OpcionesController opcionesController = new OpcionesController();
	NoticiasController noticiasController = new NoticiasController();

	NewsApiClient newsApiClient = new NewsApiClient(ResourceBundle.getBundle("token").getString("news.api.token"));
	
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

	@FXML
	void OnBuscarNoticiaAction(ActionEvent event) {

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			public void onSuccess(ArticleResponse response) {
				noticiasController.setBuscar(busquedaField.getText());
				noticiasController.cargarDatos(response.getArticles());
				
			}

			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		newsApiClient.getEverything(new EverythingRequest.Builder().q(busquedaField.getText()).language("es").pageSize(20).page(1)
				.sortBy("publishedAt").build(), callback);

	}

	public BorderPane getView() {
		return View;
	}

}
