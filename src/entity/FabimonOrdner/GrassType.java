package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class GrassType extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public GrassType(GameHandler gameH){
        super(gameH);
        getGrassTypeimage();

    }
    public void getGrassTypeimage(){
        imageH.ImageInitializer(0, "Fabimon/Grass Type", "l0_grass_starter1", "png", gameH.tileSize, gameH.tileSize);
        imageH.ImageInitializer(1, "Fabimon/Grass Type", "l0_grass_starter2", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        up2 = imageH.image[1];
        down1 = imageH.image[0];
        down2 = imageH.image[1];
        left1 = imageH.image[0];
    }
}
