package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;


public class Feirir extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public Feirir(GameHandler gameH, String fabimonName, int fabimonEvo, int plevel) {
        super(gameH);
        getFeirirImage();
    }
    public void getFeirirImage(){
        imageH.ImageInitializer(0, "Fabimon/Feirir", "l0_fire_starter_first_evo1", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        imageH.ImageInitializer(1, "Fabimon/Feirir", "l0_fire_starter_first_evo2", "png", gameH.tileSize, gameH.tileSize);
        up2 = imageH.image[1];
        imageH.ImageInitializer(2, "Fabimon/Feirir", "l0_fire_starter_first_evo3", "png", gameH.tileSize, gameH.tileSize);
        down1 = imageH.image[2];
        imageH.ImageInitializer(3, "Fabimon/Feirir", "l0_fire_starter_first_evo4", "png", gameH.tileSize, gameH.tileSize);
        down2 = imageH.image[3];
        imageH.ImageInitializer(4, "Fabimon/Feirir", "l0_fire_starter_first_evo5", "png", gameH.tileSize, gameH.tileSize);
        left1 = imageH.image[4];
    }
}

