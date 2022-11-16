package dd.grafikakomputerowa1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class MainController {
	
	@FXML
	private HBox top;
	@FXML
	private BorderPane drawingArea;
	
	@FXML
	private DrawingAreaController drawingAreaController;
	
	public void clear(ActionEvent event) {
		drawingAreaController.clear();
	}
	
	@FXML
	protected void drawCurve(ActionEvent event) {
		drawingAreaController.changeModeTo(DrawingCurvesMode.class);
	}
	
	
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