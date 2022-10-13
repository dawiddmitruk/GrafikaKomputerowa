package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import lombok.Setter;

import java.util.function.Consumer;


public abstract class DrawingShapesMode<T extends Shape> extends BasicPressDragReleaseMode {
	
	@Setter
	protected Consumer<T> configurer;
	protected T currentlyDrawn;
	
	protected DrawingShapesMode(DrawingAreaController controller, Consumer<T> configurer) {
		super(controller);
		
		this.configurer = configurer;
	}
	
	protected abstract class DrawingStageOne extends StageOne {
		
		@Override
		protected final boolean onPressDragReleaseStarted(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			var newShape = (T) null;
			
			newShape = setupNewShape(x, y);
			
			configurer.accept(newShape);
			
			controller.addElement(newShape);
			
			currentlyDrawn = newShape;
			
			return true;
		}
		
		protected abstract T setupNewShape(double x, double y);
	}
	
	protected abstract class DrawingStageTwo extends StageTwo {
		
		@Override
		protected void onPressDragReleaseEnded(MouseEvent event) {
			currentlyDrawn = null;
		}
		
		@Override
		public final void onMousePositionChanged(MouseEvent event) {
			var x = event.getX();
			var y = event.getY();
			
			adjustToCursorPosition(currentlyDrawn, x, y);
		}
		
		protected abstract void adjustToCursorPosition(T shape, double x, double y);
		
	}
	
}
