 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

public class Flip extends Converter{ // recursive converter that flips the pixel location horizonally
	
	@Override
	public void convert(String inputFileName, String outputFileName) throws IOException{
		// read the file
		BufferedImage originalImg = readImg(inputFileName);
		
		int width = originalImg.getWidth();
		int height = originalImg.getHeight();
		
		// loop through each pixel and swap the outermost pixels
		for (int y = 0; y < height; y++) {
			flipRow(originalImg, y, 0, width - 1);
		}
		
		writeImg(originalImg, outputFileName);
	}
	
	// recursive method to flip pixels
	public void flipRow(BufferedImage img, int y, int left, int right) {
		//base case
		if (left >= right) {
			return;
		}
		//recursive case
		else {
			int temp= img.getRGB(left, y);
	        img.setRGB(left, y, img.getRGB(right, y));
	        img.setRGB(right, y, temp);
	        
	        flipRow(img, y, left + 1, right - 1);
		}
	}
}
