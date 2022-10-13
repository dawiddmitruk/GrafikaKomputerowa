package dd.grafikakomputerowa1;

import javafx.scene.input.MouseEvent;


public abstract class BasicPressDragReleaseMode extends MultistageDrawingAreaMode {
	
	protected final StageOne stageOne = stageOne();
	private final StageTwo stageTwo = stageTwo();
	
	protected double originX;
	protected double originY;
	
	
	public BasicPressDragReleaseMode(DrawingAreaController controller) {
		super(controller);
		
		setStage(stageOne);
	}
	
	protected abstract StageOne stageOne();
	
	protected abstract StageTwo stageTwo();
	
	protected abstract class StageOne extends StageOfDrawing {
		
		@Override
		public final void onMousePressed(MouseEvent event) {
			originX = event.getX();
			originY = event.getY();
			
			if (onPressDragReleaseStarted(event)) {
				setStage(stageTwo);
			}
		}
		
		protected abstract boolean onPressDragReleaseStarted(MouseEvent event);
		
	}
	
	protected abstract class StageTwo extends StageOfDrawing {
		
		@Override
		public final void onMouseDragged(MouseEvent event) {
			onMousePositionChanged(event);
		}
		
		@Override
		public final void onMouseReleased(MouseEvent event) {
			onPressDragReleaseEnded(event);
			
			setStage(stageOne);
		}
		
		protected abstract void onMousePositionChanged(MouseEvent event);
		
		protected abstract void onPressDragReleaseEnded(MouseEvent event);
		
	}
	
}
