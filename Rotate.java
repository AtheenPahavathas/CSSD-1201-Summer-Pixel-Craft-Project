 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

 public class Rotate extends Converter {
    protected BufferedImage processImage(BufferedImage inputImage) {
        BufferedImage outputImage = new BufferedImage(inputImage.getHeight(), inputImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                ARGB argb = new ARGB(inputImage.getRGB(x, y));
                outputImage.setRGB(inputImage.getHeight() - 1 - y, x, argb.toInt());

            }
        }
        return outputImage;
    }
 }
