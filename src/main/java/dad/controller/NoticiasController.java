package dad.controller;

import java.io.IOException;
import java.net.URI;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class NoticiasController implements Initializable {

	int cont = 0;
	int pag = 1;

	static String buscar = "Messi";

	static String urlNoticia1 = "";
	static String urlNoticia2 = "";
	static String urlNoticia3 = "";
	static String urlNoticia4 = "";

	// logic

	NewsApiClient newsApiClient = new NewsApiClient(ResourceBundle.getBundle("token").getString("news.api.token"));

	// NoticiaWebController noticiasWeb;

	// view

	@FXML
	private GridPane RootGridPane;

	@FXML
	private Button anteriorPaginaButton;

	@FXML
	private Label paginaLabel;

	@FXML
	private Button siguientePaginaButton;

	@FXML
	private Text titulo1Text;

	@FXML
	private Text description1Text;

	@FXML
	private Text publicated1Text;

	@FXML
	private Button noticia1Button;

	@FXML
	private ImageView noticia1Image;

	@FXML
	private Text titulo2Text;

	@FXML
	private Text description2Text;

	@FXML
	private Text publicated2Text;

	@FXML
	private Button noticia2Button;

	@FXML
	private ImageView noticia2Image;

	@FXML
	private Text titulo3Text;

	@FXML
	private Text description3Text;

	@FXML
	private Text publicated3Text;

	@FXML
	private Button noticia3Button;

	@FXML
	private ImageView noticia3Image;

	@FXML
	private Text titulo4Text;

	@FXML
	private Text description4Text;

	@FXML
	private Text publicated4Text;

	@FXML
	private Button noticia4Button;

	@FXML
	private ImageView noticia4Image;

	@FXML
	void onBoton(ActionEvent event) {

	}

	@FXML

	void onSiguienteAction(ActionEvent event) {
		if (pag == 4) {
			siguientePaginaButton.setDisable(true);
		} else {
			siguientePaginaButton.setDisable(false);
		}
		if (pag > 0) {
			anteriorPaginaButton.setDisable(false);
		}

		pag++;
		paginaLabel.setText("" + pag);

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			public void onSuccess(ArticleResponse response) {
				cargarDatos(response.getArticles());
			}

			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		newsApiClient.getEverything(new EverythingRequest.Builder().q(buscar).language("es").pageSize(20).page(1)
				.sortBy("publishedAt").build(), callback);
	}

	public NoticiasController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NoticiasView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@FXML
	void onAtrasAction(ActionEvent event) {

		if (pag == 2) {
			anteriorPaginaButton.setDisable(true);
		} else {
			anteriorPaginaButton.setDisable(false);
		}
		if (pag < 6) {
			siguientePaginaButton.setDisable(false);
		}
		pag--;
		paginaLabel.setText("" + pag);
		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			public void onSuccess(ArticleResponse response) {
				atrasDatos(response.getArticles());
			}

			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		newsApiClient.getEverything(new EverythingRequest.Builder().q(buscar).language("es").pageSize(20).page(1)
				.sortBy("publishedAt").build(), callback);

	}

	@FXML
	void onNoticia1Action(ActionEvent event) {

		Runtime rt = Runtime.getRuntime();
		String url = urlNoticia1;
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void onNoticia2Action(ActionEvent event) {
		Runtime rt = Runtime.getRuntime();
		String url = urlNoticia2;
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void onNoticia3Action(ActionEvent event) {
		Runtime rt = Runtime.getRuntime();
		String url = urlNoticia3;
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void onNoticia4Action(ActionEvent event) {
		Runtime rt = Runtime.getRuntime();
		String url = urlNoticia4;
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {
		if (pag == 1) {
			anteriorPaginaButton.setDisable(true);
		} else {
			anteriorPaginaButton.setDisable(false);
		}

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			public void onSuccess(ArticleResponse response) {
				cargarDatos(response.getArticles());
			}

			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		newsApiClient.getEverything(new EverythingRequest.Builder().q("messi").language("es").pageSize(20).page(1)
				.sortBy("publishedAt").build(), callback);

	}

	public void initialize(URL location, ResourceBundle resources, String palabraBuscar) {
		if (pag == 1) {
			anteriorPaginaButton.setDisable(true);
		} else {
			anteriorPaginaButton.setDisable(false);
		}

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			public void onSuccess(ArticleResponse response) {
				cargarDatos(response.getArticles());
			}

			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		newsApiClient.getEverything(new EverythingRequest.Builder().q(palabraBuscar).language("es").pageSize(20).page(1)
				.sortBy("publishedAt").build(), callback);

	}

	public void cargarDatos(List<Article> articles) {
		paginaLabel.setText("" + pag);

		if (pag == 1) {
			cont = 0;
		}
		if (pag == 2) {
			cont = 4;
		}
		if (pag == 3) {
			cont = 8;
		}
		if (pag == 4) {
			cont = 12;
		}
		if (pag == 5) {
			cont = 16;
		}
		titulo1Text.setText(articles.get(cont).getTitle());
		description1Text.setText(articles.get(cont).getDescription());
		publicated1Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia1 = new Image(articles.get(cont).getUrlToImage());
		noticia1Image.setImage(imagenNoticia1);
		urlNoticia1 = articles.get(cont).getUrl();

		cont++;

		titulo2Text.setText(articles.get(cont).getTitle());
		description2Text.setText(articles.get(cont).getDescription());
		publicated2Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia2 = new Image(articles.get(cont).getUrlToImage());
		noticia2Image.setImage(imagenNoticia2);
		urlNoticia2 = articles.get(cont).getUrl();
		cont++;

		titulo3Text.setText(articles.get(cont).getTitle());
		description3Text.setText(articles.get(cont).getDescription());
		publicated3Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia3 = new Image(articles.get(cont).getUrlToImage());
		noticia3Image.setImage(imagenNoticia3);
		urlNoticia3 = articles.get(cont).getUrl();
		cont++;

		titulo4Text.setText(articles.get(cont).getTitle());
		description4Text.setText(articles.get(cont).getDescription());
		publicated4Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia4 = new Image(articles.get(cont).getUrlToImage());
		noticia4Image.setImage(imagenNoticia4);
		urlNoticia4 = articles.get(cont).getUrl();
		cont++;

	}

	private void atrasDatos(List<Article> articles) {

		paginaLabel.setText("" + pag);
		if (pag == 2) {
			cont = 8;
		}
		if (pag == 3) {
			cont = 12;
		}
		if (pag == 4) {
			cont = 16;
		}
		cont--;

		titulo4Text.setText(articles.get(cont).getTitle());
		description4Text.setText(articles.get(cont).getDescription());
		publicated4Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia4 = new Image(articles.get(cont).getUrlToImage());
		noticia4Image.setImage(imagenNoticia4);

		cont--;

		titulo3Text.setText(articles.get(cont).getTitle());
		description3Text.setText(articles.get(cont).getDescription());
		publicated3Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia3 = new Image(articles.get(cont).getUrlToImage());
		noticia3Image.setImage(imagenNoticia3);

		cont--;

		titulo2Text.setText(articles.get(cont).getTitle());
		description2Text.setText(articles.get(cont).getDescription());
		publicated2Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia2 = new Image(articles.get(cont).getUrlToImage());
		noticia2Image.setImage(imagenNoticia2);

		cont--;

		titulo1Text.setText(articles.get(cont).getTitle());
		description1Text.setText(articles.get(cont).getDescription());
		publicated1Text.setText(articles.get(cont).getAuthor() + " " + articles.get(cont).getPublishedAt());
		Image imagenNoticia1 = new Image(articles.get(cont).getUrlToImage());
		noticia1Image.setImage(imagenNoticia1);

	}

	public GridPane getRootGridPane() {
		return RootGridPane;
	}

	public void setRootGridPane(GridPane rootGridPane) {
		RootGridPane = rootGridPane;
	}

	public static String getBuscar() {
		return buscar;
	}

	public static void setBuscar(String buscar) {
		NoticiasController.buscar = buscar;
	}

	public static String getUrlNoticia1() {
		return urlNoticia1;
	}

	public static void setUrlNoticia1(String urlNoticia1) {
		NoticiasController.urlNoticia1 = urlNoticia1;
	}

	public static String getUrlNoticia2() {
		return urlNoticia2;
	}

	public static void setUrlNoticia2(String urlNoticia2) {
		NoticiasController.urlNoticia2 = urlNoticia2;
	}

	public static String getUrlNoticia3() {
		return urlNoticia3;
	}

	public static void setUrlNoticia3(String urlNoticia3) {
		NoticiasController.urlNoticia3 = urlNoticia3;
	}

	public static String getUrlNoticia4() {
		return urlNoticia4;
	}

	public static void setUrlNoticia4(String urlNoticia4) {
		NoticiasController.urlNoticia4 = urlNoticia4;
	}

}
