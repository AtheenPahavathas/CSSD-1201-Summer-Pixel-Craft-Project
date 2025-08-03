 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
 import javax.imageio.ImageIO;
 import java.awt.image.BufferedImage;
 import java.io.File;

public class Blur extends Converter{
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
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                outputImage.setRGB(x, y, getBlurredPixel(inputImage, x, y));

            }
        }
        return outputImage;
    }

    private int getBlurredPixel(BufferedImage image, int x, int y) {
        int red = 0, green = 0, blue = 0, alpha = 0;
        int count = 0;
        
        for (int dx = -3; dx <= 3; dx++) {
            for (int dy = -3; dy <= 3; dy++) {
                int newX = x + dx;
                int newY = y + dy;

                if (newX >= 0 && newX < image.getWidth() && newY >= 0 && newY < image.getHeight()) {
                    int argb = image.getRGB(newX, newY);
                    alpha += (argb >> 24) & 0xFF;
                    red += (argb >> 16) & 0xFF;
                    green += (argb >> 8) & 0xFF;
                    blue += (argb) & 0xFF;
                    count++;
                }
            }
        }
        int avgAlpha = alpha / count;
        int avgRed = red / count;
        int avgGreen = green / count;
        int avgBlue = blue / count;

        return (avgAlpha << 24) | (avgRed << 16) | (avgGreen << 8) | avgBlue;
    }
} 