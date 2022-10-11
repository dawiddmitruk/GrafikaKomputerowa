package dd.grafikakomputerowa1;

import javafx.scene.shape.Rectangle;
import org.eclipse.collections.impl.block.factory.Procedures;

import java.util.function.Consumer;


public class DrawingRectanglesMode extends DrawingShapesMode<Rectangle> {
	
	public DrawingRectanglesMode(DrawingAreaController controller) {
		this(controller, Procedures.noop());
	}
	
	public DrawingRectanglesMode(DrawingAreaController controller, Consumer<Rectangle> configurer) {
		super(controller, configurer);
	}
	
	@Override
	protected StageOne stageOne() {
		return new StageOne() {
			@Override
			protected Rectangle setupNewShape(double x, double y) {
				return new DrawnRectangle(x, y);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new StageTwo() {
			@Override
			protected void adjustToCursorPosition(Rectangle shape, double x, double y) {
				if (shape instanceof DrawnRectangle r) {
					r.adjustToCursorPosition(x, y);
				}
			}
		};
	}
	
	private static class DrawnRectangle extends Rectangle {
		
		private final double originalX;
		private final double originalY;
		
		
		private DrawnRectangle(double x, double y) {
			super(x, y, 0, 0);
			
			originalX = x;
			originalY = y;
		}
		
		
		private void adjustToCursorPosition(double x, double y) {
			if (x >= originalX) {
				setX(originalX);
				setWidth(x - originalX);
			} else {
				setX(x);
				setWidth(originalX - x);
			}
			
			if (y >= originalY) {
				setY(originalY);
				setHeight(y - originalY);
			} else {
				setY(y);
				setHeight(originalY - y);
			}
			
		}
		
	}
	
}
