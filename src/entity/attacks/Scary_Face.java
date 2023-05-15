package entity.attacks;

import entity.Attack;
import main.GameHandler;

public class Scary_Face extends Attack {
    GameHandler gameH;
    public Scary_Face(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Scary_Face");
        category = "status";
        accuracy = 100;
        ap = 10;
        type = "Normal";
        accDown = 2;
        priority = 0;
    }
}
