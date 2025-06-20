package main;

import Battle.Attack;
import Battle.Battle;
import entity.Entity;
import entity.Fabimon;
import entity.Player;
import entity.PlayerDummy;
import main.control.KeyHandler;
import objects.SuperObject;
import settings.SaveCompiler;
import settings.Settings;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameHandler extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    // WORLD SETTINGS
    public final int worldColumns = 50;
    public final int worldRows = 50;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int saveState = 4;
    public final int settingState = 5;
    public final int battleState = 6;
    public int battleSubState = 0;
    public final int mainMenu = 0;
    public final int attackMenu = 1;
    public final int itemMenu = 2;
    public final int fabimonMenu = 3;
    public final int cutsceneState = 7;
    // SCREEN SETTINGS
    final int originalTileSize = 96; // 96x96 tile
    public int scale = 1;
    public final int tileSize = originalTileSize * scale; // 96x96 tile scale (zoom)
    public int screenWidth = tileSize * maxScreenCol; // 96 x 20 = 1920
    public int screenHeight = tileSize * maxScreenRow; // 96 x 12 = 1152 (1080++)
    public String[] availableMaps = {"map_test_1", // normalWorld
            "",           // 2Map
            "",           // 3Map
            "arenaWorld"  // arenaWorld
    };
    public String map;
    public int mapType = 0;
    public String[] fileIndex = {"save_one", "save_two", "save_three"};
    public String fileTyp = ".txt";
    public String save = "save_Default";
    public int playerStandardValueX = 25;
    public int playerStandardValueY = 25;
    public boolean fullscreen;
    public boolean keyboard = true;
    public float musicVolume;
    public float soundVolume;
    // random Vars
    public boolean debugMode = true;
    public boolean timerMode = false;
    public boolean unsavedSetting;
    public int bumber = 0;
    public int time, seconds, minutes, hour, tmpTime, tmpWaited;
    public int speed_increased = 0;
    // SYSTEM
    public TileManager tileM = new TileManager(this, map);
    public CutsceneManager csManager = new CutsceneManager(this);
    public KeyHandler keyH = new KeyHandler();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public Battle battle = new Battle(this);

    // ENTITY AND OBJECT
    public Player player;
    public PlayerDummy playerD = new PlayerDummy(this);
    public SuperObject[] obj = new SuperObject[10];
    public Entity[] npc = new Entity[10];
    public int npcInteracted;
    public Fabimon fabimon = new Fabimon(this);
    public Attack attack = new Attack(this);
    public Fabimon own_Fabimon;
    public Fabimon enemy_Fabimon;

    // GAME STATE
    public int gameState;
    // FPS
    int FPS = 60;
    Sound music = new Sound();
    Sound se = new Sound();
    Thread gameThread;
    GUI myGUI;
    SaveCompiler saveC = new SaveCompiler();
    Settings settings = new Settings();

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
        aSetter.setNPC("createNPC");

        //playMusic(0);

        gameState = titleState;
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
            System.out.println("Debug Mode set: " + debugMode);

            keyH.hPressed = false;
        }
        if (debugMode) {
            if (keyH.kPressed) {
                gameState = battleState;
                battleSubState = mainMenu;
                for(int i = 0; i<ui.currentDialogue.length; i++){
                    ui.currentDialogue[i] = "";
                }

                int rand = (int)(Math.random()*4);
                if(rand == 0){
                    fabimon.createFabimon("Feirir", 0, (int)(Math.random() * (101 - 1) + 1));
                    enemy_Fabimon = fabimon.tempFabimon;
                    fabimon.createFabimon("Feirir", 0, (int)(Math.random() * (101 - 1) + 1));
                    player.fabimonTeam[0] = fabimon.tempFabimon;
                    own_Fabimon = player.fabimonTeam[0];
                }else if(rand == 1){
                    fabimon.createFabimon("Feirir", 0, (int)(Math.random() * (101 - 1) + 1));
                    enemy_Fabimon = fabimon.tempFabimon;
                    fabimon.createFabimon("cursed Shiggy", 0, (int)(Math.random() * (101 - 1) + 1));
                    player.fabimonTeam[0] = fabimon.tempFabimon;
                    own_Fabimon = player.fabimonTeam[0];
                }else if(rand == 2){
                    fabimon.createFabimon("cursed Shiggy", 0, (int)(Math.random() * (101 - 1) + 1));
                    enemy_Fabimon = fabimon.tempFabimon;
                    fabimon.createFabimon("cursed Shiggy", 0, (int)(Math.random() * (101 - 1) + 1));
                    player.fabimonTeam[0] = fabimon.tempFabimon;
                    own_Fabimon = player.fabimonTeam[0];
                }else if(rand == 3){
                    fabimon.createFabimon("cursed Shiggy", 0, (int)(Math.random() * (101 - 1) + 1));
                    enemy_Fabimon = fabimon.tempFabimon;
                    fabimon.createFabimon("Feirir", 0, (int)(Math.random() * (101 - 1) + 1));
                    player.fabimonTeam[0] = fabimon.tempFabimon;
                    own_Fabimon = player.fabimonTeam[0];
                }

                    saveC.SaveWriter(this, save);

               }
            if (keyH.tPressed) {
                timerMode = !timerMode;
                keyH.tPressed = false;
                System.out.println("Timer Mode set: " + timerMode);
            }
            if (keyH.shiftPressed) {
                if (speed_increased == 0) {
                    player.speed = 8;
                    System.out.println("Speed set: " + player.speed);
                }
                speed_increased = 1;
            }

            if (!keyH.shiftPressed) {
                if (speed_increased == 1) {
                    player.speed = 4;
                    System.out.println("Speed set: " + player.speed);
                }
                speed_increased = 0;
            }
        }

        // time
        if (time == 60) {
            time = 0;
            seconds++;
            if (debugMode && timerMode) {
                System.out.println("The system runs: " + seconds + " seconds!");
            }
        }
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes % 2 == 0) {
                if (!Objects.equals(save, "save_Default")) {
                    saveC.SaveWriter(this, save);
                }
            }
            if (debugMode && timerMode) {
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
            player.screenX = myGUI.frame.getWidth() / 2 - (tileSize / 2);
            player.screenY = myGUI.frame.getHeight() / 2 - (tileSize / 2);

            if (debugMode) {
                System.out.println("Screen X: " + myGUI.frame.getWidth() + ", Screen Y: " + myGUI.frame.getHeight());
            }

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

            // UPDATE SCREEN SETTINGS
            screenWidth = myGUI.frame.getWidth();
            screenHeight = myGUI.frame.getHeight();

            // pause Screen
            if (keyH.escPressed) {
                gameState = pauseState;
                tmpTime = 30;
                tmpWaited = 0;
            }
        }
        if (gameState == pauseState) {
            if (tmpWaited != tmpTime) {
                tmpWaited++;
            }
            // do-nothing
            if (keyH.wPressed || keyH.sPressed || keyH.upPressed || keyH.downPressed) {

                if (keyH.wPressed || keyH.upPressed) {
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

                } else if (keyH.sPressed || keyH.downPressed) {
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
            }

            // SELECT
            if (keyH.spacePressed || keyH.enterPressed) {
                if (ui.pauseScreenValue == 0) {
                    switch (ui.commandNum) {
                        case 0: // SETTINGS
                            ui.pauseScreenValue = 1;
                            break;
                        case 1: // BACK
                            gameState = playState;
                            break;
                        case 2: // SAVE AND QUIT
                            if (!Objects.equals(save, "save_Default")) {
                                saveC.SaveWriter(this, save);
                            }
                            gameState = titleState;
                            break;
                    }
                } else if (ui.pauseScreenValue == 1) {

                }

                ui.commandNum = 0;
                keyH.spacePressed = false;
                keyH.enterPressed = false;
            }

            // ESC
            if (keyH.escPressed && tmpWaited == tmpTime) {
                gameState = playState;

                ui.commandNum = 0;
                tmpWaited = 0;
                tmpTime = 0;
                keyH.escPressed = false;
            }
        }
        if (gameState == titleState) {

            // SELECTION
            // MOVE CURSOR
            if (keyH.wPressed || keyH.sPressed || keyH.upPressed || keyH.downPressed) {

                if (keyH.wPressed || keyH.upPressed) {
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

                } else if (keyH.sPressed || keyH.downPressed) {
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
            if (keyH.spacePressed || keyH.enterPressed) {

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
            if (keyH.wPressed || keyH.sPressed || keyH.upPressed || keyH.downPressed) {
                playSE(0);
                switch (ui.settingScreenValue) {
                    case 0:
                        if (keyH.wPressed || keyH.upPressed) {
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

                        } else if (keyH.sPressed || keyH.downPressed) {
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
                        if (keyH.wPressed || keyH.upPressed) {
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

                        } else if (keyH.sPressed || keyH.downPressed) {
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
                        if (keyH.wPressed || keyH.upPressed) {
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

                        } else if (keyH.sPressed || keyH.downPressed) {
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
                    if (keyH.spacePressed || keyH.enterPressed) {
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
                                if (!Objects.equals(save, "save_Default")) {
                                    saveC.SaveWriter(this, save); // SETTINGS
                                    saveC.SaveReader(this, save);
                                }
                                break;
                        }

                        keyH.spacePressed = false;
                        keyH.enterPressed = false;
                    }

                    if (keyH.leftPressed || keyH.rightPressed || keyH.aPressed || keyH.dPressed) {
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
                    if (keyH.spacePressed || keyH.enterPressed) {
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
                    if (keyH.spacePressed || keyH.enterPressed) {
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

                    if (keyH.leftPressed || keyH.rightPressed || keyH.aPressed || keyH.dPressed) {
                        switch (ui.commandNum) {
                            case 0:
                                if ((keyH.aPressed || keyH.leftPressed) && musicVolume > 0f) {
                                    musicVolume = musicVolume - 0.1f;
                                } else if ((keyH.dPressed || keyH.rightPressed) && musicVolume < 2f) {
                                    musicVolume = musicVolume + 0.1f;
                                }
                                break;
                            case 1:
                                if ((keyH.aPressed || keyH.leftPressed) && soundVolume > 0f) {
                                    soundVolume = soundVolume - 0.1f;
                                } else if ((keyH.dPressed || keyH.rightPressed) && soundVolume < 2f) {
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
            if (keyH.wPressed || keyH.sPressed || keyH.upPressed || keyH.downPressed) {

                if (keyH.wPressed || keyH.upPressed) {
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

                } else if (keyH.sPressed || keyH.downPressed) {
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
            if (keyH.spacePressed || keyH.enterPressed) {

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
                            player.screenX = myGUI.frame.getWidth() / 2 - (tileSize / 2);
                            player.screenY = myGUI.frame.getHeight() / 2 - (tileSize / 2);
                        }
                        gameState = titleState;
                        ui.commandNum = 0;
                        break;
                }

                keyH.spacePressed = false;
                keyH.enterPressed = false;
            }
        }// Bindings for gameState

        if (gameState == battleState) {
            if (keyH.upPressed || keyH.wPressed || keyH.downPressed || keyH.sPressed || keyH.rightPressed || keyH.dPressed || keyH.leftPressed || keyH.aPressed) {

                if (keyH.upPressed || keyH.wPressed) {
                    switch (ui.commandNum) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            ui.commandNum = 0;
                            break;
                        case 3:
                            ui.commandNum = 1;
                            break;
                    }
                } else if (keyH.downPressed || keyH.sPressed) {
                    switch (ui.commandNum) {
                        case 0:
                            ui.commandNum = 2;
                            break;
                        case 1:
                            ui.commandNum = 3;
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                } else if (keyH.rightPressed || keyH.dPressed) {
                    switch (ui.commandNum) {
                        case 0:
                            ui.commandNum = 1;
                            break;
                        case 1:
                            break;
                        case 2:
                            ui.commandNum = 3;
                            break;
                        case 3:
                            break;
                    }
                } else if (keyH.leftPressed || keyH.aPressed) {
                    switch (ui.commandNum) {
                        case 0:

                            break;
                        case 1:
                            ui.commandNum = 0;
                            break;
                        case 2:
                            break;
                        case 3:
                            ui.commandNum = 2;
                            break;
                    }
                }
            } else if(keyH.spacePressed && bumber == 0 || keyH.enterPressed && bumber == 0){
                if(battleSubState == mainMenu){
                switch (ui.commandNum) {
                    case 0:
                        battleSubState = attackMenu;
                        break;
                    case 1:
                        ui.battleText = "Fabimon";
                        break;
                    case 2:
                        ui.battleText = "Bag";
                        break;
                    case 3:
                        npc[npcInteracted].endBattle(npcInteracted);
                        break;
                }
                }else if(battleSubState == attackMenu){
                    battle.battleRound();
                    battle.phase++;
                }
                bumber=1;
            }
            if (!keyH.spacePressed && !keyH.enterPressed && bumber == 1) {
                bumber = 0;
            }
        }// Bindings for battleState
        if (gameState == dialogueState) {

            if (keyH.spacePressed && bumber == 0 || keyH.enterPressed && bumber == 0){

                if (npc[npcInteracted].endDialogue) {
                    if(npc[npcInteracted].trainer){
                        gameState = cutsceneState;
                        fabimon.createFabimon("Feirir",0, 5);
                        enemy_Fabimon = fabimon.tempFabimon;
                        csManager.csNum = csManager.battleBegin;
                    }else {
                        gameState = playState;
                        npc[npcInteracted].endDialogue = false;
                    }
                } else {
                    npc[npcInteracted].dialogue(npcInteracted);
                }
                bumber = 1;
            }
            if (!keyH.spacePressed && !keyH.enterPressed && bumber == 1) {
                bumber = 0;
            }
        }
        if(gameState == cutsceneState){

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // TITLE SCREEN
        if (gameState == titleState || gameState == settingState) {
            ui.draw(g2);
        }

        // OTHERS
        else {
            // TILE
            tileM.draw(g2);

            // OBJECT
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
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