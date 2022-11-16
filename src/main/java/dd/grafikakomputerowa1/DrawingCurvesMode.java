package dd.grafikakomputerowa1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;

import java.util.function.ToDoubleFunction;

import static org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples.pair;


public class DrawingCurvesMode extends DrawingShapesMode<Circle> {
	
	public DrawingCurvesMode(DrawingAreaController controller) {
		super(controller, circle -> {});
	}
	
	@Override
	protected StageOne stageOne() {
		return new DrawingStageOne() {
			@Override
			protected Circle setupNewShape(double x, double y) {
				return new Circle(x, y, 3);
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new DrawingStageTwo() {
			
			@Override
			protected void adjustToCursorPosition(Circle shape, double x, double y) {
				shape.setCenterX(x);
				shape.setCenterY(y);
			}
		};
	}
	
	@Override
	public void startSession() {
		var curve = new Polyline() {
			
			private final ObservableList<Circle> points = FXCollections.observableList(FastList.newList());
			
			{
				points.addListener((ListChangeListener<Circle>) c -> redraw());
			}
			
			private void redraw() {
				var size = points.size();
				if (size < 2) {
					return;
				}
				
				var curveTmp = new FastList<Double>();
				
				for (var t = 0d; t <= 1; t += 0.001) {
					curveTmp.add(computeCoordinate(size - 1, t, c -> c.getCenterX() + c.getTranslateX()));
					curveTmp.add(computeCoordinate(size - 1, t, c -> c.getCenterY() + c.getTranslateY()));
				}
				
				getPoints().clear();
				getPoints().addAll(curveTmp);
			}
			
			private double computeCoordinate(int n, double t, ToDoubleFunction<Circle> coordinateGetter) {
				var acc = 0d;
				
				for (int i = 0; i < n + 1; i++) {
					var p = points.get(i);
					var binomialCoefficient = binomialCoefficient(n, i);
					
					acc += binomialCoefficient
							* Math.pow(1 - t, n - i)
							* Math.pow(t, i)
							* coordinateGetter.applyAsDouble(p);
				}
				
				return acc;
			}
			
		};
		
		controller.addElement(curve);
		
		setConfigurer(e -> {
			curve.points.add(e);
			e.centerXProperty().addListener((observable, oldValue, newValue) -> curve.redraw());
			e.centerYProperty().addListener((observable, oldValue, newValue) -> curve.redraw());
			e.translateXProperty().addListener((observable, oldValue, newValue) -> curve.redraw());
			e.translateYProperty().addListener((observable, oldValue, newValue) -> curve.redraw());
		});
	}
	
	@Override
	public void endSession() {
		setConfigurer(Procedures.noop());
	}
	
	private static int binomialCoefficient(int n, int k) {
		int optimalK = Math.min(k, n - k);
		
		return binomialCoefficientCache.getIfAbsentPut(pair(n, optimalK), () -> binomialCoefficientImpl(n, optimalK));
	}
	
	private static int binomialCoefficientImpl(int n, int k) {
		if (k < 0) {
			return 0;
		}
		
		if (k == 0 || n <= 1) {
			return 1;
		}
		
		return binomialCoefficient(n - 1, k) + binomialCoefficient(n - 1, k - 1);
	}
	
	private static final MutableObjectIntMap<IntIntPair> binomialCoefficientCache =
			new ObjectIntHashMap<>();
	
}
