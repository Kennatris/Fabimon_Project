package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Bouncy_Bubble extends Attack {
    GameHandler gameH;
    public Bouncy_Bubble(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Bouncy_Bubble");
        power = 90;
        accuracy = 100;
        category = "special";
        type = "Water";
        priority = 0;
        ap = 15;
        name = "Bouncy Bubble";
        trifftImmer = false;
        target = "enemy";
    }
}
