 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;


public class Binary extends Converter {
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
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        parseImage(inputImage, outputImage);
        return outputImage;
    }

    public static void parseImage(BufferedImage inputImage, BufferedImage outputImage){
        for (int y = 0; y < inputImage.getHeight(); y++) {
            for (int x = 0; x < inputImage.getWidth(); x++) {
                ARGB argb = new ARGB(inputImage.getRGB(x, y));
                if (argb.toInt() >= 0xFF7F7F7F ) {
                    outputImage.setRGB(x, y, 0xFFFFFFFF);
                }
                else {
                    outputImage.setRGB(x, y, 0x00000000);
                }
            }
        }
    }
}