package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;


public class MovingShapesMode extends BasicPressDragReleaseMode {
	
	private Shape currentlyPickedUp;
	
	private double originalTranslationX;
	private double originalTranslationY;
	
	
	public MovingShapesMode(DrawingAreaController controller) {
		super(controller);
	}
	
	@Override
	protected StageOne stageOne() {
		return new StageOne() {
			@Override
			protected boolean onPressDragReleaseStarted(MouseEvent event) {
				if (event.getTarget() instanceof Shape s) {
					currentlyPickedUp = s;
					
					originalTranslationX = s.getTranslateX();
					originalTranslationY = s.getTranslateY();
					
					return true;
				}
				
				return false;
			}
		};
	}
	
	@Override
	protected StageTwo stageTwo() {
		return new StageTwo() {
			@Override
			public void onMousePositionChanged(MouseEvent event) {
				currentlyPickedUp.setTranslateX(event.getX() - originX + originalTranslationX);
				currentlyPickedUp.setTranslateY(event.getY() - originY + originalTranslationY);
			}
			
			@Override
			protected void onPressDragReleaseEnded(MouseEvent event) {
				currentlyPickedUp = null;
			}
		};
	}
	
}
