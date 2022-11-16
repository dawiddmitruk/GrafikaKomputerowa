package dd.grafikakomputerowa1;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class BasicDrawingAreaMode implements DrawingAreaMode {
	
	protected final DrawingAreaController controller;
	
	@Override
	public void startSession() {}
	
	@Override
	public void endSession() {}
	
}
