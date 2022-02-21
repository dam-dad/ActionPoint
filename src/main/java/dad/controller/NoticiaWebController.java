package dad.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NoticiaWebController implements Initializable{

    @FXML
    private BorderPane noticiaWebBorderPane;

    @FXML
    private WebView noticiaWebView;

   
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
	}
	public NoticiaWebController(String url) {
		 WebEngine webEngine = noticiaWebView.getEngine();
		
		webEngine.load(url);
		
	}

	
	
}
