// add the grayscale
 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

public class Grayscale extends Converter {
    
    protected BufferedImage processImage(BufferedImage inputImage) {
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        parseImage(inputImage, outputImage, 0, 0);
        return outputImage;
    }

    public static void parseImage(BufferedImage inputImage, BufferedImage outputImage, int x, int y) {
        if (y == inputImage.getHeight()) {
            return;

        }
        if (x == inputImage.getWidth()){
            parseImage(inputImage, outputImage, 0, y + 1);
            return;
        }

        ARGB argb = new ARGB(inputImage.getRGB(x, y));
        int gray = (argb.red + argb.green + argb.blue) / 3;
        ARGB grayARGB = new ARGB(argb.alpha, gray, gray, gray);
        outputImage.setRGB(x, y, grayARGB.toInt());

        if (x < inputImage.getWidth() -1) {
            parseImage(inputImage, outputImage, x + 1, y);

        }
        else {
            parseImage(inputImage, outputImage, 0, y + 1);
        }
    }
}