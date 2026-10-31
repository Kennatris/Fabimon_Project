package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Blast_Burn extends Attack {
    GameHandler gameH;
    public Blast_Burn(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Blast_Burn");
        power = 150;
        accuracy = 90;
        category = "special";
        type = "Fire";
        priority = 0;
        ap = 5;
        name = "Blast Burn";
        trifftImmer = false;
        target = "enemy";
    }
}
