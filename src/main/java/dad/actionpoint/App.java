package dad.actionpoint;

import dad.controller.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private RootController rootController;

	public void start(Stage primaryStage) throws Exception {
		
		rootController = new RootController();
		
		Scene scene = new Scene(rootController.getView());
		
		primaryStage.setTitle("ActionPoint");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}