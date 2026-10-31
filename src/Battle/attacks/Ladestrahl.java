package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Ladestrahl extends Attack {
    GameHandler gameH;

    public Ladestrahl(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Ladestrahl");
        category = "special";
        type = "Electric";
        power = 50;
        accuracy = 90;
        ap = 10;
        currentap = ap;
        priority = 0;
        name = "Ladestrahl";
        trifftImmer = false;
        target = "enemy";

    }
}