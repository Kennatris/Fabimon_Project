package main;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private boolean fullscreen;
    private int width;
    private int height;
    Graphics graphics;
    ImageHandler imageH = new ImageHandler();
    JFrame frame = new JFrame();

    public GUI(boolean fullscreen, int width, int height) {
        this.fullscreen = fullscreen;
        this.width = width;
        this.height = height;
    }

    public void openWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fabimon");
        frame.getContentPane().setBackground(new Color(255, 255, 255)); // set background color to green
        imageH.ImageInitializer(0, "tiles","PLACEHOLDER", "png", 250, 250);
        frame.setIconImage(imageH.image[0]);
        if (fullscreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximize the window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        } else {
            frame.setSize(width, height); // set window size to height x width
            frame.setLocationRelativeTo(null); // center the window
        }
        frame.setVisible(true);
        // get frame
        graphics = frame.getGraphics();
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

}
