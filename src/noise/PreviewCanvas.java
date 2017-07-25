package noise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sudoplay.joise.module.Module;

public class PreviewCanvas extends JPanel {
	private static final long serialVersionUID = -5828251248184381247L;
	private static final float SCALE = 1.0f;
	private BufferedImage image;

	public PreviewCanvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public void updateImage(Module mod) {
		int width = image.getWidth();
		int height = image.getHeight();
		float px, py, r;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				px = x / (float) width * SCALE;
				py = y / (float) height * SCALE;

				/*
				 * Sample the module chain like this...
				 */
				r = (float) mod.get(px, py);

				r = Math.max(0, Math.min(1, r));
				image.setRGB(x, y, new Color(r, r, r).getRGB());
			}
		}
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(image, null, null);
		g2.dispose();
	}
	
	public static PreviewCanvas previewModule(Module mod) {		
		final int width = 640;
		final int height = 640;
		
		JFrame frame = new JFrame("Noise Preview");
	    frame.setPreferredSize(new Dimension(width, height));

	    PreviewCanvas canvas = new PreviewCanvas(width, height);
	    frame.add(canvas);

	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    canvas.updateImage(mod);
	    
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    
	    return canvas;
	}
}