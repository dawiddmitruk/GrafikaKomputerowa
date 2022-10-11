package dd.grafikakomputerowa1;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import org.eclipse.collections.impl.block.factory.Procedures;

import java.util.function.Consumer;


public class DrawingCirclesMode extends DrawingShapesMode<Circle> {
	
	
	public DrawingCirclesMode(DrawingAreaController controller) {
		this(controller, Procedures.noop());
	}
	
	public DrawingCirclesMode(DrawingAreaController controller, Consumer<Circle> configurer) {
		super(controller, configurer);
	}
	
	@Override
	protected StageOne stageOne() {
		return new StageOne() {
			@Override
			protected Circle setupNewShape(double x, double y) {
				return new DrawnCircle(x, y);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new StageTwo() {
			@Override
			protected void adjustToCursorPosition(Circle shape, double x, double y) {
				if (shape instanceof DrawnCircle c) {
					c.adjustToCursorPosition(x, y);
				}
			}
		};
	}
	
	private static class DrawnCircle extends Circle {
		
		
		private final double originalX;
		private final double originalY;
		
		
		private DrawnCircle(double x, double y) {
			super(x, y, 0);
			
			originalX = x;
			originalY = y;
		}
		
		private void adjustToCursorPosition(double x, double y) {
			setCenterX((originalX + x) / 2);
			setCenterY((originalY + y) / 2);
			
			setRadius(Math.hypot((x - originalX) / 2, (y - originalY) / 2));
		}
		
	}
	
}
