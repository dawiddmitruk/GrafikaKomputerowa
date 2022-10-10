package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

import java.util.function.Supplier;


public class DrawingLinesMode extends AbstractDrawingAreaMode {
	
	private final StageOne stageOne = new StageOne();
	private final StageTwo stageTwo = new StageTwo();
	
	private final Supplier<Line> factory;
	
	private Line currentlyDrawn;
	
	
	public DrawingLinesMode(DrawingAreaController controller) {
		this(controller, Line::new);
	}
	
	public DrawingLinesMode(DrawingAreaController controller, Supplier<Line> lineFactory) {
		super(controller);
		
		factory = lineFactory;
	}
	
	
	private class StageOne extends DrawingStage {
		
		@Override
		public void onMousePressed(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			var newLine = factory.get();
			
			newLine.setStartX(x);
			newLine.setStartY(y);
			
			newLine.setEndX(x);
			newLine.setEndY(y);
			
			controller.addElement(newLine);
			
			currentlyDrawn = newLine;
			
			setStage(stageTwo);
		}
		
	}
	
	private class StageTwo extends DrawingStage {
		
		@Override
		public void onMouseReleased(MouseEvent event) {
			setStage(stageOne);
		}
		
		@Override
		public void onMouseDragged(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			
			currentlyDrawn.setEndX(x);
			currentlyDrawn.setEndY(y);
		}
		
	}
	
	
	
}
