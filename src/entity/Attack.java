package entity;

import main.GameHandler;
import main.ImageHandler;

import java.awt.image.BufferedImage;

public class Attack{
    public BufferedImage ausgewählt, nausgewählt;
    GameHandler gameH;
    ImageHandler imageH = new ImageHandler();
    public int power;
    public int accuracy;
    public String type;
    public String category;
    public int ap;
    public int priority;
    public int accUp;
    public int accDown;

    public Attack(GameHandler gameH){
        this.gameH = gameH;
    }
    public void getButtonImage(String fileName){
        imageH.ImageInitializer(0, "Buttons/AttackButtons", fileName + "1", "png", gameH.tileSize, gameH.tileSize);
        nausgewählt = imageH.image[0];
        imageH.ImageInitializer(1, "Buttons/AttackButtons", fileName + "2", "png", gameH.tileSize, gameH.tileSize);
        ausgewählt = imageH.image[1];
    }
}
