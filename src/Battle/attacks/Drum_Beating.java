package Battle.attacks;

import Battle.Attack;
import main.GameHandler;

public class Drum_Beating extends Attack {
    GameHandler gameH;
    public Drum_Beating(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;
        getButtonImage("Drum Beating");
        power = 80;
        accuracy = 100;
        category = "physical";
        type = "Grass";
        priority = 0;
        ap = 10;
        name = "Drum Beating";
        trifftImmer = false;
        target = "enemy";
    }
}
