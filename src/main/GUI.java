package main;

import java.awt.Color;
import javax.swing.JFrame;

public class GUI {
    public boolean fullscreen;
    private int width;
    private int height;

    public GUI(boolean fullscreen, int width, int height) {
        this.fullscreen = fullscreen;
        this.width = width;
        this.height = height;
    }

    public void openWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fabimon");
        frame.getContentPane().setBackground(new Color(34, 139, 34)); // set background color to green

        if (fullscreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximize the window
        } else {
            frame.setSize(width, height); // set window size to height x width
            frame.setLocationRelativeTo(null); // center the window
        }

        frame.setVisible(true);
    }
}
