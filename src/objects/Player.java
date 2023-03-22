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
    private boolean imageSwitch = false;
    ImageHandler imageH = new ImageHandler();

    public Player(int x, int y, int speed, int tile_size) {
        //Загрузить изображения Load images
        imageH.ImageInitialiser(1, "player","Skully_up", "png");
        imageH.ImageInitialiser(2, "player","Skully_down", "png");
        imageH.ImageInitialiser(3, "player","Skully_left", "png");
        imageH.ImageInitialiser(4, "player","Skully_right", "png");
        imageH.ImageInitialiser(5, "player","Skully_up_2", "png");
        imageH.ImageInitialiser(6, "player","Skully_down_2", "png");
        imageH.ImageInitialiser(7, "player","Skully_left_2", "png");
        imageH.ImageInitialiser(8, "player","Skully_right_2", "png");

        //Исходное положение Initial position
        this.pos_x = x;
        this.pos_y = y;
        this.speed = speed;
        this.tile_size = tile_size;
    }

    public void update(KeyHandler keyH) {
        //Перемещение игрока на основе ввода клавиш Move player based on key input
        if(keyH.wPressed == true || keyH.sPressed == true || keyH.aPressed == true || keyH.dPressed == true) {
            imageSwitch = !imageSwitch;
            if (keyH.wPressed) {
                this.pos_y -= speed;
                if(imageSwitch) {
                    this.imageIndex = 1;
                } else {
                    this.imageIndex = 5;
                }

            }
            if (keyH.sPressed) {
                this.pos_y += speed;
                if(imageSwitch) {
                    this.imageIndex = 2;
                } else {
                    this.imageIndex = 6;
                }
            }
            if (keyH.aPressed) {
                this.pos_x -= speed;
                if(imageSwitch) {
                    this.imageIndex = 3;
                } else {
                    this.imageIndex = 7;
                }
            }
            if (keyH.dPressed) {
                this.pos_x += speed;
                if(imageSwitch) {
                    this.imageIndex = 4;
                } else {
                    this.imageIndex = 8;
                }
            } else {
                this.imageIndex = imageIndex;
            }
        }
    }

    public void draw(Graphics g) {
        //Нарисуйте изображение игрока на основе движения Draw player image based on movement
        g.clearRect(pos_x, pos_y, this.tile_size, this.tile_size);
        g.drawImage(this.imageH.image[this.imageIndex], this.pos_x, this.pos_y, this.tile_size,this.tile_size,null);
        //g.setColor(Color.RED);
        //g.fillRect(this.pos_x, this.pos_y, 96, 96);
    }
}
