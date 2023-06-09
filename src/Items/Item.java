package Items;

import main.GameHandler;
import main.ImageHandler;

import java.awt.image.BufferedImage;

public class Item {
    public BufferedImage ausgewählt, nausgewählt;
    GameHandler gameH;
    ImageHandler imageH = new ImageHandler();
    public int recover_hp;

    public Item(GameHandler gameH){this.gameH = gameH;

    }
}
