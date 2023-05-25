package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Absorb extends Attack {
    GameHandler gameH;

    public Absorb(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Absorb");
        category = "special";
        type = "Grass";
        power = 20;
        accuracy = 100;
        ap = 25;
        currentap = ap;
        priority = 0;
        name = "Absorb";
        trifftImmer = false;
        target = "enemy";

    }
}
