package main;

public class settings extends GameHandler{
    GameHandler gameH;
    private int FPS;
    private boolean fullscreen;
    private int pos_x;
    private int pos_y;
    private int speed;
    public settings() {
        this.FPS = gameH.FPS;
        this.fullscreen = gameH.fullscreen;
        this.pos_x = gameH.start_x;
        this.pos_y = gameH.start_y;
        this.speed = gameH.start_speed;
    }

    public void saveSettings() {

    }
}


