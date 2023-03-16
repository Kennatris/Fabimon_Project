package main;

import java.awt.event.KeyEvent;
import java.security.Key;

public class GameHandler {
    // var_delta-timer
    private int FPS = 60;
    public long timer = 0;
    // Integration
    KeyHandler keyH = new KeyHandler();

    // start the code
    public void start_setup() {
            // open a new Instance of GUI
            GUI myGUI = new GUI(false, 1152, 576);
            myGUI.openWindow();

            // starts the internal Delta-Timer ()
            delta_timer(myGUI);
    }

    public void delta_timer(GUI myGUI) {
        double drawInterval = 1000000000/FPS; // 0.01666666 seconds
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

    }
}