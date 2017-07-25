package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import noise.NoiseManager;

public class ApplicationController implements Initializable {
	private NoiseManager manager;
	
	@FXML VBox noiseModuleContainer;
	@FXML Button addSimplexButton;
	@FXML Button addCombinerButton;
	@FXML Button addFractalButton;
	@FXML Button recalculateButton;
	@FXML Canvas heightmapCanvas;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert noiseModuleContainer != null;
		assert addSimplexButton != null;
		assert addCombinerButton != null;
		assert addFractalButton != null;
		assert recalculateButton != null;
		assert heightmapCanvas != null;
		
		this.manager = new NoiseManager(heightmapCanvas);
		
		handleActions();
	}
	
	private void handleActions() {
		addSimplexButton.setOnAction((e) -> {
			
		});
		
		addCombinerButton.setOnAction((e) -> {
			
		});
		
		addFractalButton.setOnAction((e) -> {
			addModule("NoiseModuleFractal.fxml");
		});
		
		recalculateButton.setOnAction((e) -> {
			
		});
	}
	
	private void addModule(String fileName) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(fileName));
			AnchorPane toAdd = loader.load();
			
//			Pane parent = (Pane) noiseModuleContainer.getParent();
//			parent.getChildren().add(toAdd);
			noiseModuleContainer.getChildren().add(toAdd);
			((NoiseModuleController) loader.getController()).prepare(toAdd);
		} catch (IOException e) {
			System.out.println("Failed to open " + fileName);
			e.printStackTrace();
		}		
	}
}
