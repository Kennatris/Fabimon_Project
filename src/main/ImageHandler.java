package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ImageHandler {
    public BufferedImage[] image = new BufferedImage[50]; // max_Images
    public void ImageInitializer(int imageNumber, String imageLocation, String imageName, String imageDataTyp, int refactoredWidth, int refactoredHeight) {

        UtilityTool uTool = new UtilityTool();
        image[imageNumber] = null;

        try {
            image[imageNumber] = ImageIO.read(new File("./res/" + imageLocation + "/" + imageName + "." + imageDataTyp));
            image[imageNumber] = uTool.scaleImage(image[imageNumber], refactoredWidth, refactoredHeight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
