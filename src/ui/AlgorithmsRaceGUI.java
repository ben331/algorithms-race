package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.*;

public class AlgorithmsRaceGUI {
	
	private RaceManager raceManager = new RaceManager();

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
    		if(add.isSelected()) {
        		if(iterative.isSelected()) {
        			raceManager.startRaceAddIterative(textN.getText());
        		}else {
        			raceManager.startRaceAddRecursive(textN.getText());
        		}
        	}else if(search.isSelected()) {
        		if(iterative.isSelected()) {
        			raceManager.startRaceSearchIterative(textN.getText());
        		}else {
        			raceManager.startRaceSearchRecursive(textN.getText());
        		}
        	}else {
        		if(iterative.isSelected()) {
        			raceManager.startRaceDeleteIterative(textN.getText());
        		}else {
        			raceManager.startRaceDeleteRecursive(textN.getText());
        		}
        	}
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