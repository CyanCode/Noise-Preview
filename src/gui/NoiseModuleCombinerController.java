package gui;

import com.sudoplay.joise.module.Module;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class NoiseModuleCombinerController extends NoiseModuleController {
	@FXML ChoiceBox<String> combinationType;
	@FXML ChoiceBox<String> module1Choice;
	@FXML ChoiceBox<String> module2Choice;
	@Override
	public Module getModule() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	protected String getFxmlPath() {
//		return "NoiseModuleCombiner.fxml";
//	}
}
