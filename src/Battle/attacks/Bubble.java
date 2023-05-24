package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Bubble extends Attack {
    GameHandler gameH;

    public Bubble(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Bubble");
        category = "special";
        type = "Water";
        power = 40;
        accuracy = 100;
        ap = 30;
        currentap = ap;
        priority = 0;
        name = "Bubble";
        trifftImmer = false;
        target = "enemy";

    }
}
