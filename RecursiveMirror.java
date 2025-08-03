import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecursiveMirror extends Converter{
	
	@Override
	public void convert(String inputFileName, String outputFileName)throws IOException {
		// read the image
		BufferedImage originalImg = readImg(inputFileName);
		
		//make a new img to draw on
		int width = originalImg.getWidth();
		int height = originalImg.getHeight();
		
		BufferedImage endlessMirror = new BufferedImage(width, height, originalImg.getType());
		
		// make/draw the smaller picture on top of the previous recursively
		Graphics2D g2d = endlessMirror.createGraphics();
		drawRecursiveMirror(g2d, originalImg,0, 0, width, height);
		
		g2d.dispose();
		
		writeImg(endlessMirror, outputFileName);
		
	}
	
	// recusrive method
	public void drawRecursiveMirror(Graphics2D g2d, BufferedImage img, int x, int y, int width, int height) {
		
		//base case
		if (width < 10 || height < 10) {
			return;
		}
		else {
			g2d.drawImage(img, x, y, width, height, null);
			drawRecursiveMirror(g2d, img, x, y, width / 2, height / 2);
		}
	}

}
