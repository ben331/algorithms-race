package ui;

import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.*;
import threads.*;

public class AlgorithmsRaceGUI {
	
	private RaceManager raceManager;
	
	public AlgorithmsRaceGUI(RaceManager raceManager) {
		this.raceManager = raceManager;
	}

    @FXML
    private TextField textN;

    @FXML
    private RadioButton add;

    @FXML
    private ToggleGroup algorithm;

    @FXML
    private RadioButton search;

    @FXML
    private RadioButton delete;

    @FXML
    private RadioButton iterative;

    @FXML
    private ToggleGroup mode;

    @FXML
    private RadioButton recursive;

    @FXML
    private TextField timekeeper;

    @FXML
    private TextField timeArrayList;

    @FXML
    private TextField timeLinkedList;

    @FXML
    private TextField timeBST;
    
    @FXML
    private Button buttonRun;
    
    @FXML
    private Circle whiteCircle;

    @FXML
    private Circle blueCircle;
    
    @FXML
    void Run(ActionEvent event) {
    	
    	buttonRun.setDisable(true);
    	
    	Random random = new Random();
    	
    	whiteCircle.setRadius(40);
    	blueCircle.setRadius(1);
    	
    	//Create threads
    	StructureThread arrayListThread = new StructureThread(raceManager.getArrayList(), random);
    	StructureThread linkedListThread = new StructureThread(raceManager.getLinkedList(), random);
    	StructureThread bstThread = new StructureThread(raceManager.getBst(), random);
		Chronometer chronoTimekeeper = new Chronometer();
		Chronometer chronoArrayList = new Chronometer();
		Chronometer chronoLinkedList = new Chronometer();
		Chronometer chronoBST= new Chronometer();
		CircleAnimationThread animation1 = new CircleAnimationThread(this, whiteCircle, true);
		CircleAnimationThread animation2 = new CircleAnimationThread(this, blueCircle, false);
    	
    	try {
    		
    		
    		//Setting elements
    		int n = Integer.parseInt(textN.getText());
    		
    		if(n<=0) {
    			throw new NumberFormatException();
    		}
    		arrayListThread.setN(n);
			linkedListThread.setN(n);
			bstThread.setN(n);
    		
    		//Setting mode
    		if(iterative.isSelected()) {
    			arrayListThread.setInModeIterative(true);
    			linkedListThread.setInModeIterative(true);
    			bstThread.setInModeIterative(true);
    		}else {
    			arrayListThread.setInModeIterative(false);
    			linkedListThread.setInModeIterative(false);
    			bstThread.setInModeIterative(false);
    		}
    		
    		
    		//Setting method
    		if(add.isSelected()) {
    			
    			arrayListThread.setMethod(StructureThread.ADD);
    			linkedListThread.setMethod(StructureThread.ADD);
    			bstThread.setMethod(StructureThread.ADD);
    			
        	}else if(search.isSelected()) {
        		
        		arrayListThread.setMethod(StructureThread.SEARCH);
    			linkedListThread.setMethod(StructureThread.SEARCH);
    			bstThread.setMethod(StructureThread.SEARCH);
        		
        	}else {
        		
        		arrayListThread.setMethod(StructureThread.REMOVE);
    			linkedListThread.setMethod(StructureThread.REMOVE);
    			bstThread.setMethod(StructureThread.REMOVE);
        	}
    		
    		
    		//Start race
    		arrayListThread.start();
			linkedListThread.start();
			bstThread.start();
			
			//Start chronometers
			chronoTimekeeper.setActive(true);
			chronoArrayList.setActive(true);
			chronoLinkedList.setActive(true);
			chronoBST.setActive(true);
			
			chronoTimekeeper.start();
			chronoArrayList.start();
			chronoLinkedList.start();
			chronoBST.start();
			
			//Start Animations
			animation1.setActive(true);
			animation2.setActive(true);
			animation1.start();
			animation2.start();
			
			new Thread() {
				@Override
				public void run() {
					while((arrayListThread.isAlive() || linkedListThread.isAlive()) || bstThread.isAlive()) {
						
						String array = chronoArrayList.toString();
						String linked = chronoLinkedList.toString();
						String bst = chronoBST.toString();
						String timekeeper = chronoTimekeeper.toString();
						
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						Platform.runLater( new Thread() {
							@Override
							public void run(){
								updateTimekeeper(timekeeper);
								updateArrayListTime(array);
								updateLinkedListTime(linked);
								updateBSTTime(bst);
							}
						});
						
						
						
						if(!arrayListThread.isAlive()) {
							chronoArrayList.setActive(false);
						}if(!linkedListThread.isAlive()) {
							chronoLinkedList.setActive(false);
						}if(!bstThread.isAlive()) {
							chronoBST.setActive(false);
						}
					}
					chronoTimekeeper.setActive(false);
					
					
					animation1.setActive(false);
					animation2.setActive(false);
				}
			}.start();
			
			
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Number invalidated");
    		alert.setContentText("Please, type a natural number");
    		alert.showAndWait();
    	}
    	
    	buttonRun.setDisable(false);
    }

    @FXML
    void reset(ActionEvent event) {
    	timekeeper.setText("00:00:000");
		timeArrayList.setText("00:00:000");
		timeLinkedList.setText("00:00:000");
		timeBST.setText("00:00:000");		
		whiteCircle.setRadius(40);
		blueCircle.setRadius(1);
		raceManager.clearData();
    }
    
    public void updateWhiteCircle(double r) {
    	whiteCircle.setRadius(r);
    }
    
    public void updateBlueCircle(double r) {
    	blueCircle.setRadius(r);
    }
    
    public void updateTimekeeper(String text) {
    	timekeeper.setText(text);
    }
    
    public void updateArrayListTime(String text) {
    	timeArrayList.setText(text);
    }
    
    public void updateLinkedListTime(String text) {
    	timeLinkedList.setText(text);
    }
    
    public void updateBSTTime(String text) {
    	timeBST.setText(text);
    }
}