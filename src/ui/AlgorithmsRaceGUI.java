package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.*;

public class AlgorithmsRaceGUI {
	
	@SuppressWarnings("unused")
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