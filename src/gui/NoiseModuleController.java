package gui;

import javax.swing.JOptionPane;

import com.sudoplay.joise.module.Module;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class NoiseModuleController extends AnchorPane {
	private int moduleId = -1;
	private Pane anchor;
	
	@FXML Button numberButton;
	@FXML Button removeButton;
	
	public void prepare(Pane anchor) {
		this.anchor = anchor;
		
		numberButton.setDisable(true);
		removeButton.setOnAction((e) -> { //Remove self from parent
			ObservableList<Node> children = ((Pane) this.anchor.getParent()).getChildren();
			
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i) == anchor) {
					children.remove(i);
					i--;
				}
			}
		});
	}
	
	public void setModuleId(int id) {
		this.moduleId = id;
		numberButton.setText(id + "");
	}
	
	public int getModuleId() {
		return moduleId;
	}
	
	protected float validateStringAsFloat(String s) {
		try {
			return Float.parseFloat(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, s + " is not a valid float value.", "Parse Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return Float.NaN;
	}
	
	protected int validateStringAsInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, s + " is not a valid integer value.", "Parse Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return 0;
	}
	
	public abstract Module getModule();
}
