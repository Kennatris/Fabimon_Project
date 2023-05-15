package entity.attacks;

import entity.Attack;
import main.GameHandler;

public class Ember extends Attack {
    GameHandler gameH;

    public Ember(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Ember");
        category = "special";
        type = "Fire";
        power = 40;
        accuracy = 100;
        ap = 25;
        priority = 0;
    }
}
