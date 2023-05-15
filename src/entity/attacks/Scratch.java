package entity.attacks;

import entity.Attack;
import main.GameHandler;

public class Scratch extends Attack {
    GameHandler gameH;
    public Scratch(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Scratch");
        power = 40;
        accuracy = 100;
        category = "physical";
        type = "Normal";
        priority = 0;
        ap = 35;
    }
}
