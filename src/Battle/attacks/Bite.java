package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Bite extends Attack {
    GameHandler gameH;
    public Bite(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Bite");
        power = 60;
        accuracy = 100;
        category = "physical";
        type = "Dark";
        priority = 0;
        ap = 25;
        name = "Bite";
        trifftImmer = false;
        target = "enemy";
    }
}
