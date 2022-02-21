package dad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NoticiasController implements Initializable {

	// logic
	
	NewsApiClient newsApiClient = new NewsApiClient(ResourceBundle.getBundle("token").getString("news.api.token"));
	
	// view

	@FXML
	private GridPane RootGridPane;

	@FXML
	private Button boton;

	@FXML
	private ImageView imagen;

	@FXML
	private ImageView imagen1;
	@FXML
	private ImageView imagen11;

	@FXML
	private Text tituloText;

	@FXML
	private Text descriptionText;

	@FXML
	private Text publicatedText;

	@FXML
	private Text tituloText1;

	@FXML
	private Text descriptionText1;

	@FXML
	private Text publicatedText1;
	@FXML
	private Text tituloText11;

	@FXML
	private Text descriptionText11;

	@FXML
	private Text publicatedText11;
	

	@FXML
	void onBoton(ActionEvent event) {

	}

	public NoticiasController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NoticiasView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		

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
		
		tituloText.setText(articles.get(0).getTitle());
		descriptionText.setText(articles.get(0).getDescription());
		publicatedText.setText(articles.get(0).getAuthor() + " " + articles.get(0).getPublishedAt());
		Image image = new Image(articles.get(0).getUrlToImage());
		imagen.setImage(image);

		tituloText1.setText(articles.get(1).getTitle());
		descriptionText1.setText(articles.get(1).getDescription());
		publicatedText1.setText(articles.get(1).getAuthor() + " " + articles.get(1).getPublishedAt());
		Image image1 = new Image(articles.get(1).getUrlToImage());
		imagen1.setImage(image1);

		tituloText11.setText(articles.get(2).getTitle());
		descriptionText11.setText(articles.get(2).getDescription());
		publicatedText11.setText(articles.get(2).getAuthor() + " " + articles.get(2).getPublishedAt());
		Image image11 = new Image(articles.get(2).getUrlToImage());
		imagen11.setImage(image11);
		
	}

	public GridPane getRootGridPane() {
		return RootGridPane;
	}

	public void setRootGridPane(GridPane rootGridPane) {
		RootGridPane = rootGridPane;
	}

	

}
