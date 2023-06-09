package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Assurance extends Attack {
    GameHandler gameH;
    public Assurance(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Assurance");
        power = 60;
        accuracy = 100;
        category = "physical";
        type = "Dark";
        priority = 0;
        ap = 10;
        name = "Assurance";
        trifftImmer = false;
        target = "enemy";
    }
}
