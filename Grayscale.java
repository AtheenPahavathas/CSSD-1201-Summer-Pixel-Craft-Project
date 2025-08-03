// add the grayscale
 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

public class Grayscale extends Converter {

        @Override
public void convert(String inputFileName, String outputFileName) {
    try {
        BufferedImage inputImage = ImageIO.read(new File(inputFileName));

        BufferedImage outputImage = processImage(inputImage);

        ImageIO.write(outputImage, "png", new File(outputFileName));

    } catch (IOException e) {
        System.out.println("Error during blur conversion: " + e.getMessage());
    }
}
    protected BufferedImage processImage(BufferedImage inputImage) {
       int width = inputImage.getWidth();
       int height = inputImage.getHeight();
       BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

       for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            ARGB argb = new ARGB(inputImage.getRGB(x, y));
            int gray = (argb.red + argb.green + argb.blue) / 3;
            ARGB grayARGB = new ARGB(argb.alpha, gray, gray, gray);
            outputImage.setRGB(x, y, grayARGB.toInt());
        }
       }
       return outputImage;
    }
}
