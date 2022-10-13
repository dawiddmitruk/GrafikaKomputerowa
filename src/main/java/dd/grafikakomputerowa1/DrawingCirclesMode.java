package dd.grafikakomputerowa1;

import javafx.scene.shape.Circle;
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
		return new DrawingStageOne() {
			@Override
			protected Circle setupNewShape(double x, double y) {
				return new Circle(x, y, 0);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new DrawingStageTwo() {
			@Override
			protected void adjustToCursorPosition(Circle shape, double x, double y) {
				shape.setCenterX((originX + x) / 2);
				shape.setCenterY((originY + y) / 2);
				
				shape.setRadius(Math.hypot((x - originX) / 2, (y - originY) / 2));
			}
		};
	}

}
