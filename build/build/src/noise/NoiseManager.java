package noise;

import java.util.ArrayList;

import gui.NoiseModuleController;
import javafx.scene.canvas.Canvas;

public class NoiseManager {
	private Canvas canvas;
	private ArrayList<NoiseModuleController> modules;
	
	public NoiseManager(Canvas canvas) {
		this.canvas = canvas;
		this.modules = new ArrayList<NoiseModuleController>();
	}
	
	public void addModule(NoiseModuleController module) {
		modules.add(module);
		module.setModuleId(modules.size());
	}
	
	public void reassignModuleIds() {
		
	}
}
