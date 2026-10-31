package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Armor_Cannon extends Attack {
    GameHandler gameH;
    public Armor_Cannon(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Armor_Cannon");
        power = 120;
        accuracy = 100;
        category = "special";
        type = "Fire";
        priority = 0;
        ap = 5;
        name = "Armor Cannon";
        trifftImmer = false;
        target = "enemy";
    }
}
