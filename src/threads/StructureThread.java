package threads;
import java.util.Random;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.*;
import model.DataStructure;
public class StructureThread extends Thread{
	
	public static final char ADD = 'A';
	public static final char REMOVE = 'R';
	public static final char SEARCH = 'S';
	
	private DataStructure dataStructure;
	
	private char method;
	private boolean inModeIterative;
	private int n;
	private Random r;
	
	public StructureThread(DataStructure dataStructure, Random r) {
		this.dataStructure = dataStructure;
		this.r =r;
	}
	
	
	public void setMethod(char method) {
		this.method = method;
	}
	
	public void setInModeIterative(boolean inModeIterative) {
		this.inModeIterative = inModeIterative;
	}

	public void setN(int n) {
		this.n = n;
	}




	@Override
	public void run() {
		try {
			
			if(inModeIterative) {
				switch(method) {
				case ADD:
					dataStructure.addIterative(n, r);
					break;
				case SEARCH:
					dataStructure.searchIterative(n, r);
					break;
				case REMOVE:
					dataStructure.removeIterative(n, r);
					break;
				}
			}else {
				switch(method) {
				case ADD:
					dataStructure.addRecursive(0, n, r);
					break;
				case SEARCH:
					dataStructure.searchRecursive(0, n, r);
					break;
				case REMOVE:
					dataStructure.removeRecursive(0, n, r);
					break;
				}
			}
			
		}catch(StackOverflowError | OutOfMemoryError e ) {
			
			String structure;
			
			if(dataStructure instanceof AList) {
				structure = "ArrayList";
			}else if(dataStructure instanceof LinkedList) {
				structure = "LinkedList";
			}else {
				structure = "Binary Search Tree";
			}
			
			Platform.runLater( new Thread() {
				@Override
				public void run() {
					Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("StackOverFlow");
		    		alert.setContentText("Structure: '"+structure+"' suffered an StackOverFlowError and it's out of the race  :(");
		    		alert.showAndWait();
				}
			});
		}
		
	}
}
