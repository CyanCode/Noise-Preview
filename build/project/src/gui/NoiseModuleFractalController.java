package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class NoiseModuleFractalController extends NoiseModuleController implements Initializable {
	@FXML ChoiceBox<String> noiseType;
	@FXML Button previewButton;
	@FXML TextField seedTextField;
	@FXML TextField lacunarityTextField;
	@FXML TextField octaveCountTextField;
	@FXML TextField gainTextField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assert noiseType != null;
		assert previewButton != null;
		assert seedTextField != null;
		assert lacunarityTextField != null;
		assert octaveCountTextField != null;
		assert gainTextField != null;
		assert numberButton != null;
		assert removeButton != null;
	}
	
	
}
