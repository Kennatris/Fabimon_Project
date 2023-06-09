package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Aqua_Tail extends Attack {
    GameHandler gameH;
    public Aqua_Tail(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Aqua Tail");
        power = 90;
        accuracy = 90;
        category = "physical";
        type = "Water";
        priority = 0;
        ap = 10;
        name = "Aqua Tail";
        trifftImmer = false;
        target = "enemy";
    }
}
