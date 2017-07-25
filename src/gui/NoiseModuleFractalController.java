package gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.sudoplay.joise.module.Module;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import noise.PreviewCanvas;

public class NoiseModuleFractalController extends NoiseModuleController implements Initializable {
	@FXML ChoiceBox<String> noiseType;
	@FXML Button previewButton;
	@FXML TextField seedTextField;
	@FXML TextField lacunarityTextField;
	@FXML TextField octaveCountTextField;
	@FXML TextField gainTextField;
	
	public final ObservableList<String> fractalTypePreview = 
			FXCollections.observableArrayList("Billow", "Decarpentierswiss", "Fractal", "Hybrid Multi", "Multi", "Ridge Multi");
			
	
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
		
		//Set noise type values
		noiseType.setItems(fractalTypePreview);
		
		prepare();
	}
	
	public String fractalTypeToString(FractalType type) {
		switch (type) {
		case BILLOW: return "Billow";
		case DECARPENTIERSWISS: return "Decarpentierswiss";
		case FBM: return "Fractal";
		case HYBRIDMULTI: return "Hybrid Multi";
		case MULTI: return "Multi";
		case RIDGEMULTI: return "Ridge Multi";
		default: return "";
		}
	}
	
	public FractalType stringToFractalType(String s) {
		switch (s) {
		case "Billow": return FractalType.BILLOW;
		case "Decarpentierswiss": return FractalType.DECARPENTIERSWISS;
		case "Fractal": return FractalType.FBM;
		case "Hybrid Multi": return FractalType.HYBRIDMULTI;
		case "Multi": return FractalType.MULTI;
		case "Ridge Multi": return FractalType.RIDGEMULTI;
		default: return FractalType.FBM;
		}
	}
	
	public void prepare() {
		previewButton.setOnAction((e) -> { //Preview individual noise module
			System.out.println("Module ID " + getModuleId() + " preview button pressed");
			PreviewCanvas.previewModule(getModule());
		});
	}

	@Override
	public Module getModule() {
		ModuleFractal fractal = new ModuleFractal();
		fractal.setNumOctaves(validateStringAsInt(octaveCountTextField.getText()));
		fractal.setLacunarity(validateStringAsFloat(lacunarityTextField.getText()));
		fractal.setGain(validateStringAsFloat(gainTextField.getText()));
		fractal.setSeed(validateStringAsInt(seedTextField.getText()));
		fractal.setType(stringToFractalType(noiseType.getSelectionModel().getSelectedItem().toString()));
		
		return fractal;
	}
}
