package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.*;
import threads.StructureThread;

public class AlgorithmsRaceGUI {
	
	private RaceManager raceManager;
	
	private StructureThread arrayListThread;
	private StructureThread linkedListThread;
	private StructureThread bstThread;
	
	public AlgorithmsRaceGUI() {
		raceManager = new RaceManager();
		arrayListThread = new StructureThread(raceManager.getArrayList());
		linkedListThread = new StructureThread(raceManager.getLinkedList());
		bstThread = new StructureThread(raceManager.getBst());
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
    void Run(ActionEvent event) {
    	
    	try {
    		
    		int n = Integer.parseInt(textN.getText());
    		
    		if(n<=0) {
    			throw new NumberFormatException();
    		}
    		
    		if(iterative.isSelected()) {
    			arrayListThread.setInModeInterative(true);
    			linkedListThread.setInModeInterative(true);
    			bstThread.setInModeInterative(true);
    		}else {
    			arrayListThread.setInModeInterative(true);
    			linkedListThread.setInModeInterative(true);
    			bstThread.setInModeInterative(true);
    		}
    		
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
    		
    		arrayListThread.start();
			linkedListThread.start();
			bstThread.start();
			
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Number invalidated");
    		alert.setContentText("Please, type a natural number");
    		alert.showAndWait();
    	}
    }

    @FXML
    void reset(ActionEvent event) {
    	textN.setText("");
    	timekeeper.setText("");
    	timeArrayList.setText("");
    	timeLinkedList.setText("");
    	timeBST.setText("");
    }

}