package test;

import java.awt.Dimension;
import javax.swing.JFrame;
import com.sudoplay.joise.module.Module;
import com.sudoplay.joise.module.ModuleAutoCorrect;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleCombiner;
import com.sudoplay.joise.module.ModuleCombiner.CombinerType;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;
import com.sudoplay.joise.module.ModuleBasisFunction.BasisType;

public class Noise {
	public static void main(String[] args) {
		Noise n = new Noise();
		
		n.testChaining();
	}
	
	public void testChaining() {
		final int seed = 1337;
		
		ModuleBasisFunction simplex = new ModuleBasisFunction();
		simplex.setType(BasisType.SIMPLEX);
		simplex.setSeed(seed);
		
		ModuleFractal fractal = new ModuleFractal();
		fractal.setNumOctaves(5);
		fractal.setFrequency(2.34);
		fractal.setType(FractalType.RIDGEMULTI);
		fractal.setSeed(seed);
		
		ModuleCombiner combined = new ModuleCombiner(CombinerType.AVG);
		combined.setSource(0, simplex);
		combined.setSource(1, fractal);
		
		ModuleAutoCorrect ac = new ModuleAutoCorrect();
		ac.setSource(combined);
		ac.setRange(0f, 1f);
		ac.setSamples(1000);
		ac.calculate();
	
		previewNoise(ac);
	}
	
	private void previewNoise(Module func) {
		int width = 640;
		int height = 640;
		
		JFrame frame = new JFrame("Joise Example 01");
	    frame.setPreferredSize(new Dimension(width, height));

	    Canvas canvas = new Canvas(width, height);
	    frame.add(canvas);

	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    canvas.updateImage(func);
	    
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	}
}
