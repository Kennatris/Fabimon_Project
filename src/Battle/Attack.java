package Battle;

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
    public int ap; // max ap
    public int currentap;
    public int priority;
    public int effect[] = {0, 0, 0, 0, 0, 0, 0};
    //{dodge, acc, atk, dev, sp_atk, sp_dev, init};
    public String target;
    public String name;
    public Boolean trifftImmer;
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
