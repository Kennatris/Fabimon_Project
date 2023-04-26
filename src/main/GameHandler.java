package main;

import entity.Entity;
import entity.Player;
import entity.PlayerDummy;
import main.control.KeyHandler;
import objects.SuperObject;
import settings.SaveCompiler;
import settings.Settings;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GameHandler extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    // SCREEN SETTINGS
    final int originalTileSize = 96; // 96x96 tile
    final int scale = 1;

    public final int tileSize = originalTileSize * scale; // 96x96 tile scale (zoom)
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol; // 96 x 20 = 1920
    public int screenHeight = tileSize * maxScreenRow; // 96 x 12 = 1152 (1080++)

    // WORLD SETTINGS
    public final int worldColumns = 50;
    public final int worldRows = 50;
    public String[] availableMaps = {
            "map_test_1", // normalWorld
            "",           // 2Map
            "",           // 3Map
            "arenaWorld"  // arenaWorld
    };
    public String map = availableMaps[0];
    public int mapType = 0;
    public String[] fileIndex = {"save_one", "save_two", "save_three"};
    public String save = fileIndex[0];
    public int playerStandardValueX = 25;
    public int playerStandardValueY = 25;
    public boolean fullscreen;
    public boolean keyboard = true;
    public float musicVolume;
    public float soundVolume;

    // random Vars
    public boolean debugMode = true;
    public boolean unsavedSetting;
    // FPS
    int FPS = 60;
    public int time, seconds, minutes, hour;
    public int speed_increased = 0;

    // SYSTEM
    TileManager tileM = new TileManager(this, map);
    public CutsceneManager csManager = new CutsceneManager(this);
    public KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    GUI myGUI;
    SaveCompiler saveC = new SaveCompiler();
    Settings settings = new Settings();

    // ENTITY AND OBJECT
    public Player player;
    public PlayerDummy playerD = new PlayerDummy(this);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];
    public int  npcBattle;

    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int saveState = 4;
    public final int settingState = 5;
    public final int battleState = 6;

    public GameHandler() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame() {
        // initializer
        saveC.SaveReader(this, save);
        myGUI = new GUI(fullscreen, screenWidth, screenHeight);

        // open and config GUI
        if (fullscreen) {
            myGUI.frame.setUndecorated(true);
        }
        myGUI.frame.add(this);
        myGUI.frame.pack();
        myGUI.openWindow();

        player = new Player(this, keyH);

        aSetter.setObject();
        aSetter.setNPC();

        //playMusic(0);

        gameState = titleState;
    }

    public void reSetupGame() {
        reStartWindow();
    }

    public void reStartWindow() {
        // close old Window
        myGUI.closeWindow();
        myGUI = null;

        // open new Window
        myGUI = new GUI(fullscreen, screenWidth, screenHeight);
        if (fullscreen) {
            myGUI.frame.setUndecorated(true); // remove title bar
        }
        myGUI.frame.add(this);
        myGUI.frame.pack();
        myGUI.openWindow();
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; // 0.01666666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // 1 UPDATE: update information such as character positions
                update();

                // 2 DRAW: draw the screen with the updated information
                repaint();

                delta--;

                time++;
            }

            if (timer >= 1000000000) {
                timer = 0;
            }

        }

    }

    public void update() {

        // DEBUG MODE
        if (keyH.hPressed) {
            debugMode = !debugMode;
            System.out.println("DebugMode: " + debugMode);

            keyH.hPressed = false;
        }
        if (debugMode) {
            if(keyH.kPressed) {
                gameState = battleState;
            }
            if(keyH.shiftPressed) {
                if (speed_increased == 0) {
                    player.speed = 8;
                    System.out.println("Speed: " + player.speed);
                }
                speed_increased = 1;
            }

            if(!keyH.shiftPressed) {
                if (speed_increased == 1) {
                    player.speed = 4;
                    System.out.println("Speed: " + player.speed);
                }
                speed_increased = 0;
            }
        }

        // time
        if (time == 60){
            time = 0;
            seconds++;
            if (debugMode) {
                System.out.println("The system runs: " + seconds + " seconds!");
            }
        }
        if (seconds == 60) {
            seconds = 0;
            minutes ++;
            if (minutes % 2 == 0) {
                saveC.SaveWriter(this, save);
            }
            if (debugMode) {
                System.out.println("The system runs: " + minutes + " minutes!");
            }
        }
        if (minutes == 60) {
            minutes = 0;
            hour++;
        }

        // fullscreen
        if (keyH.f12Pressed) {
            fullscreen = !fullscreen;
            reStartWindow();
            player.screenX = myGUI.frame.getWidth()/2 - (tileSize/2);
            player.screenY = myGUI.frame.getHeight()/2 - (tileSize/2);

            keyH.f12Pressed = false;
        }

        if (gameState == playState) {

            //NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }

            // PLAYER
            player.update();



            if (debugMode) {

            }

        }
        if (gameState == pauseState) {
            // do-nothing
        }
        if (gameState == titleState) {

            // SELECTION
            // MOVE CURSOR
            if (keyH.wPressed == true || keyH.sPressed == true || keyH.upPressed == true || keyH.downPressed == true) {

                if (keyH.wPressed == true || keyH.upPressed == true) {
                    switch (ui.commandNum) {

                        case 0:
                            ui.commandNum = 3;
                            break;
                        case 1:
                            ui.commandNum = 0;
                            break;
                        case 2:
                            ui.commandNum = 1;
                            break;
                        case 3:
                            ui.commandNum = 2;
                            break;

                    }

                    keyH.wPressed = false;
                    keyH.upPressed = false;

                } else if (keyH.sPressed == true || keyH.downPressed == true) {
                    switch (ui.commandNum) {

                        case 0:
                            ui.commandNum = 1;
                            break;
                        case 1:
                            ui.commandNum = 2;
                            break;
                        case 2:
                            ui.commandNum = 3;
                            break;
                        case 3:
                            ui.commandNum = 0;
                            break;

                    }

                    keyH.sPressed = false;
                    keyH.downPressed = false;
                }
            }
            // SELECT
                if (keyH.spacePressed == true || keyH.enterPressed == true) {

                    switch (ui.commandNum) {

                        case 0: // load save
                            gameState = saveState;
                            break;
                        case 1: // load game
                            gameState = playState;
                            break;
                        case 2: // menu
                            gameState = settingState;
                            break;
                        case 3: // quit
                            System.exit(0);
                            break;
                    }

                    ui.commandNum = 0;
                    keyH.spacePressed = false;
                    keyH.enterPressed = false;
            }
        } // Bindings for gameState

        if (gameState == settingState) {
            // SELECTION
            // MOVE CURSOR
            if (keyH.wPressed == true || keyH.sPressed == true || keyH.upPressed == true || keyH.downPressed == true) {

                switch (ui.settingScreenValue) {
                    case 0:
                        if (keyH.wPressed == true || keyH.upPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 3;
                                    break;
                                case 1:
                                    ui.commandNum = 0;
                                    break;
                                case 2:
                                    ui.commandNum = 1;
                                    break;
                                case 3:
                                    ui.commandNum = 2;
                                    break;

                            }

                            keyH.wPressed = false;
                            keyH.upPressed = false;

                        } else if (keyH.sPressed == true || keyH.downPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 1;
                                    break;
                                case 1:
                                    ui.commandNum = 2;
                                    break;
                                case 2:
                                    ui.commandNum = 3;
                                    break;
                                case 3:
                                    ui.commandNum = 0;
                                    break;

                            }

                            keyH.sPressed = false;
                            keyH.downPressed = false;
                        }
                        break;
                    case 1:
                        if (keyH.wPressed == true || keyH.upPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 3;
                                    break;
                                case 3:
                                    ui.commandNum = 0;
                                    break;

                            }

                            keyH.wPressed = false;
                            keyH.upPressed = false;

                        } else if (keyH.sPressed == true || keyH.downPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 3;
                                    break;
                                case 3:
                                    ui.commandNum = 0;
                                    break;

                            }

                            keyH.sPressed = false;
                            keyH.downPressed = false;
                        }
                        break;
                    case 2:
                        if (keyH.wPressed == true || keyH.upPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 2;
                                    break;
                                case 1:
                                    ui.commandNum = 0;
                                    break;
                                case 2:
                                    ui.commandNum = 1;
                                    break;

                            }

                            keyH.wPressed = false;
                            keyH.upPressed = false;

                        } else if (keyH.sPressed == true || keyH.downPressed == true) {
                            switch (ui.commandNum) {

                                case 0:
                                    ui.commandNum = 1;
                                    break;
                                case 1:
                                    ui.commandNum = 2;
                                    break;
                                case 2:
                                    ui.commandNum = 0;
                                    break;

                            }

                            keyH.sPressed = false;
                            keyH.downPressed = false;
                        }
                        break;
                }

            }

            switch (ui.settingScreenValue) {
                case 0:
                    // SELECT
                    if (keyH.spacePressed == true || keyH.enterPressed == true) {
                        switch (ui.commandNum) {
                            case 0: // Video
                                ui.settingScreenValue = 1;
                                ui.commandNum = 0;
                                break;
                            case 1: // Music
                                ui.settingScreenValue = 2;
                                ui.commandNum = 0;
                                break;
                            case 2: // Controller / Keyboard
                                keyboard = !keyboard;
                                unsavedSetting = true;
                                break;
                            case 3:
                                gameState = titleState;
                                ui.commandNum = 0;
                                unsavedSetting = false;
                                settings.uploadSettings(this); // SETTINGS
                                saveC.SaveWriter(this,save);
                                break;
                        }

                        keyH.spacePressed = false;
                        keyH.enterPressed = false;
                    }

                    if (keyH.leftPressed == true || keyH.rightPressed == true || keyH.aPressed == true || keyH.dPressed == true) {
                        if (ui.commandNum == 2) {
                            unsavedSetting = true;
                            keyboard = !keyboard;
                        }

                        keyH.aPressed = false;
                        keyH.dPressed = false;
                        keyH.leftPressed = false;
                        keyH.rightPressed = false;
                    }
                    break;
                case 1: // Video
                    if (keyH.spacePressed == true || keyH.enterPressed == true) {
                        switch (ui.commandNum) {
                            case 0: // fullscreen
                                fullscreen = !fullscreen;
                                reStartWindow();
                                unsavedSetting = true;
                                break;
                            case 1: // empty
                                break;
                            case 2: // empty
                                break;
                            case 3:
                                ui.settingScreenValue = 0;
                                break;
                        }

                        ui.commandNum = 0;
                        keyH.spacePressed = false;
                        keyH.enterPressed = false;
                    }
                    break;
                case 2: // Sound
                    if (keyH.spacePressed == true || keyH.enterPressed == true) {
                        switch (ui.commandNum) {
                            case 0: // musicVolume
                                break;
                            case 1: // soundVolume
                                break;
                            case 2: // back
                                ui.settingScreenValue = 0;
                                break;
                        }

                        ui.commandNum = 0;
                        keyH.spacePressed = false;
                        keyH.enterPressed = false;
                    }

                    if (keyH.leftPressed == true || keyH.rightPressed == true || keyH.aPressed == true || keyH.dPressed == true) {
                        switch (ui.commandNum) {
                            case 0:
                                if ((keyH.aPressed == true || keyH.leftPressed == true) && musicVolume > 0f) {
                                    musicVolume = musicVolume - 0.1f;
                                } else if ((keyH.dPressed == true || keyH.rightPressed == true) && musicVolume < 2f) {
                                    musicVolume = musicVolume + 0.1f;
                                }
                                break;
                            case 1:
                                if ((keyH.aPressed == true || keyH.leftPressed == true) && soundVolume > 0f) {
                                    soundVolume = soundVolume - 0.1f;
                                } else if ((keyH.dPressed == true || keyH.rightPressed == true) && soundVolume < 2f) {
                                    soundVolume = soundVolume + 0.1f;
                                }
                                break;
                        }

                        unsavedSetting = true;
                        keyH.leftPressed = false;
                        keyH.rightPressed = false;
                    }
                    break;

            }
        }

        if (gameState == saveState) {
            // SELECTION
            // MOVE CURSOR
            if (keyH.wPressed == true || keyH.sPressed == true || keyH.upPressed == true || keyH.downPressed == true) {

                if (keyH.wPressed == true || keyH.upPressed == true) {
                    switch (ui.commandNum) {

                        case 0:
                            ui.commandNum = 3;
                            break;
                        case 1:
                            ui.commandNum = 0;
                            break;
                        case 2:
                            ui.commandNum = 1;
                            break;
                        case 3:
                            ui.commandNum = 2;
                            break;

                    }

                    keyH.wPressed = false;
                    keyH.upPressed = false;

                } else if (keyH.sPressed == true || keyH.downPressed == true) {
                    switch (ui.commandNum) {

                        case 0:
                            ui.commandNum = 1;
                            break;
                        case 1:
                            ui.commandNum = 2;
                            break;
                        case 2:
                            ui.commandNum = 3;
                            break;
                        case 3:
                            ui.commandNum = 0;
                            break;
                    }

                    keyH.sPressed = false;
                    keyH.downPressed = false;
                }
            }
            // SELECT
            if (keyH.spacePressed == true || keyH.enterPressed == true) {

                switch (ui.commandNum) {

                    case 0: // save_one
                        save = fileIndex[0];
                        unsavedSetting = true;
                        break;
                    case 1: // save_two
                        save = fileIndex[1];
                        unsavedSetting = true;
                        break;
                    case 2: // save_three
                        save = fileIndex[2];
                        unsavedSetting = true;
                        break;
                    case 3: // back
                        if (unsavedSetting) {
                            unsavedSetting = false;
                            saveC.SaveReader(this, save);
                            reStartWindow();
                        }
                        gameState = titleState;
                        ui.commandNum = 0;
                        break;
                }

                keyH.spacePressed = false;
                keyH.enterPressed = false;
            }
        }// Bindings for gameState

        if(gameState == battleState){
            if(keyH.upPressed || keyH.wPressed || keyH.downPressed || keyH.sPressed ||
               keyH.rightPressed || keyH.dPressed || keyH.leftPressed || keyH.aPressed){

                if(keyH.upPressed || keyH.wPressed){
                    switch(ui.commandNum){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2: ui.commandNum = 0;
                            break;
                        case 3: ui.commandNum = 1;
                            break;
                    }
                } else if (keyH.downPressed || keyH.sPressed){
                    switch(ui.commandNum){
                        case 0: ui.commandNum = 2;
                            break;
                        case 1: ui.commandNum = 3;
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                }else if(keyH.rightPressed || keyH.dPressed){
                    switch(ui.commandNum){
                        case 0: ui.commandNum = 1;
                            break;
                        case 1:
                            break;
                        case 2: ui.commandNum = 3;
                            break;
                        case 3:
                            break;
                    }
                }else if(keyH.leftPressed || keyH.aPressed){
                    switch(ui.commandNum) {
                        case 0:

                            break;
                        case 1:
                            ui.commandNum = 0;
                            break;
                        case 2:
                            break;
                        case 3: ui.commandNum = 2;
                            break;
                    }
                }
            }else if (keyH.enterPressed || keyH.spacePressed){
                switch(ui.commandNum) {
                    case 0: ui.battleText = "Fight";
                        break;
                    case 1: ui.battleText = "Fabimon";
                        break;
                    case 2: ui.battleText = "Bag";
                        break;
                    case 3: npc[npcBattle].endBattle(npcBattle);
                        break;
                }
            }
        }// Bindings for battleState
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // TITLE SCREEN
        if (gameState == titleState || gameState == settingState) {
            ui.draw(g2);
        }

        // OTHERS
        else {
            // TILE
            tileM.draw(g2);

            // OBJECT
            for(int i = 0; i < obj.length; i++) {
                if(obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //NPC
            for(int i = 0; i<npc.length; i++){
                if(npc[i] != null){
                    npc[i].draw(g2);
                }
            }
            //Cutscene
            csManager.draw(g2);

            // PLAYER
            player.draw(g2);



            // UI
            ui.draw(g2);
        }

        g2.dispose();
    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();

    }

    public void stopMusic() {

        music.stop();

    }

    public void playSE(int i) {

        se.setFile(i);
        se.play();

    }

}