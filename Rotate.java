 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

 public class Rotate extends Converter {
    /**
     * The image is rotated 90 degrees clockwise.
     * The inputImage's pixel's ARGB values are set to the outputImage's pixel.
     * Its x value would be the imputImage's height minus 1 minus the inputImage's y value.
     * Its y value is the inputImages x value.
     */
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
