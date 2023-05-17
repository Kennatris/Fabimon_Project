package Battle.attacks;

import entity.Attack;
import main.GameHandler;

public class Growl extends Attack {
    GameHandler gameH;
    public Growl(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Growl");
        category = "status";
        type = "Normal";
        accuracy = 100;
        ap = 40;
        priority = 0;
        name = "growl";
    }
}
