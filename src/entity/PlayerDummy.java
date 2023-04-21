package entity;

import main.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerDummy extends Entity{

    public BufferedImage image;
    public int screenX;
    public int screenY;

    public PlayerDummy(GameHandler gameH) {
        super(gameH);
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, screenX, screenY, null);
    }
}
