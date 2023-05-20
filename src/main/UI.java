package main;

import java.awt.*;

public class UI {
    public boolean messageOn = false;
    public String message = "";
    public String[] currentDialogue = new String[3];
    public int textPos = 0;
    public int commandNum = 0;
    public int settingScreenValue = 0;
    public int pauseScreenValue = 0;
    public Color backgroundColor = new Color(47, 45, 45);
    GameHandler gameH;
    Graphics2D g2;
    Font arial_40, arial_80B, arial_25;
    String battleText = "... DU BIST TOD";

    // METHODS
    public UI(GameHandler gameH) {

        this.gameH = gameH;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        arial_25 = new Font("Arial", Font.PLAIN, 25);

    }
    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        // TITLE STATE
        if (gameH.gameState == gameH.titleState) {
            drawTitleScreen();
        }

        // PLAY STATE
        if (gameH.gameState == gameH.playState) {

        }

        // PAUSE STATE
        if (gameH.gameState == gameH.pauseState) {
            drawPauseScreen();
        }

        // DIALOGUE STATE
        if (gameH.gameState == gameH.dialogueState) {
            drawDialogueScreen();
        }

        // SETTING STATE
        if (gameH.gameState == gameH.settingState) {
            drawSettingScreen();
        }

        // SAVE STATE
        if (gameH.gameState == gameH.saveState) {
            drawSaveScreen();
        }
        // BATTLE STATE
        if (gameH.gameState == gameH.battleState) {
            drawBattleScreen();
        }
    }

    public void drawTitleScreen() {

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());

        String text;
        int x = 0;
        int y = 0;

        // TITLE IMAGE
        x = gameH.myGUI.frame.getWidth() / 2 - (gameH.myGUI.frame.getWidth() / 3) / 2;
        y += gameH.myGUI.frame.getHeight() / 16;
        g2.drawImage(gameH.tileM.tile[0].image, x, y, gameH.myGUI.frame.getWidth() / 3, (gameH.myGUI.frame.getWidth() / 3) / 3, null);

        // Font Color
        g2.setColor(Color.white);

        // MENU
        int texts = 4;
        double fontValue = ((gameH.myGUI.frame.getHeight() / 2) - ((texts + 1) * (gameH.myGUI.frame.getHeight() / 25))) / texts; // How big the Font is compared to the Screen
        float fontSize = Float.parseFloat(String.valueOf(fontValue));
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
        text = "SELECT SAVE";
        textPos = 0;
        x = getXforCenteredText(text);
