package main;

import java.awt.*;
import javax.swing.*;

import main.KeyHandler;

public class GUI {
    public boolean fullscreen;
    private int width;
    private int height;
    private Graphics graphics;
    ImageHandler imageH = new ImageHandler();
    KeyHandler keyH = new KeyHandler();
    JFrame frame = new JFrame();

    public GUI(boolean fullscreen, int width, int height) {
        this.fullscreen = fullscreen;
        this.width = width;
        this.height = height;
    }

    public void openWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fabimon");
        frame.getContentPane().setBackground(new Color(25, 100, 46)); //установить цвет фона на зеленый set background color to green
        imageH.ImageInitialiser(0, "main","Fabimon_Icon_Main", "png");
        frame.setIconImage(imageH.image[0]);
        if (fullscreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //развернуть окно maximize the window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Уже здесь Already there
            frame.setUndecorated(true); //<-- здесь убрана строка заголовка <-- the title bar is removed here
        } else {
            frame.setSize(width, height); //установить размер окна на высоту x ширину set window size to height x width
            frame.setLocationRelativeTo(null); //центр окна center the window
        }
        frame.setVisible(true);
        //получить кадр get frame
        graphics = frame.getGraphics();
    }

    public Graphics getFrameStata() {
        return graphics;
    }

    public JFrame getFrame() {
        return frame;
    }

}
