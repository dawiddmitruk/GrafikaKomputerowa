package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
public abstract class AbstractDrawingAreaMode implements DrawingAreaMode {
	
	protected final DrawingAreaController controller;
	@Setter(AccessLevel.PROTECTED)
	private DrawingAreaMode stage;
	
	@Override
	public void onMouseClicked(MouseEvent event) {
		stage.onMouseClicked(event);
	}
	
	@Override
	public void onMousePressed(MouseEvent event) {
		stage.onMousePressed(event);
	}
	
	@Override
	public void onDragDetected(MouseEvent event) {
		stage.onDragDetected(event);
	}
	
	@Override
	public void onMouseDragged(MouseEvent event) {
		stage.onMouseDragged(event);
	}
	
	@Override
	public void onMouseReleased(MouseEvent event) {
		stage.onMouseReleased(event);
	}
	
	protected abstract static class DrawingStage implements DrawingAreaMode {
		
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
	
}
