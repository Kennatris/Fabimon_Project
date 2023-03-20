package main;


import objects.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameHandler {
    public long timer = 0;
    // settings
    int FPS = 60;
    final int tile_size = 96;
    int start_x;
    int start_y;
    int start_speed;

    boolean fullscreen = false;
    private Graphics graphics;
    private Graphics2D g2D;
    // Integration
    KeyHandler keyH = new KeyHandler();
    Kontroller kontroller = new Kontroller();
    //Player player = new Player(start_x, start_y, start_speed, tile_size);
    Player player = new Player(0, 0, 3, tile_size);
    // start the code
    public void start_setup() {
        // open a new Instance of GUI
        GUI myGUI = new GUI(fullscreen, 1152, 576);
        myGUI.openWindow();
        myGUI.getFrame().addKeyListener(keyH);
        myGUI.getFrame().setFocusable(true);
        graphics = myGUI.getFrameStata();
        g2D = (Graphics2D) graphics;
        // initialising Controller
        // kontroller.VerbindeKontroller();
        // starts the internal Delta-Timer ()
        delta_timer(myGUI);
        saveSettings();
    }

    public void delta_timer(GUI myGUI) {
        double drawInterval = 1000000000 / FPS; // 0.01666666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (myGUI != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // code to update stuff
                // ...

                update();
                delta--;
            }

        }
    }

    public void update() {

            // kontroller.KontrollerCheck();

            // player stuff
            player.update(keyH);

            repaint();


    }

    public void repaint() {
        // Player
        player.draw(g2D);
    }
    public void saveSettings() {

    }
}