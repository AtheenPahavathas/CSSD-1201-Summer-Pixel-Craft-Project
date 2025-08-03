// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

abstract class Converter {
   Converter() {
   }

   public abstract void convert(String var1, String var2) throws IOException;

   public BufferedImage readImg(String var1) throws IOException {
      File var2 = new File(var1);
      return ImageIO.read(var2);
   }

   public String getFileExtension(String var1) {
      int var2 = var1.lastIndexOf(".");
      return var1.substring(var2 + 1);
   }

   public void writeImg(BufferedImage var1, String var2) throws IOException {
      String var3 = this.getFileExtension(var2);
      File var4 = new File(var2);
      ImageIO.write(var1, var3, var4);
   }
}
