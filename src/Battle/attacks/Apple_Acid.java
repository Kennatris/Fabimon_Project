package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Apple_Acid extends Attack {
    GameHandler gameH;
    public Apple_Acid(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Apple Acid");
        power = 80;
        accuracy = 100;
        category = "special";
        type = "Grass";
        priority = 0;
        ap = 10;
        name = "Apple Acid";
        trifftImmer = false;
        target = "enemy";
    }
}
