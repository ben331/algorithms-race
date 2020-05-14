package threads;
import javafx.application.Platform;
import javafx.scene.shape.Circle;
import ui.AlgorithmsRaceGUI;

public class CircleAnimationThread extends Thread{
	
	private Circle circle;
	private AlgorithmsRaceGUI controllerGUI;
	private boolean startDecreasing;
	private boolean active;
	
	public CircleAnimationThread(AlgorithmsRaceGUI controllerGUI, Circle circle, boolean startDecreasing) {
		super();
		this.controllerGUI = controllerGUI;
		this.circle = circle;
		this.startDecreasing = startDecreasing;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void run() {
		if(startDecreasing) {
			while(active) {
				while(circle.getRadius() >1) {
					double radius = decrease(circle);
					Platform.runLater( new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(13);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							controllerGUI.updateWhiteCircle(radius);
						}
					});
				}
				while(circle.getRadius() < 40) {
					double radius = decrease(circle);
					Platform.runLater( new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(13);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							controllerGUI.updateWhiteCircle(radius);
						}
					});
				}
			}
		}else {
			while(active) {
				while(circle.getRadius() < 40) {
					double radius = decrease(circle);
					Platform.runLater( new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(13);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							controllerGUI.updateBlueCircle(radius);
						}
					});
				}
				while(circle.getRadius() >1) {
					double radius = decrease(circle);
					Platform.runLater( new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(13);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							controllerGUI.updateBlueCircle(radius);
						}
					});
				}
			}
		}
	}
	
	public double increase(Circle c) {
		return c.getRadius() + 1;
	}
	
	public double decrease(Circle c) {
		return c.getRadius() - 1;
	}
}