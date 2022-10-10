package dd.grafikakomputerowa1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		var fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		var root = fxmlLoader.<Pane>load();
		
		root.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
		
		var scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		
		stage.setTitle("DrawingApp");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}