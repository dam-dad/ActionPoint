package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class NoticiasController implements Initializable {

	// logic
	
	NewsApiClient newsApiClient = new NewsApiClient(ResourceBundle.getBundle("token").getString("news.api.token"));
	
	// view

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
		

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			@Override
			public void  onSuccess(ArticleResponse response) {
				cargarDatos(response.getArticles());
			}

			@Override
			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};
		newsApiClient.getEverything(new EverythingRequest.Builder().q("reforma laboral").language("es").pageSize(5).page(1).sortBy("publishedAt").build(), callback);
		
	}

	
	private  void cargarDatos(List<Article> articles) {
		
		primerTextArea.setText(articles.get(0).getDescription());
		
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
