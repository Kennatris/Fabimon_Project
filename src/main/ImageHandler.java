package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public BufferedImage[] image = new BufferedImage[50]; //максимальное количество изображений max_Images
    public void ImageInitialiser(int imageNumber, String imageLocation, String imageName, String imageDataTyp) {
        try {
            image[imageNumber] = ImageIO.read(new File("./res/" + imageLocation + "/" + imageName + "." + imageDataTyp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