//      y = (gameH.myGUI.frame.getHeight()/16) + (gameH.myGUI.frame.getWidth()/3)/3 + (gameH.myGUI.frame.getHeight()/8); // first Label under the Image
        y = gameH.myGUI.frame.getHeight() / 2 + gameH.myGUI.frame.getHeight() / 25; // middle of the Screen
        g2.drawString(text, x, y);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        text = "LOAD GAME";
        textPos = 1;
        x = getXforCenteredText(text);
        g2.drawString(text, x, y);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        text = "MENU";
        textPos = 2;
        x = getXforCenteredText(text);
        g2.drawString(text, x, y);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        text = "QUIT";
        textPos = 3;
        x = getXforCenteredText(text);
        g2.drawString(text, x, y);
        if (commandNum == textPos) {
            g2.drawString(">", (int) (x - fontValue), y);
        }

    }

    public void drawPauseScreen() {

        Color pauseBGC = new Color(47, 45, 45, 127);

        double pauseBGHeight = gameH.myGUI.frame.getHeight() / 2 + gameH.myGUI.frame.getHeight() / 4;

        g2.setColor(Color.BLACK);
        g2.drawRect(gameH.myGUI.frame.getWidth() / 3, gameH.myGUI.frame.getHeight() / 12, gameH.myGUI.frame.getWidth() / 3, (int) pauseBGHeight);
        g2.setColor(pauseBGC);
        g2.fillRect(gameH.myGUI.frame.getWidth() / 3, gameH.myGUI.frame.getHeight() / 12, gameH.myGUI.frame.getWidth() / 3, (int) pauseBGHeight);

        String text = "";
        int x, y;
        if (pauseScreenValue == 0) {
            // LABEL
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
            text = "SETTINGS";
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) (pauseBGHeight / 4);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) (pauseBGHeight / 3);
            }
            g2.drawString(text, x, y);

            // SETTINGS
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "SETTINGS";
            textPos = 0;
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((28 * pauseBGHeight) / 32);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((20 * pauseBGHeight) / 24);
            }
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            // BACK
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "BACK";
            textPos = 1;
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((15 * pauseBGHeight) / 16);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((11 * pauseBGHeight) / 12);
            }
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            // SAVE AND QUIT
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "SAVE AND QUIT";
            textPos = 2;
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) (pauseBGHeight);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) (pauseBGHeight);
            }
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - (gameH.tileSize / 3), y);
            }
        } else if (pauseScreenValue == 1) {
            // SETTINGS CODE
        }

    }

    public void drawSettingScreen() {

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());

        String text;
        int x = 0;
        int y = 0;

        // set Color
        g2.setColor(Color.white);

        if (settingScreenValue == 0) {
            // Title
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100F));
            text = "SETTINGS";
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 5;

            g2.drawString(text, x, y);

            // MENU
            int texts = 4;
            double fontValue = ((gameH.myGUI.frame.getHeight() / 2) - ((texts + 1) * (gameH.myGUI.frame.getHeight() / 25))) / texts; // How big the Font is compared to the Screen
            float fontSize = Float.parseFloat(String.valueOf(fontValue));
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
            text = "VIDEO";
            textPos = 0;
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 2 + gameH.myGUI.frame.getHeight() / 25; // middle of the Screen
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            text = "SOUND";
            textPos = 1;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            textPos = 2;

            if (gameH.keyboard) {
                g2.setColor(new Color(38, 222, 17));
                text = "KEYBOARD";
                x = getXforCenteredText(text);
                g2.drawString(text, x, y);
                g2.setColor(Color.white);
                if (commandNum == textPos) {
                    g2.drawString("<", x - (gameH.myGUI.frame.getWidth() / 15), y);
                    if (gameH.fullscreen) {
                        g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 32), y);
                    } else {
                        g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4), y);
                    }

                }
            } else {
                g2.setColor(new Color(222, 17, 17));
                text = "CONTROLLER";
                x = getXforCenteredText(text);
                g2.drawString(text, x, y);
                g2.setColor(Color.white);
                if (commandNum == textPos) {
                    g2.drawString("<", x - (gameH.myGUI.frame.getWidth() / 15), y);
                    if (gameH.fullscreen) {
                        g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 12), y);
                    } else {
                        g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 20), y);
                    }
                }
            }

            g2.setColor(Color.white);

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            if (gameH.unsavedSetting) {
                g2.setColor(Color.red);
                text = "SAVE AND BACK";
            } else {
                g2.setColor(Color.white);
                text = "BACK";
            }
            textPos = 3;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            g2.setColor(Color.white);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }
        } else if (settingScreenValue == 1) {
            // Title
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100F));
            text = "VIDEO";
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 5;

            g2.drawString(text, x, y);

            // MENU
            int texts = 4;
            double fontValue = ((gameH.myGUI.frame.getHeight() / 2) - ((texts + 1) * (gameH.myGUI.frame.getHeight() / 25))) / texts; // How big the Font is compared to the Screen
            float fontSize = Float.parseFloat(String.valueOf(fontValue));
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
            text = "FULLSCREEN: ";
            textPos = 0;
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 2 + gameH.myGUI.frame.getHeight() / 25; // middle of the Screen

            if (gameH.fullscreen) {
                g2.drawString("ON", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 16), y);
            } else {
                g2.drawString("OFF", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 32), y);
            }

            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            text = "";
            textPos = 1;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            text = "";
            textPos = 2;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
            text = "BACK";
            textPos = 3;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }
        } else if (settingScreenValue == 2) {
            // Title
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100F));
            text = "VIDEO";
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 5;

            g2.drawString(text, x, y);

            // MENU
            int texts = 4;
            double fontValue = ((gameH.myGUI.frame.getHeight() / 2) - ((texts + 1) * (gameH.myGUI.frame.getHeight() / 25))) / texts; // How big the Font is compared to the Screen
            float fontSize = Float.parseFloat(String.valueOf(fontValue));
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
            text = "Music Volume:";
            textPos = 0;
            x = getXforCenteredText(text);
            y = gameH.myGUI.frame.getHeight() / 3 + gameH.myGUI.frame.getHeight() / 25; // middle of the Screen
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString("<", x - (gameH.myGUI.frame.getWidth() / 15), y);
                if (gameH.fullscreen) {
                    g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 12), y);
                } else {
                    g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 20), y);
                }
            }

            // MUSIC RECT
            g2.setColor(Color.black);
            g2.drawRect((gameH.myGUI.frame.getWidth() / 4), ((y) + (gameH.myGUI.frame.getHeight() / 60)), (gameH.myGUI.frame.getWidth() / 2), (gameH.myGUI.frame.getHeight() / 8));
            g2.setColor(Color.white);
            g2.fillRect((gameH.myGUI.frame.getWidth() / 4), ((y) + (gameH.myGUI.frame.getHeight() / 60)), ((int) (gameH.musicVolume * 10) * ((gameH.myGUI.frame.getWidth() / 2) / 2) / 10), (gameH.myGUI.frame.getHeight() / 8));
            // 0.1 = 5

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60) + (gameH.myGUI.frame.getHeight() / 8);
            text = "Sound Volume:";
            textPos = 1;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString("<", x - (gameH.myGUI.frame.getWidth() / 15), y);
                if (gameH.fullscreen) {
                    g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 12), y);
                } else {
                    g2.drawString(">", x + (gameH.myGUI.frame.getWidth() / 4) + (gameH.myGUI.frame.getWidth() / 20), y);
                }
            }

            // SOUND RECT
            g2.setColor(Color.black);
            g2.drawRect((gameH.myGUI.frame.getWidth() / 4), ((y) + (gameH.myGUI.frame.getHeight() / 60)), (gameH.myGUI.frame.getWidth() / 2), (gameH.myGUI.frame.getHeight() / 8));
            g2.setColor(Color.white);
            g2.fillRect((gameH.myGUI.frame.getWidth() / 4), ((y) + (gameH.myGUI.frame.getHeight() / 60)), ((int) (gameH.soundVolume * 10) * ((gameH.myGUI.frame.getWidth() / 2) / 2) / 10), (gameH.myGUI.frame.getHeight() / 8));

            y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60) + (gameH.myGUI.frame.getHeight() / 8);
            text = "BACK";
            textPos = 2;
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }
        }
    }

    public void drawDialogueScreen() {
        drawTextfield();
        drawDialogue();
    }

    public void drawTextfield() {

        if (gameH.gameState == gameH.battleState) {

            if (gameH.fullscreen) {

                int textfieldHeightScaling = (gameH.myGUI.frame.getHeight() / 9) * 2;
                int textfieldWidthScaling = gameH.myGUI.frame.getWidth() - gameH.myGUI.frame.getWidth() / 6 * 2;

                int y = gameH.myGUI.frame.getHeight() - textfieldHeightScaling;
                int x = 0;
                g2.drawImage(gameH.tileM.tile[25].image, x, y, textfieldWidthScaling, textfieldHeightScaling, null);
            } else {

                int textfieldHeightScaling = (gameH.myGUI.frame.getHeight() / 10) * 2;
                int textfieldWidthScaling = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 8) * 2 - (gameH.myGUI.frame.getWidth() / 77);

                int y = gameH.myGUI.frame.getHeight() - textfieldHeightScaling - gameH.myGUI.frame.getHeight() / 15;
                int x = 0;
                g2.drawImage(gameH.tileM.tile[25].image, x, y, textfieldWidthScaling, textfieldHeightScaling, null);
            }
        }
        if (gameH.gameState == gameH.dialogueState) {

            if (gameH.fullscreen) {

                int textfieldHeightScaling = (gameH.myGUI.frame.getHeight() / 9) * 2;
                int textfieldWidthScaling = gameH.myGUI.frame.getWidth();
                int y = gameH.myGUI.frame.getHeight() - textfieldHeightScaling;
                int x = 0;
                g2.drawImage(gameH.tileM.tile[25].image, x, y, textfieldWidthScaling, textfieldHeightScaling, null);
            } else {

                int textfieldHeightScaling = (gameH.myGUI.frame.getHeight() / 10) * 2;
                int textfieldWidthScaling = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 77);

                int y = gameH.myGUI.frame.getHeight() - textfieldHeightScaling - gameH.myGUI.frame.getHeight() / 15;
                int x = 0;
                g2.drawImage(gameH.tileM.tile[25].image, x, y, textfieldWidthScaling, textfieldHeightScaling, null);
            }
        }

    }

    public void drawSaveScreen() {
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());

        String text;
        int x = 0;
        int y = 0;

        // set Color
        g2.setColor(Color.white);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100F));
        text = "SAVE SELECT";
        x = getXforCenteredText(text);
        y = gameH.myGUI.frame.getHeight() / 5;

        g2.drawString(text, x, y);

        // MENU
        int texts = 4;
        double fontValue = ((gameH.myGUI.frame.getHeight() / 2) - ((texts + 1) * (gameH.myGUI.frame.getHeight() / 25))) / texts; // How big the Font is compared to the Screen
        float fontSize = Float.parseFloat(String.valueOf(fontValue));
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, fontSize));
        text = gameH.fileIndex[0].toUpperCase();
        textPos = 0;
        x = getXforCenteredText(text);
        y = gameH.myGUI.frame.getHeight() / 2 + gameH.myGUI.frame.getHeight() / 25; // middle of the Screen
        if (gameH.save == gameH.fileIndex[0]) {
            g2.setColor(Color.green);
        } else {
            g2.setColor(Color.white);
        }
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        text = gameH.fileIndex[1].toUpperCase();
        textPos = 1;
        x = getXforCenteredText(text);
        if (gameH.save == gameH.fileIndex[1]) {
            g2.setColor(Color.green);
        } else {
            g2.setColor(Color.white);
        }
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        text = gameH.fileIndex[2].toUpperCase();
        textPos = 2;
        x = getXforCenteredText(text);
        if (gameH.save == gameH.fileIndex[2]) {
            g2.setColor(Color.green);
        } else {
            g2.setColor(Color.white);
        }
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        if (commandNum == textPos) {
            g2.drawString(">", x - gameH.tileSize, y);
        }

        y += getYforText(text) + (gameH.myGUI.frame.getHeight() / 60);
        if (gameH.unsavedSetting) {
            g2.setColor(Color.red);
            text = "SAVE AND BACK";
        } else {
            g2.setColor(Color.white);
            text = "BACK";
        }
        textPos = 3;
        x = getXforCenteredText(text);
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        if (commandNum == textPos) {
            g2.drawString(">", (int) (x - fontValue), y);
        }

    }
    private void drawMainMenu(){
        int x = 0;
        int y = 0;
        if (gameH.fullscreen) {
            g2.setFont(arial_40);
            int buttonHeightScaling = (gameH.myGUI.frame.getHeight() / 3);
            int buttonYScaling = buttonHeightScaling - (2 * (buttonHeightScaling) / 5);
            int buttonYScaling2 = buttonHeightScaling - ((buttonHeightScaling) / 15) + 2;
            int buttonWidthScaling = gameH.myGUI.frame.getWidth() / 6;

            //Bag button
            x = gameH.myGUI.frame.getWidth() - buttonWidthScaling;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (commandNum == 3) {
                g2.drawImage(gameH.tileM.tile[24].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[23].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
            //Fabimob button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (commandNum == 1) {
                g2.drawImage(gameH.tileM.tile[22].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[21].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Run button
            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling);
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (commandNum == 2) {
                g2.drawImage(gameH.tileM.tile[20].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[19].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
            //Fight button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (commandNum == 0) {
                g2.drawImage(gameH.tileM.tile[18].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[17].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
        }
        if (!gameH.fullscreen) {
            int minHeight = gameH.myGUI.frame.getHeight() / 15;
            int minWidth = gameH.myGUI.frame.getWidth() / 77;
            int buttonHeightScaling = (gameH.myGUI.frame.getHeight() / 10) * 3;
            int buttonYScaling = buttonHeightScaling - (2 * (buttonHeightScaling) / 5);
            int buttonWidthScaling = gameH.myGUI.frame.getWidth() / 8;
            int buttonYScaling2 = buttonHeightScaling - ((buttonHeightScaling) / 15) + 2;

            x = gameH.myGUI.frame.getWidth() - buttonWidthScaling - minWidth;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling - minHeight;
            if (commandNum == 3) {
                g2.drawImage(gameH.tileM.tile[24].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[23].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fabimob button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (commandNum == 1) {
                g2.drawImage(gameH.tileM.tile[22].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[21].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Run button
            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling) - minWidth;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling - minHeight;
            if (commandNum == 2) {
                g2.drawImage(gameH.tileM.tile[20].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[19].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fight button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (commandNum == 0) {
                g2.drawImage(gameH.tileM.tile[18].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.tileM.tile[17].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
        }
    }
    private void drawAttackMenu(){
        int x = 0;
        int y = 0;
        if (gameH.fullscreen) {
            g2.setFont(arial_40);
            int buttonHeightScaling = (gameH.myGUI.frame.getHeight() / 3);
            int buttonYScaling = buttonHeightScaling - (2 * (buttonHeightScaling) / 5);
            int buttonYScaling2 = buttonHeightScaling - ((buttonHeightScaling) / 15) + 2;
            int buttonWidthScaling = gameH.myGUI.frame.getWidth() / 6;

            //Bag button
            x = gameH.myGUI.frame.getWidth() - buttonWidthScaling;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (commandNum == 3) {
                g2.drawImage(gameH.own_Fabimon.move[0].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[0].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
            //Fabimob button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (commandNum == 1) {
                g2.drawImage(gameH.own_Fabimon.move[1].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[1].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Run button
            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling);
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (commandNum == 2) {
                g2.drawImage(gameH.own_Fabimon.move[2].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[2].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
            //Fight button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (commandNum == 0) {
                g2.drawImage(gameH.own_Fabimon.move[3].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[3].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
        }
        if (!gameH.fullscreen) {
            int minHeight = gameH.myGUI.frame.getHeight() / 15;
            int minWidth = gameH.myGUI.frame.getWidth() / 77;
            int buttonHeightScaling = (gameH.myGUI.frame.getHeight() / 10) * 3;
            int buttonYScaling = buttonHeightScaling - (2 * (buttonHeightScaling) / 5);
            int buttonWidthScaling = gameH.myGUI.frame.getWidth() / 8;
            int buttonYScaling2 = buttonHeightScaling - ((buttonHeightScaling) / 15) + 2;

            x = gameH.myGUI.frame.getWidth() - buttonWidthScaling - minWidth;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling - minHeight;
            if (commandNum == 3) {
                g2.drawImage(gameH.own_Fabimon.move[3].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[3].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fabimob button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (commandNum == 1) {
                g2.drawImage(gameH.own_Fabimon.move[1].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[1].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Run button
            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling) - minWidth;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling - minHeight;
            if (commandNum == 2) {
                g2.drawImage(gameH.own_Fabimon.move[2].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[2].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fight button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (commandNum == 0) {
                g2.drawImage(gameH.own_Fabimon.move[0].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.own_Fabimon.move[0].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
        }
    }


    public void drawBattleScreen() {
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());

        if(gameH.battleSubState == gameH.mainMenu ){
            drawMainMenu();
        }else if(gameH.battleSubState == gameH.attackMenu){
            drawAttackMenu();
        }

            drawfabimon();
            drawTextfield();
            battleInfoFields();
            health();
            drawDialogue();

    }

    private void drawfabimon() {
        int fabimonWidth = gameH.myGUI.frame.getWidth() / 4;
        int fabimonHeight = gameH.myGUI.frame.getHeight() / 2;
        int fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 3);
        int fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 12) * 11;

        if (gameH.fullscreen) {
            g2.drawImage(gameH.enemy_Fabimon.up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
            fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 2);
            g2.drawImage(gameH.own_Fabimon.up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
        } else {
            g2.drawImage(gameH.enemy_Fabimon.up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
            fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 3;
            g2.drawImage(gameH.own_Fabimon.up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
        }
    }

    private void battleInfoFields() {
        int battleinfoWidthScaling = gameH.myGUI.frame.getWidth() / 3;
        int battleinfoHeightScaling = gameH.myGUI.frame.getHeight() / 3;

        g2.drawImage(gameH.tileM.tile[26].image, 0, 0, battleinfoWidthScaling, battleinfoHeightScaling, null);

        if (gameH.fullscreen) {
            int levelX = gameH.myGUI.frame.getWidth() / 70;
            int levelY = gameH.myGUI.frame.getHeight() / 7;
            int nameX = gameH.myGUI.frame.getWidth() / 15;

            //enemy Fabimon infofield
            int x = gameH.myGUI.frame.getWidth() - battleinfoWidthScaling;
            int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 6) * 3;
            g2.drawImage(gameH.tileM.tile[27].image, x, y, battleinfoWidthScaling, battleinfoHeightScaling, null);

            g2.setColor(Color.BLACK);
            g2.setFont(arial_40);
            g2.drawString(Integer.toString(gameH.enemy_Fabimon.level), levelX, levelY);
            g2.drawString(gameH.enemy_Fabimon.name, nameX, levelY);

            levelX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 11) * 3;
            levelY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 2;
            nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 15) * 3;

            g2.drawString(Integer.toString(gameH.own_Fabimon.level), levelX, levelY);
            g2.drawString(gameH.own_Fabimon.name, nameX, levelY);

        } else {
            int levelX = gameH.myGUI.frame.getWidth() / 70;
            int levelY = gameH.myGUI.frame.getHeight() / 7;
            int nameX = gameH.myGUI.frame.getWidth() / 17;

            //enemy Fabimon infofield
            int x = gameH.myGUI.frame.getWidth() - battleinfoWidthScaling;
            int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 6) * 3;
            g2.drawImage(gameH.tileM.tile[27].image, x, y, battleinfoWidthScaling, battleinfoHeightScaling, null);

            //enemy Fabimon
            g2.setColor(Color.BLACK);
            g2.setFont(arial_25);
            g2.drawString(Integer.toString(gameH.enemy_Fabimon.level), levelX, levelY);
            g2.drawString(gameH.enemy_Fabimon.name, nameX, levelY);

            levelX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 11) * 3;
            levelY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 2;
            nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 15) * 3;
            g2.drawString(Integer.toString(gameH.own_Fabimon.level), levelX, levelY);
            g2.drawString(gameH.own_Fabimon.name, nameX, levelY);
        }
    }

    private void health() {
        g2.setColor(Color.GREEN);
        double healthScalingWidth = ((gameH.myGUI.frame.getWidth() / 15) * 2);
        int healthScalingHeight = (gameH.myGUI.frame.getHeight() / 70);
        int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 8) * 3;
        double enemyHealthWidthpart = (healthScalingWidth / gameH.enemy_Fabimon.hp);
        double ownHealthWidthpart = (healthScalingWidth / gameH.own_Fabimon.hp);
        double enemyCurrentHealthWidth = enemyHealthWidthpart * gameH.enemy_Fabimon.currentHp;
        double ownCurrentHealthWidth = ownHealthWidthpart * gameH.own_Fabimon.currentHp;

        if (gameH.fullscreen) {
            //Fabimon Healthbar
            int x = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 13) * 2;
            g2.fillRect(x, y, (int)ownCurrentHealthWidth, healthScalingHeight);

            //enemy Fabimon healthbar
            x = (gameH.myGUI.frame.getWidth() / 17);
            y = (gameH.myGUI.frame.getHeight() / 6) - 3;
            g2.fillRect(x, y, (int) enemyCurrentHealthWidth, healthScalingHeight);
        } else {
            //Fabimon healthbar
            int x = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 13) * 2 - 1;
            g2.fillRect(x, y, (int) ownCurrentHealthWidth, healthScalingHeight);

            //enemy Fabimon healthbar
            x = (gameH.myGUI.frame.getWidth() / 17);
            y = (gameH.myGUI.frame.getHeight() / 29) * 5;
            g2.fillRect(x, y, (int) enemyCurrentHealthWidth, healthScalingHeight);
        }
    }

    public void drawDialogue() {
        int textYScaling = 0;
        int textXScaling = 0;
        g2.setColor(Color.BLACK);
        if (gameH.fullscreen) {
            g2.setFont(arial_40);
            textXScaling = gameH.myGUI.frame.getWidth() / 30;
            textYScaling = gameH.myGUI.frame.getHeight() - gameH.myGUI.frame.getHeight() / 6;
            for (int i = 0; i < 3; i++) {
                g2.drawString(currentDialogue[i], textXScaling, textYScaling + i * 57);
            }
        } else {
            g2.setFont(arial_25);
            textXScaling = gameH.myGUI.frame.getWidth() / 30;
            textYScaling = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 14) * 3;
            for (int i = 0; i < 3; i++) {
                g2.drawString(currentDialogue[i], textXScaling, textYScaling + i * 37);
            }
        }
    }

    public int getXforCenteredText(String text) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gameH.myGUI.frame.getWidth() / 2 - length / 2;

        return x;
    }

    public int getYforText(String text) {

        int height = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight();

        return height;
    }
}