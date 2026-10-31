package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Donner extends Attack {
    GameHandler gameH;

    public Donner(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Donner");
        category = "special";
        type = "Electric";
        power = 110;
        accuracy = 70;
        ap = 10;
        currentap = ap;
        priority = 0;
        name = "Donner";
        trifftImmer = false;
        target = "enemy";

    }
}