package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.RaceManager;
public class Main extends Application{
	
	private AlgorithmsRaceGUI controllerGUI;
	private RaceManager raceManager;
	
	public Main() {
		raceManager= new RaceManager();
		controllerGUI = new AlgorithmsRaceGUI(raceManager);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AlgorithmsRace.fxml"));
		loader.setController(controllerGUI);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Basic Algorithms Race");
		primaryStage.show();
	}

}
