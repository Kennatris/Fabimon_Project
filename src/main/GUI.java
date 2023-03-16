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
        frame.getContentPane().setBackground(new Color(214, 72, 217)); // set background color to green

        if (fullscreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximize the window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
            frame.setUndecorated(true); // <-- the title bar is removed here
        } else {
            frame.setSize(width, height); // set window size to height x width
            frame.setLocationRelativeTo(null); // center the window
        }

        frame.setVisible(true);
    }
}
