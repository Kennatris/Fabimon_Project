package settings;

import entity.Player;
import main.GameHandler;

public class Settings {
    
    // Initializing
    GameHandler gameH;
    Player player;
    // all saved Variables
    public int screenWidth_s, screenHeight_s, playerPosX_s, playerPosY_s;
    public boolean fullscreen_s, keyboard_s;
    public float musicVolume_s, soundVolume_s;
    
    public int savableVARS = 8; // how many Vars are getting saved

    public void installSettings(GameHandler gameH, boolean fullscreen_s, int screenWidth_s, int screenHeight_s, int playerPosX_s, int playerPosY_s, boolean keyboard_s, float musicVolume_s, float soundVolume_s) {
        // CLASSES
        this.gameH = gameH;

        // SAVE VARS
        this.fullscreen_s = fullscreen_s;
        this.screenWidth_s = screenWidth_s;
        this.screenHeight_s = screenHeight_s;
        this.playerPosX_s = playerPosX_s;
        this.playerPosY_s = playerPosY_s;
        this.keyboard_s = keyboard_s;
        this.musicVolume_s = musicVolume_s;
        this.soundVolume_s = soundVolume_s;


        uploadSettings(this.gameH);

    }

    public void uploadSettings(GameHandler gameH) {

        // upload VARS
        gameH.fullscreen = fullscreen_s;
        gameH.screenWidth = screenWidth_s;
        gameH.screenHeight = screenHeight_s;
        gameH.playerPosX = playerPosX_s;
        gameH.playerPosY = playerPosY_s;
        gameH.keyboard = keyboard_s;
        gameH.musicVolume = musicVolume_s;
        gameH.soundVolume = soundVolume_s;

    }

}
