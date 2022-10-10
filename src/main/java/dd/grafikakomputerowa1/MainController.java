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
	
//		drawingAreaController.setClickActionImpl(event -> {
//			if (event.getClickCount() != 1) {
//				System.out.println("double click");
//				return;
//			}
//
//			var x = event.getX();
//			var y = event.getY();
//
//			var target = event.getTarget();
//			if (target instanceof Pane) {
//				drawingAreaController.addElement(new Circle(x, y, 1));
//				System.out.println("pane click!");
//
//				return;
//			}
//
//
//			System.out.println("not pane");
//		});
	}
	
	@FXML
	protected void drawRectangles(ActionEvent actionEvent) {
	}
	
	@FXML
	protected void drawCircles(ActionEvent actionEvent) {
	}
	
}