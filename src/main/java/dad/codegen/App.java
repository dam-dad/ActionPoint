package dad.codegen;

import dad.controller.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{
private RootController root;
public void start(Stage primaryStage) throws Exception {
		root=new RootController();
		Scene scene=new Scene(root.getView());
		primaryStage.setTitle("2");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
