package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;


public class NoopDrawingAreaMode extends BasicDrawingAreaMode {
	
	public NoopDrawingAreaMode(DrawingAreaController controller) {
		super(controller);
	}
	
	
	@Override
	public void onMouseClicked(MouseEvent event) {}
	
	@Override
	public void onMousePressed(MouseEvent event) {}
	
	@Override
	public void onDragDetected(MouseEvent event) {}
	
	@Override
	public void onMouseDragged(MouseEvent event) {}
	
	@Override
	public void onMouseReleased(MouseEvent event) {}
	
}
