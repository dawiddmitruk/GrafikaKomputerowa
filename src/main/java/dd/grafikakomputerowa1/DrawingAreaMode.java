package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;


public interface DrawingAreaMode {
	
	void onMouseClicked(MouseEvent event);
	
	void onMousePressed(MouseEvent event);
	
	void onDragDetected(MouseEvent event);
	
	void onMouseDragged(MouseEvent event);
	
	void onMouseReleased(MouseEvent event);
	
	
}
