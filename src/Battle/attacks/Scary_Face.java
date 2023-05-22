package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Scary_Face extends Attack {
    GameHandler gameH;
    public Scary_Face(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Scary_Face");
        category = "status";
        accuracy = 100;
        ap = 10;
        type = "Normal";
        priority = 0;
        name = "Scary_face";
        trifftImmer = false;
        target = "enemy";
        effect[6] = -2;
        effect[5] = 0;
        effect[4] = 0;
        effect[3] = 0;
        effect[2] = 0;
        effect[1] = 0;
        effect[0] = 0;
    }
}
