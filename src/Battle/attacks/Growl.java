package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Growl extends Attack {
    GameHandler gameH;
    public Growl(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Growl");
        category = "status";
        type = "Normal";
        accuracy = 100;
        ap = 40;
        priority = 0;
        name = "growl";
        trifftImmer = false;
        target = "enemy";
        effect[6] = 0;
        effect[5] = 0;
        effect[4] = 0;
        effect[3] = 0;
        effect[2] = -1;
        effect[1] = 0;
        effect[0] = 0;
    }
}
