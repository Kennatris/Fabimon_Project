package settings;

import main.GameHandler;

public class Settings {
    
    // Initializing
    GameHandler gameH;
    // all saved Variables
    public int[][] savedInt = new int[999][20];
    public boolean[][] savedBoolean = new boolean[999][20];
    public float[][] savedFloat = new float[999][20];
    public String[][] savedString = new String[999][20];
    public int[][] unsavedInt = new int[999][20];
    public boolean[][] unsavedBoolean = new boolean[999][20];
    public float[][] unsavedFloat = new float[999][20];
    public String[][] unsavedString = new String[999][20];
    public int entitySavableINT = 9; // how many Vars are getting saved from each entity
    public int entitySavableBOOLEAN = 0; // how many Vars are getting saved from each entity
    public int entitySavableSTRING = 0; // how many Vars are getting saved from each entity
    public int entitySavableFLOAT = 0; // how many Vars are getting saved from each entity
    public int systemSavable = 7; // how many System Settings are getting saved

    public void installSettings(GameHandler gameH, boolean[][] unsavedBoolean, int[][] unsavedInt, float[][] unsavedFloat, String[][] unsavedString) {
        // CLASSES
        this.gameH = gameH;

        // SAVE VARS
        this.savedBoolean[0][0] = unsavedBoolean[0][0]; // fullscreen
        if (gameH.debugMode) {
            System.out.println("Fullscreen Saved: "  + unsavedBoolean[0][0]);
        }
        this.savedInt[0][0] = unsavedInt[0][0]; // screen Width
        if (gameH.debugMode) {
            System.out.println("Screen Width Saved: "  + unsavedInt[0][0]);
        }
        this.savedInt[0][1] = unsavedInt[0][1]; // screen Height
        if (gameH.debugMode) {
            System.out.println("Screen Height Saved: "  + unsavedInt[0][1]);
        }
        this.savedInt[0][2] = unsavedInt[0][2]; // Player Position X
        if (gameH.debugMode) {
            System.out.println("Player Position X Saved: "  + unsavedInt[0][2]);
        }
        this.savedInt[0][3] = unsavedInt[0][3]; // Player Position Y
        if (gameH.debugMode) {
            System.out.println("Player Position Y Saved: "  + unsavedInt[0][3]);
        }
        this.savedBoolean[0][1] = unsavedBoolean[0][1]; // Keyboard
        if (gameH.debugMode) {
            System.out.println("Keyboard: "  + unsavedBoolean[0][1]);
        }
        this.savedFloat[0][0] = unsavedFloat[0][0]; // Music Volume
        if (gameH.debugMode) {
            System.out.println("Music Volume Saved: "  + unsavedFloat[0][0]);
        }
        this.savedFloat[0][1] = unsavedFloat[0][1]; // Sound Volume
        if (gameH.debugMode) {
            System.out.println("Sound Volume Saved: "  + unsavedFloat[0][1]);
        }

        for (int i = 0; i < gameH.npc.length; i++) {
            if (gameH.npc[i] != null) {
                for (int j = 0; j < entitySavableINT; j++) {
                    this.savedInt[i+1][j] = unsavedInt[i+1][j];
                    if (gameH.debugMode) {
                        System.out.println("[" + i + "]" + " " + "[" + j + "]" + " = " + this.savedInt[i+1][j]);
                    }
                }
                for (int j = 0; j < entitySavableBOOLEAN; j++) {
                    this.savedBoolean[i+1][j] = unsavedBoolean[i][j];
                    if (gameH.debugMode) {
                        System.out.println("[" + i + "]" + " " + "[" + j + "]" + " = " + this.savedBoolean[i+1][j]);
                    }
                }
                for (int j = 0; j < entitySavableSTRING; j++) {
                    this.savedString[i+1][j] = unsavedString[i][j];
                    if (gameH.debugMode) {
                        System.out.println("[" + i + "]" + " " + "[" + j + "]" + " = " + this.savedString[i+1][j]);
                    }
                }
                for (int j = 0; j < entitySavableFLOAT; j++) {
                    this.savedFloat[i+1][j] = unsavedFloat[i][j];
                    if (gameH.debugMode) {
                        System.out.println("[" + i + "]" + " " + "[" + j + "]" + " = " + this.savedFloat[i+1][j]);
                    }
                }
            }
        }
        /*
        for (int i = 0; i < gameH.npc.length; i++) {
            if (gameH.npc[i] != null) {
                for (int j = 0; j < entitySavableINT; i ++) {
                    this.savedInt[i+1][j] = unsavedInt[i][j];
                }
                for (int j = 0; j < entitySavableBOOLEAN; i++) {
                    this.savedBoolean[i+1][j] = unsavedBoolean[i][j];
                }
                for (int j = 0; j < entitySavableSTRING; i++) {
                    this.savedString[i+1][j] = unsavedString[i][j];
                }
                for (int j = 0; j < entitySavableFLOAT; i++) {
                    this.savedFloat[i+1][j] = unsavedFloat[i][j];
                }
            }
        }
        */
        uploadSettings(this.gameH);

    }

    public void uploadSettings(GameHandler gameH) {

        this.gameH = gameH;

        // SYSTEM
        gameH.fullscreen = savedBoolean[0][0];
        gameH.screenWidth = savedInt[0][0];
        gameH.screenHeight = savedInt[0][1];
        if (gameH.player != null) {
            gameH.player.worldX = savedInt[0][2] * gameH.tileSize;
            gameH.player.worldY = savedInt[0][3] * gameH.tileSize;
        } else {
            gameH.playerStandardValueX = savedInt[0][2] * gameH.tileSize;
            gameH.playerStandardValueY = savedInt[0][3] * gameH.tileSize;
        }
        gameH.keyboard = savedBoolean[0][1];
        gameH.musicVolume = savedFloat[0][0];
        gameH.soundVolume = savedFloat[0][1];

        // NPC SHIT = FABIO SHIT
        for (int i = 0; i < gameH.npc.length; i++) {
            if (gameH.npc[i] != null) {
                for (int j = 0; j < entitySavableINT; j++) {
                    //unsavedInt[i+1][j];
                }
                for (int j = 0; j < entitySavableBOOLEAN; j++) {
                    //unsavedBoolean[i+1][j];
                }
                for (int j = 0; j < entitySavableFLOAT; j++) {
                    //unsavedFloat[i+1][j];
                }
                for (int j = 0; j < entitySavableSTRING; j++) {
                    //unsavedString[i+1][j];
                }
            }
        }
    }
}
