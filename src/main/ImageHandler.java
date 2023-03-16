package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public BufferedImage[] image = new BufferedImage[50]; // max_Images
    public void ImageInitialiser(int imageNumber, String imageName, String imageDataTyp) {
        try {
            image[imageNumber] = ImageIO.read(new File("./res/main/" + imageName + "." + imageDataTyp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
