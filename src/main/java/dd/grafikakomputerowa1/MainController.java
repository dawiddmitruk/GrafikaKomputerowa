package dd.grafikakomputerowa1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.shape.*;


public class MainController {
	
	public HBox top;
	
	public BorderPane drawingArea;
	
	public DrawingAreaController drawingAreaController;
	
	
	@FXML
	protected void drawLines(ActionEvent actionEvent) {
		drawingAreaController.changeModeTo(DrawingLinesMode.class);
	}
	
	@FXML
	protected void drawRectangles(ActionEvent actionEvent) {
		drawingAreaController.changeModeTo(DrawingRectanglesMode.class);
	}
	
	@FXML
	protected void drawCircles(ActionEvent actionEvent) {
		drawingAreaController.changeModeTo(DrawingCirclesMode.class);
	}
	
	@FXML
	protected void moveObjects(ActionEvent actionEvent) {
		drawingAreaController.changeModeTo(MovingShapesMode.class);
	}
	
}