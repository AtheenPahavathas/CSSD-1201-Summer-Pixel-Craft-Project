import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
public class CheckerBoard extends Converter{
	
	private int SQUARE_SIZE = 20;
	
	@Override
	public void convert(String inputFileName, String outputFileName) throws IOException {
		// read the file
		BufferedImage originalImg = readImg(inputFileName);
		
		int width = originalImg.getWidth();
		int height = originalImg.getHeight();
		
		BufferedImage checkered = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		// white
		int white = new ARGB(255,255,255,255).toInt();
		// black 
		int black = new ARGB(255, 0, 0, 0).toInt();
		
		// loop through each pixel 
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
        // decide what square we are on
				boolean isWhiteSquare = ((x / SQUARE_SIZE + y / SQUARE_SIZE) % 2 == 0);
				
				//set the square color
				if (isWhiteSquare) {
					checkered.setRGB(x, y, white);
				}
				else {
					checkered.setRGB(x, y, black);
				}
			}
		}
		
		writeImg(checkered, outputFileName);
	}

}
