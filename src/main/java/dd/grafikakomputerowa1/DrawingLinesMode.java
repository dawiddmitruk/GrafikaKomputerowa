package dd.grafikakomputerowa1;

import javafx.scene.shape.Line;
import org.eclipse.collections.impl.block.factory.Procedures;

import java.util.function.Consumer;


public class DrawingLinesMode extends DrawingShapesMode<Line> {
	
	public DrawingLinesMode(DrawingAreaController controller) {
		this(controller, Procedures.noop());
	}
	
	public DrawingLinesMode(DrawingAreaController controller, Consumer<Line> configurer) {
		super(controller, configurer);
	}
	
	@Override
	protected StageOne stageOne() {
		return new StageOne() {
			@Override
			protected Line setupNewShape(double x, double y) {
				return new Line(x, y, x, y);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new StageTwo() {
			@Override
			protected void adjustToCursorPosition(Line shape, double x, double y) {
				shape.setEndX(x);
				shape.setEndY(y);
			}
		};
	}
	
}
