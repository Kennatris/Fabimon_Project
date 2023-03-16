package objects;

import main.ImageHandler;
import main.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private ImageHandler imageHandler;
    private int imageIndex = 1;
    ImageHandler imageH = new ImageHandler();
    public Player() {
        this.imageHandler = new ImageHandler();
        // Load images
        imageH.ImageInitialiser(1, "player","Skull_up", "png");
        imageH.ImageInitialiser(2, "player","Skull_down", "png");
        imageH.ImageInitialiser(3, "player","Skull_left", "png");
        imageH.ImageInitialiser(4, "player","Skull_right", "png");

        // Initial position
        this.pos_x = 0;
        this.pos_y = 0;
    }

    public void update(KeyHandler keyHandler) {
        // Move player based on key input
        if (keyHandler.wPressed) {
            this.pos_y -= 5;
            this.imageIndex = 1;
        }
        if (keyHandler.sPressed) {
            this.pos_y += 5;
            this.imageIndex = 2;
        }
        if (keyHandler.aPressed) {
            this.pos_x -= 5;
            this.imageIndex = 3;
        }
        if (keyHandler.dPressed) {
            this.pos_x += 5;
            this.imageIndex = 4;
        }
    }

    public void draw(Graphics g) {
        // Draw player image based on movement
        g.drawImage(this.imageHandler.image[this.imageIndex], this.pos_x, this.pos_y, null);
    }
}
