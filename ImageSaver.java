import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import java.io.File;

public class ImageSaver {
    public void doSaveGray () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            GrayScaleConvertor gray = new GrayScaleConvertor();
            ImageResource image1 = new ImageResource(f);
            String fname = image1.getFileName();
            String newName = "gray-" + fname;
            image1 = gray.makeGray(image1);
            image1.setFileName(newName);
            image1.draw();
            image1.save();
        }
    }
    public void doSaveInverted () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            BatchInversions inverted = new BatchInversions();
            ImageResource image1 = new ImageResource(f);
            String fname = image1.getFileName();
            String newName = "inverted-" + fname;
            image1 = inverted.makeInversion(image1);
            image1.setFileName(newName);
            image1.draw();
            image1.save();
            
        }
    }
}
