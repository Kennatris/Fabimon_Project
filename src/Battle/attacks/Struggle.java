package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Struggle extends Attack {
    GameHandler gameH;
    public Struggle(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        power = 50;
        accuracy = 100;
        category = "physical";
        type = "Normal";
        priority = 0;
        ap = 1;
        name = "Struggle";
        trifftImmer = false;
        target = "enemy";
    }

}
