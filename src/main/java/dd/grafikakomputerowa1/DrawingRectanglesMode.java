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
		return new DrawingStageOne() {
			@Override
			protected Rectangle setupNewShape(double x, double y) {
				return new Rectangle(x, y, 0, 0);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new DrawingStageTwo() {
			@Override
			protected void adjustToCursorPosition(Rectangle shape, double x, double y) {
				if (x >= originX) {
					shape.setX(originX);
					shape.setWidth(x - originX);
				} else {
					shape.setX(x);
					shape.setWidth(originX - x);
				}
				
				if (y >= originY) {
					shape.setY(originY);
					shape.setHeight(y - originY);
				} else {
					shape.setY(y);
					shape.setHeight(originY - y);
				}
			}
		};
	}
	
}
