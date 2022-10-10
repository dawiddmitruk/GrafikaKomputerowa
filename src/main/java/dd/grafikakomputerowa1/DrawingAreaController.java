package dd.grafikakomputerowa1;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import lombok.Setter;


public class DrawingAreaController {
	
	@FXML
	private BorderPane border;
	@FXML
	private Pane drawingArea;
	
	@FXML
	private Group drawing;
	
	@Setter
	private DrawingAreaMode handlers = new DrawingLinesMode(this);
	
	public void onMouseClicked(MouseEvent event) {
		handlers.onMouseClicked(event);
	}
	
	public void onMousePressed(MouseEvent event) {
		handlers.onMousePressed(event);
	}
	
	public void onDragDetected(MouseEvent event) {
		handlers.onDragDetected(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		handlers.onMouseDragged(event);
	}
	
	public void onMouseReleased(MouseEvent event) {
		handlers.onMouseReleased(event);
	}
	
	
	@FXML
	private void initialize() {
		configureClippingForDrawingArea();
		
		configureBackgroundAndBorder();
		onHelloButtonClick();
	}
	
	public void addElement(Node element) {
		drawing.getChildren().add(element);
	}
	
	private void onHelloButtonClick() {
		
		drawing.getChildren()
				.add(new Line(1, 1, 400, 400));
		drawing.getChildren()
				.add(new Line(121, 1, 400, 700));
		drawing.getChildren()
				.add(new Circle(100, 100, 30));
	}
	
	private void configureClippingForDrawingArea() {
		var bounds = new Rectangle();
		
		drawingArea.layoutBoundsProperty()
				.addListener((ignored, ignored1, newValue) -> {
					bounds.setWidth(newValue.getWidth());
					bounds.setHeight(newValue.getHeight());
				});
		
		drawingArea.setClip(bounds);
	}
	
	private void configureBackgroundAndBorder() {
		drawingArea.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		border.setBorder(new Border(new BorderStroke(
				Color.LIGHTGRAY,
				BorderStrokeStyle.SOLID,
				null,
				BorderStroke.MEDIUM)));
	}
	
}
