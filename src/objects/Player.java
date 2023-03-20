package objects;

import main.GameHandler;
import main.ImageHandler;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    private ImageHandler imageHandler;
    private int imageIndex = 2;
    ImageHandler imageH = new ImageHandler();
    public Player(int x, int y, int speed, int tile_size) {
        // Load images
        imageH.ImageInitialiser(1, "player","Skully_up", "png");
        imageH.ImageInitialiser(2, "player","Skully_down", "png");
        imageH.ImageInitialiser(3, "player","Skully_left", "png");
        imageH.ImageInitialiser(4, "player","Skully_right", "png");

        // Initial position
        this.pos_x = x;
        this.pos_y = y;
        this.speed = speed;
        this.tile_size = tile_size;
    }

    public void update(KeyHandler keyH) {
        // Move player based on key input
        if(keyH.wPressed == true || keyH.sPressed == true || keyH.aPressed == true || keyH.dPressed == true) {
            if (keyH.wPressed) {
                this.pos_y -= speed;
                this.imageIndex = 1;
            }
            if (keyH.sPressed) {
                this.pos_y += speed;
                this.imageIndex = 2;
            }
            if (keyH.aPressed) {
                this.pos_x -= speed;
                this.imageIndex = 3;
            }
            if (keyH.dPressed) {
                this.pos_x += speed;
                this.imageIndex = 4;
            } else {
                this.imageIndex = imageIndex;
            }
        }
    }

    public void draw(Graphics g) {
        // Draw player image based on movement

        g.drawImage(this.imageH.image[this.imageIndex], this.pos_x, this.pos_y, this.tile_size,this.tile_size,null);

        //g.setColor(Color.RED);
        //g.fillRect(this.pos_x, this.pos_y, 96, 96);
    }
}
