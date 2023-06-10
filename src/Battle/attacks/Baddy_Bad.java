package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Baddy_Bad extends Attack {
    GameHandler gameH;
    public Baddy_Bad(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Baddy_Bad");
        power = 90;
        accuracy = 100;
        category = "special";
        type = "Dark";
        priority = 0;
        ap = 15;
        name = "Baddy Bad";
        trifftImmer = false;
        target = "enemy";
    }
}
