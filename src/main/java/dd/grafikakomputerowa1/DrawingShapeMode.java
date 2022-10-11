package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import lombok.Setter;

import java.util.function.Consumer;


public abstract class DrawingShapeMode<T extends Shape> extends MultistageDrawingAreaMode {
	
	private final StageOne stageOne = stageOne();
	private final StageTwo stageTwo = stageTwo();
	
	@Setter
	protected Consumer<T> configurer;
	protected T currentlyDrawn;
	
	protected DrawingShapeMode(DrawingAreaController controller, Consumer<T> configurer) {
		super(controller);
		
		this.configurer = configurer;
		
		setStage(stageOne);
	}
	
	protected abstract StageOne stageOne();
	
	protected abstract StageTwo stageTwo();
	
	protected abstract class StageOne extends StageOfDrawing {
		
		@Override
		public final void onMousePressed(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			var newShape = (T) null;
			
			newShape = setupNewShape(x, y);
			
			configurer.accept(newShape);
			
			controller.addElement(newShape);
			
			currentlyDrawn = newShape;
			
			setStage(stageTwo);
		}
		
		protected abstract T setupNewShape(double x, double y);
		
	}
	
	protected abstract class StageTwo extends StageOfDrawing {
		
		@Override
		public final void onMouseReleased(MouseEvent event) {
			setStage(stageOne);
		}
		int i;
		@Override
		public final void onMouseDragged(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			
			adjustToCursorPosition(currentlyDrawn, x, y);
		}
		
		protected abstract void adjustToCursorPosition(T shape, double x, double y);
		
	}
	
}
