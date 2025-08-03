public abstract class Converter { // Base class for the "converters" to inherit from 
	
	// convert
	public abstract void convert (String inputFileName, String outputFileName) throws IOException;
	
	// read image
	public BufferedImage readImg(String fileName) throws IOException {
		
		File file = new File(fileName);
		return ImageIO.read(file);
	}
	
	// so that it writes for any file extension
	public String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		return fileName.substring(dotIndex + 1).toUpperCase();
	}
	
	// write image
	public void writeImg(BufferedImage image, String fileName) throws IOException {
	    String format = getFileExtension(fileName); // e.g., "png", "jpg"
	    File file = new File(fileName);
	    ImageIO.write(image, format, file);
	}
	
	
}
