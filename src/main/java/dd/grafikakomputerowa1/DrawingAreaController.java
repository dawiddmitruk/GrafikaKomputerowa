package dd.grafikakomputerowa1;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;


public class DrawingAreaController {
	
	private final UnifiedMap<Class<? extends DrawingAreaMode>, DrawingAreaMode> instanceCache =
			UnifiedMap.newWithKeysValues(NoopDrawingAreaMode.class, new NoopDrawingAreaMode(this));
	
	
	@FXML
	private BorderPane border;
	@FXML
	private Pane drawingArea;
	
	@FXML
	private Group drawing;
	
	private DrawingAreaMode handlers;
	
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
	
	
	public void addElement(Node element) {
		drawing.getChildren().add(element);
	}
	
	/**
	 * Changes mode of operation to one of supplied {@link Class}
	 *
	 * @param mode {@link Class} of mode to change to
	 * @throws RuntimeException if supplied class does not define constructor with
	 * signature like {@link DrawingRectanglesMode#DrawingRectanglesMode(DrawingAreaController)
	 * DrawingRectanglesMode(DrawingAreaController)}
	 */
	public void changeModeTo(Class<? extends DrawingAreaMode> mode) {
		if (handlers != null) {
			handlers.endSession();
		}
		
		handlers = instanceCache.getIfAbsentPut(
				mode,
				Functions0.throwing(() -> mode
						.getConstructor(DrawingAreaController.class)
						.newInstance(this)));
		
		handlers.startSession();
	}
	
	public void clear() {
		drawing.getChildren().clear();
	}
	
	@FXML
	private void initialize() {
		changeModeTo(NoopDrawingAreaMode.class);
		
		configureClippingForDrawingArea();
		
		configureBackgroundAndBorder();
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
