import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;
import java.io.File;

public class BatchInversions {
    public ImageResource makeInversion (ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int oppositeRed = 255 - inPixel.getRed();
            pixel.setRed(oppositeRed);
            int oppositeGreen = 255 - inPixel.getGreen();
            pixel.setGreen(oppositeGreen);
            int oppositeBlue = 255 - inPixel.getBlue();
            pixel.setBlue(oppositeBlue);
        }
        return outImage;
    }
    
    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource inverted = makeInversion(inImage);
            inverted.draw();
        }
    }
}
