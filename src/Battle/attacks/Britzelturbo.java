package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Britzelturbo extends Attack {
    GameHandler gameH;

    public Britzelturbo(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Britzelturbo");
        category = "special";
        type = "Electric";
        power = 80;
        accuracy = 100;
        ap = 10;
        currentap = ap;
        priority = 0;
        name = "Britzelturbo";
        trifftImmer = false;
        target = "enemy";

    }
}