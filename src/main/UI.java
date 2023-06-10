package main;

import java.awt.*;

public class UI {
    public boolean messageOn = false;
    public String message = "";
    public String[] currentDialogue = new String[3];
    public int textPos = 0;
    public int commandNum = 0;
    public int subCommandNum = 0;
    public int settingScreenValue = 0;
    public int pauseScreenValue = 0;
    public int optionType = 0;
    public Color backgroundColor = new Color(47, 45, 45);
    int spriteCounter = 0;
    GameHandler gameH;
    Graphics2D g2;
    Font arial_40, arial_80B, arial_30, arial_25, arial_20, arial_15;
    String battleText = "... DU BIST TOD";

    // METHODS
    public UI(GameHandler gameH) {

        this.gameH = gameH;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        arial_25 = new Font("Arial", Font.PLAIN, 25);
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        arial_15 = new Font("Arial", Font.PLAIN, 15);
        arial_30 = new Font("Arial", Font.PLAIN, 30);

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
        if (gameH.gameState == gameH.fabimonState) {
            drawFabimonScreen();
        }
        // HealState
        if (gameH.gameState == gameH.healState) {
            drawFloatingText("Deine Fabimons wurde Geheilt !");
        }
    }

    private void drawFabimonScreen() {
        if (gameH.gameSubState == gameH.noSubState) {
            drawFabimonMenu();
        } else if (gameH.gameSubState == gameH.optionState) {
            drawFabimonMenu();
            drawOptionMenu();
        } else if (gameH.gameSubState == gameH.fabimonOverviewState) {
            drawfabimonOverView();
        }
    }

    private void drawOptionMenu() {
        if (gameH.gameState == gameH.fabimonState) {
            if (gameH.fullscreen) {
                g2.setColor(Color.WHITE);
                g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 20, gameH.myGUI.frame.getHeight() / 100 * 50, gameH.myGUI.frame.getWidth() / 4, gameH.myGUI.frame.getHeight() / 5);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_30);

                // zeichnet eine optionbox
                textPos = 0;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Place as first", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 55);
                }
                g2.drawString("Place as first", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 55);

                textPos = 1;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Status", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 60);
                }
                g2.drawString("Status", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 60);

                textPos = 2;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Attacks", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 65);
                }
                g2.drawString("Attacks", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 65);

                textPos = 3;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Back", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 70);
                }
                g2.drawString("Back", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 70);

            } else {
                g2.setColor(Color.WHITE);
                g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 20, gameH.myGUI.frame.getHeight() / 100 * 50, gameH.myGUI.frame.getWidth() / 4, gameH.myGUI.frame.getHeight() / 5);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_30);

                textPos = 0;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Place as first", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 55);
                }
                g2.drawString("Place as first", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 55);

                textPos = 1;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Status", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 60);
                }
                g2.drawString("Status", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 60);

                textPos = 2;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Attacks", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 65);
                }
                g2.drawString("Attacks", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 65);

                textPos = 3;
                if (subCommandNum == textPos) {
                    g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Back", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 70);
                }
                g2.drawString("Back", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 70);

            }
        }
        if (gameH.gameState == gameH.battleState) {
            if(optionType == 0) {
                if (!gameH.fullscreen) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 77, gameH.myGUI.frame.getHeight() / 100 * 83, gameH.myGUI.frame.getWidth() / 4, gameH.myGUI.frame.getHeight() / 5);
                    g2.setColor(Color.BLACK);
                    g2.setFont(arial_20);

                    // zeichnet eine optionbox
                    textPos = 0;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds("Eine Attacke vergessen", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 89);
                    }
                    g2.drawString("Eine Attacke vergessen", gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 89);

                    textPos = 1;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds("Attacke nicht lernen", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 97);
                    }
                    g2.drawString("Attacke nicht lernen", gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 97);

                } else {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 20, gameH.myGUI.frame.getHeight() / 100 * 50, gameH.myGUI.frame.getWidth() / 4, gameH.myGUI.frame.getHeight() / 5);
                    g2.setColor(Color.BLACK);
                    g2.setFont(arial_30);

                    textPos = 0;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Place as first", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 55);
                    }
                    g2.drawString("Place as first", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 55);

                    textPos = 1;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Status", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 60);
                    }
                    g2.drawString("Status", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 60);

                    textPos = 2;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Attacks", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 65);
                    }
                    g2.drawString("Attacks", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 65);

                    textPos = 3;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 22 + (int) g2.getFontMetrics().getStringBounds("Back", g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 70);
                    }
                    g2.drawString("Back", gameH.myGUI.frame.getWidth() / 100 * 22, gameH.myGUI.frame.getHeight() / 100 * 70);

                }
            }else if(optionType == 1){
                if(gameH.fullscreen){

                }else{
                    g2.setColor(Color.WHITE);
                    g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 77, gameH.myGUI.frame.getHeight() / 100 * 83, gameH.myGUI.frame.getWidth() / 4, gameH.myGUI.frame.getHeight() / 5);
                    g2.setColor(Color.BLACK);
                    g2.setFont(arial_20);

                    // zeichnet eine optionbox
                    textPos = 0;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[0].move[0].name, g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 87);
                    }
                    g2.drawString(gameH.player.fabimonTeam[0].move[0].name, gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 87);

                    textPos = 1;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[0].move[1].name, g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 92);
                    }
                    g2.drawString(gameH.player.fabimonTeam[0].move[1].name, gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 92);

                    textPos = 2;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[0].move[2].name, g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 97);
                    }
                    g2.drawString(gameH.player.fabimonTeam[0].move[2].name, gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 97);

                    textPos = 3;
                    if (subCommandNum == textPos) {
                        g2.drawString("<", gameH.myGUI.frame.getWidth() / 100 * 78 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[0].move[2].name, g2).getWidth() + 20, gameH.myGUI.frame.getHeight() / 100 * 102);
                    }
                    g2.drawString(gameH.player.fabimonTeam[0].move[2].name, gameH.myGUI.frame.getWidth() / 100 * 78, gameH.myGUI.frame.getHeight() / 100 * 102);

                }
            }
        }
    }

    // draws Title Screen
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
            text = "PAUSE";
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
            /*
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

             */

            // BACK
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "BACK";
            textPos = 0;
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((13 * pauseBGHeight) / 16);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((9 * pauseBGHeight) / 12);
            }
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - gameH.tileSize, y);
            }

            // Inventar
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "INVENTORY";
            textPos = 1;
            x = getXforCenteredText(text);
            if (gameH.fullscreen) {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((14 * pauseBGHeight) / 16);
            } else {
                pauseBGHeight = (double) gameH.myGUI.frame.getHeight() / 2 + (double) gameH.myGUI.frame.getHeight() / 4;
                y = (int) ((10 * pauseBGHeight) / 12);
            }
            g2.drawString(text, x, y);
            if (commandNum == textPos) {
                g2.drawString(">", x - (gameH.tileSize / 3), y);
            }

            // Fabimon
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "FABIMON";
            textPos = 2;
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
                g2.drawString(">", x - (gameH.tileSize / 3), y);
            }

            // SAVE AND QUIT
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40));
            text = "SAVE AND QUIT";
            textPos = 3;
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

    public void drawfabimonOverView() {
        if (gameH.fullscreen) {

            g2.setColor(Color.GRAY);
            double overViewWidth = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 35;
            double overViewHeight = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 23;
            g2.fillRect(0, 0, (int) overViewWidth, (int) overViewHeight);
            for (int i = 0; i < 5; i++) {
                g2.setColor(Color.BLACK);
                g2.drawRect(i, i, (int) overViewWidth - i, (int) overViewHeight - i);
            }
            g2.setColor(Color.ORANGE);
            g2.fillRect(5, 5, gameH.myGUI.frame.getWidth() / 6, gameH.myGUI.frame.getHeight() / 15);
            g2.setColor(Color.BLACK);
            g2.setFont(arial_30);
            g2.drawString(gameH.player.fabimonTeam[commandNum].name, gameH.myGUI.frame.getWidth() / 100, gameH.myGUI.frame.getHeight() / 100 * 5);

            if (gameH.player.fabimonTeam[commandNum].gender.equals("Male")) {
                g2.setColor(Color.BLUE);
                g2.fillOval(gameH.myGUI.frame.getWidth() / 100 * 14, gameH.myGUI.frame.getHeight() / 100 * 2, 35, 35);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_25);
                g2.drawString("\u2642", gameH.myGUI.frame.getWidth() / 1000 * 220, gameH.myGUI.frame.getHeight() / 100 * 5);
            } else if (gameH.player.fabimonTeam[commandNum].gender.equals("Female")) {
                g2.setColor(Color.RED);
                g2.fillOval(gameH.myGUI.frame.getWidth() / 100 * 14, gameH.myGUI.frame.getHeight() / 100 * 2, 35, 35);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_25);
                g2.drawString("\u2640", gameH.myGUI.frame.getWidth() / 1000 * 220, gameH.myGUI.frame.getHeight() / 100 * 5);
            }
            g2.drawString(gameH.player.fabimonTeam[commandNum].item, gameH.myGUI.frame.getWidth() / 100 * 7, gameH.myGUI.frame.getHeight() / 100 * 60);
            g2.drawImage(gameH.player.fabimonTeam[commandNum].up1, 0, gameH.myGUI.frame.getHeight() / 10, gameH.myGUI.frame.getWidth() / 5, gameH.myGUI.frame.getHeight() / 4, null);
        } else {
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());
            g2.setColor(Color.BLUE);
            g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight() / 100 * 8);
            g2.setColor(Color.BLACK);
            g2.drawString("STATUS", gameH.myGUI.frame.getWidth() / 100 * 2, gameH.myGUI.frame.getHeight() / 100 * 7);
            g2.setColor(Color.CYAN);
            g2.fillRect(0, gameH.myGUI.frame.getHeight() / 100 * 8, gameH.myGUI.frame.getWidth() / 3, gameH.myGUI.frame.getHeight());
            g2.setColor(Color.BLACK);
            g2.drawString(gameH.player.fabimonTeam[commandNum].name, gameH.myGUI.frame.getWidth() / 100 * 5, gameH.myGUI.frame.getHeight() / 100 * 17);
            g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 5, gameH.myGUI.frame.getHeight() / 100 * 20, gameH.myGUI.frame.getWidth() / 100 * 28, gameH.myGUI.frame.getHeight() / 100 * 36);
            g2.setColor(Color.WHITE);
            g2.fillRect(gameH.myGUI.frame.getWidth() / 100 * 6, gameH.myGUI.frame.getHeight() / 100 * 21, gameH.myGUI.frame.getWidth() / 100 * 26, gameH.myGUI.frame.getHeight() / 100 * 34);
            g2.drawImage(gameH.player.fabimonTeam[commandNum].up1, gameH.myGUI.frame.getWidth() / 100 * 7, gameH.myGUI.frame.getHeight() / 100 * 22, gameH.myGUI.frame.getWidth() / 5, gameH.myGUI.frame.getHeight() / 4, null);
            if (gameH.player.fabimonTeam[commandNum].gender.equals("Male")) {
                g2.setColor(Color.BLUE);
                g2.fillOval(gameH.myGUI.frame.getWidth() / 100 * 29, gameH.myGUI.frame.getHeight() / 100 * 10, 45, 45);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_30);
                g2.drawString("\u2642", gameH.myGUI.frame.getWidth() / 1000 * 330, gameH.myGUI.frame.getHeight() / 100 * 16);
            } else if (gameH.player.fabimonTeam[commandNum].gender.equals("Female")) {
                g2.setColor(Color.RED);
                g2.fillOval(gameH.myGUI.frame.getWidth() / 100 * 29, gameH.myGUI.frame.getHeight() / 100 * 10, 45, 45);
                g2.setColor(Color.BLACK);
                g2.setFont(arial_30);
                g2.drawString("\u2640", gameH.myGUI.frame.getWidth() / 1000 * 330, gameH.myGUI.frame.getHeight() / 100 * 16);
            }
            g2.drawString("Item: " + gameH.player.fabimonTeam[commandNum].item, gameH.myGUI.frame.getWidth() / 100 * 2, gameH.myGUI.frame.getHeight() / 100 * 70);
        }
    }

    public void drawTextfield() {

        if (gameH.gameState == gameH.battleState || gameH.gameState == gameH.fabimonState) {

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

    // draw the Save Screen
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

    private void drawMainMenu() {
        int x;
        int y;
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

    private void drawAttackMenu() {
        int x = 0;
        int y = 0;
        if (gameH.fullscreen) {
            g2.setFont(arial_40);
            int buttonHeightScaling = (gameH.myGUI.frame.getHeight() / 3);
            int buttonYScaling = buttonHeightScaling - (2 * (buttonHeightScaling) / 5);
            int buttonYScaling2 = buttonHeightScaling - ((buttonHeightScaling) / 15) + 2;
            int buttonWidthScaling = gameH.myGUI.frame.getWidth() / 6;


            x = gameH.myGUI.frame.getWidth() - buttonWidthScaling;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (gameH.player.fabimonTeam[0].move[0] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 3) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[0].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[0].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (gameH.player.fabimonTeam[0].move[1] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 1) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[1].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[1].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }


            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling);
            y = gameH.myGUI.frame.getHeight() - buttonYScaling;
            if (gameH.player.fabimonTeam[0].move[2] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 2) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[2].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[2].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            y = gameH.myGUI.frame.getHeight() - buttonYScaling2;
            if (gameH.player.fabimonTeam[0].move[3] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 0) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[3].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[3].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
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
            if (gameH.player.fabimonTeam[0].move[3] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 3) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[3].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[3].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fabimob button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (gameH.player.fabimonTeam[0].move[1] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 1) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[1].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[1].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Run button
            x = gameH.myGUI.frame.getWidth() - (2 * buttonWidthScaling) - minWidth;
            y = gameH.myGUI.frame.getHeight() - buttonYScaling - minHeight;
            if (gameH.player.fabimonTeam[0].move[2] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 2) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[2].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[2].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }

            //Fight button
            y = gameH.myGUI.frame.getHeight() - buttonYScaling2 - minHeight;
            if (gameH.player.fabimonTeam[0].move[0] == null) {
                g2.drawImage(gameH.tileM.tile[28].image, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else if (commandNum == 0) {
                g2.drawImage(gameH.player.fabimonTeam[0].move[0].ausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            } else {
                g2.drawImage(gameH.player.fabimonTeam[0].move[0].nausgewählt, x, y, buttonWidthScaling, buttonHeightScaling, null);
            }
        }
        drawAP();
    }

    private void drawFabimonMenu() {

        if (gameH.fullscreen) {
            double menuX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 35;
            double menuY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 82;
            double menupart = ((gameH.myGUI.frame.getHeight() / 100) * 83) / 6;
            double menuWidth = (gameH.myGUI.frame.getWidth() / 100) * 35;
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    g2.setColor(Color.cyan);
                } else {
                    g2.setColor(Color.BLUE);
                }
                g2.fillRect((int) menuX, (int) menuY + (int) menupart * i, (int) menuWidth, (int) menupart);
            }

            g2.setColor(Color.BLACK);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    g2.drawRect((int) menuX + j, (int) menuY + (int) menupart * i + j, (int) menuWidth - j - 1, (int) menupart - j - 1);
                }
            }

            double nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 32;
            double nameY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 76;

            g2.setColor(Color.BLACK);
            g2.setFont(arial_40);

            for (int i = 0; i < gameH.player.fabimonTeam.length; i++) {
                g2.setColor(Color.BLACK);
                if (gameH.player.fabimonTeam[i] != null) {
                    if (gameH.ui.commandNum == i) {
                        g2.drawString("<", (int) (nameX + 20 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[i].name, g2).getWidth() + 20 + (int) g2.getFontMetrics().getStringBounds("Lv: " + gameH.player.fabimonTeam[i].level, g2).getWidth()), (int) nameY + (int) menupart * i);
                    }
                    g2.drawString(gameH.player.fabimonTeam[i].name, (int) nameX, (int) nameY + (int) menupart * i);
                    g2.drawString("Lv: " + gameH.player.fabimonTeam[i].level, (int) nameX + 20 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[i].name, g2).getWidth(), (int) nameY + (int) menupart * i);
                    g2.drawString(gameH.player.fabimonTeam[i].currentHp + "/" + gameH.player.fabimonTeam[i].hp, (int) nameX, (int) nameY + (int) menupart * i + 50);
                }
            }
        } else {
            double min = (gameH.myGUI.frame.getHeight() / 100) * 6;
            double menuX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 28;
            double menuY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 80;
            double menupart = ((gameH.myGUI.frame.getHeight() / 100) * 80) / 6;
            double menuWidth = (gameH.myGUI.frame.getWidth() / 100) * 28;

            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    g2.setColor(Color.cyan);
                } else {
                    g2.setColor(Color.BLUE);
                }
                g2.fillRect((int) menuX, (int) menuY + (int) menupart * i - (int) min, (int) menuWidth, (int) menupart);
            }
            g2.setColor(Color.BLACK);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j == 0) {
                        g2.drawRect((int) menuX, (int) menuY - (int) min, (int) menuWidth, (int) menupart);

                    } else {
                        g2.drawRect((int) menuX + j, (int) menuY + (int) menupart * i + j - (int) min, (int) menuWidth - j - 1, (int) menupart - j - 1);
                    }
                }
            }
            double nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 27;
            double nameY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 75;

            g2.setColor(Color.BLACK);
            g2.setFont(arial_25);
            for (int i = 0; i < gameH.player.fabimonTeam.length; i++) {
                g2.setColor(Color.BLACK);
                if (gameH.player.fabimonTeam[i] != null) {
                    if (gameH.ui.commandNum == i) {
                        g2.drawString("<", (int) (nameX + 20 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[i].name, g2).getWidth() + 20 + (int) g2.getFontMetrics().getStringBounds("Lv: " + gameH.player.fabimonTeam[i].level, g2).getWidth()), (int) nameY + 65 * i - (int) min);
                    }
                    g2.drawString(gameH.player.fabimonTeam[i].name, (int) nameX, (int) nameY + (int) menupart * i - (int) min);
                    g2.drawString("Lv: " + gameH.player.fabimonTeam[i].level, (int) nameX + 20 + (int) g2.getFontMetrics().getStringBounds(gameH.player.fabimonTeam[i].name, g2).getWidth(), (int) nameY + (int) menupart * i - (int) min);
                    g2.drawString(gameH.player.fabimonTeam[i].currentHp + "/" + gameH.player.fabimonTeam[i].hp, (int) nameX, (int) nameY + (int) menupart * i + 30 - (int) min);
                }
            }
        }
    }

    public void drawBattleScreen() {
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, gameH.myGUI.frame.getWidth(), gameH.myGUI.frame.getHeight());

        if (gameH.gameSubState == gameH.noSubState) {
            drawMainMenu();
            drawRestOfBattleScreen();
        } else if (gameH.gameSubState == gameH.attackMenu) {
            drawAttackMenu();
            drawRestOfBattleScreen();
        } else if (gameH.gameSubState == gameH.fabimonMenu) {
            drawRestOfBattleScreen();
            drawFabimonMenu();
        } else if (gameH.gameSubState == gameH.newMoveState) {
            drawAttackMenu();
            drawRestOfBattleScreen();
        } else if (gameH.gameSubState == gameH.optionState) {
            drawMainMenu();
            drawRestOfBattleScreen();
            drawOptionMenu();

        }
    }

    private void drawRestOfBattleScreen() {
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

        if (spriteCounter <= 20) { // Tino ist der Gott der IDLE animationen
            if (gameH.fullscreen) {
                g2.drawImage(gameH.enemy_Fabimon[0].up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
                fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
                fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 2);
                g2.drawImage(gameH.player.fabimonTeam[0].up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            } else {
                g2.drawImage(gameH.enemy_Fabimon[0].up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
                fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
                fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 3;
                g2.drawImage(gameH.player.fabimonTeam[0].up1, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            }
            spriteCounter++;
        } else {
            if (gameH.fullscreen) {
                g2.drawImage(gameH.enemy_Fabimon[0].up2, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
                fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
                fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 2);
                g2.drawImage(gameH.player.fabimonTeam[0].up2, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            } else {
                g2.drawImage(gameH.enemy_Fabimon[0].up2, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
                fabimonX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 12) * 10;
                fabimonY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 3;
                g2.drawImage(gameH.player.fabimonTeam[0].up2, fabimonX, fabimonY, fabimonWidth, fabimonHeight, null);
            }
            spriteCounter++;
            if (spriteCounter == 40) {
                spriteCounter = 0;
            }
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
            int healthX = gameH.myGUI.frame.getWidth() - gameH.myGUI.frame.getWidth() / 8;
            double healthY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 35;

            //own Fabimon infofield
            int x = gameH.myGUI.frame.getWidth() - battleinfoWidthScaling;
            int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 6) * 3;
            g2.drawImage(gameH.tileM.tile[27].image, x, y, battleinfoWidthScaling, battleinfoHeightScaling, null);

            g2.setColor(Color.BLACK);
            g2.setFont(arial_40);
            g2.drawString(Integer.toString(gameH.enemy_Fabimon[0].level), levelX, levelY);
            g2.drawString(gameH.enemy_Fabimon[0].name, nameX, levelY);


            levelX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 11) * 3;
            levelY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 2;
            nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 15) * 3;

            g2.drawString(Integer.toString(gameH.player.fabimonTeam[0].level), levelX, levelY);
            g2.drawString(gameH.player.fabimonTeam[0].name, nameX, levelY);
            g2.setFont(arial_30);
            g2.drawString(gameH.player.fabimonTeam[0].currentHp + "/" + gameH.player.fabimonTeam[0].hp, healthX, (int) healthY);

        } else {
            int levelX = gameH.myGUI.frame.getWidth() / 70;
            int levelY = gameH.myGUI.frame.getHeight() / 7;
            int nameX = gameH.myGUI.frame.getWidth() / 17;
            int healthX = gameH.myGUI.frame.getWidth() - gameH.myGUI.frame.getWidth() / 8;
            double healthY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 36;

            //own Fabimon infofield
            int x = gameH.myGUI.frame.getWidth() - battleinfoWidthScaling;
            int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 6) * 3;
            g2.drawImage(gameH.tileM.tile[27].image, x, y, battleinfoWidthScaling, battleinfoHeightScaling, null);

            //enemy Fabimon
            g2.setColor(Color.BLACK);
            g2.setFont(arial_25);
            g2.drawString(Integer.toString(gameH.enemy_Fabimon[0].level), levelX, levelY);
            g2.drawString(gameH.enemy_Fabimon[0].name, nameX, levelY);


            levelX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 11) * 3;
            levelY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 5) * 2;
            nameX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 15) * 3;
            g2.drawString(Integer.toString(gameH.player.fabimonTeam[0].level), levelX, levelY);
            g2.drawString(gameH.player.fabimonTeam[0].name, nameX, levelY);
            g2.setFont(arial_20);
            g2.drawString(gameH.player.fabimonTeam[0].currentHp + "/" + gameH.player.fabimonTeam[0].hp, healthX, (int) healthY);
        }
    }

    public void clearTextfield() {
        currentDialogue[0] = "";
        currentDialogue[1] = "";
        currentDialogue[2] = "";
    }

    private void health() {
        g2.setColor(Color.GREEN);
        double healthScalingWidth = ((gameH.myGUI.frame.getWidth() / 15) * 2);
        int healthScalingHeight = (gameH.myGUI.frame.getHeight() / 70);
        int y = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 8) * 3;
        double enemyHealthWidthpart = (healthScalingWidth / gameH.enemy_Fabimon[0].hp);
        double ownHealthWidthpart = (healthScalingWidth / gameH.player.fabimonTeam[0].hp);
        double enemyCurrentHealthWidth = enemyHealthWidthpart * gameH.enemy_Fabimon[0].currentHp;
        double ownCurrentHealthWidth = ownHealthWidthpart * gameH.player.fabimonTeam[0].currentHp;
        if (enemyCurrentHealthWidth < 0) {
            enemyCurrentHealthWidth = 0;
        }
        if (ownCurrentHealthWidth < 0) {
            ownCurrentHealthWidth = 0;
        }
        if (gameH.fullscreen) {
            //Fabimon Healthbar
            int x = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 13) * 2;
            g2.fillRect(x, y, (int) ownCurrentHealthWidth, healthScalingHeight);

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

    private void drawAP() {
        if (gameH.fullscreen) {
            g2.setFont(arial_30);
            double apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 21;
            double apY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 15;
            if (gameH.player.fabimonTeam[0].move[0] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[0].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 4;
            if (gameH.player.fabimonTeam[0].move[1] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[1].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 21;
            apY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 3;
            if (gameH.player.fabimonTeam[0].move[2] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[2].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 4;
            if (gameH.player.fabimonTeam[0].move[3] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[3].currentap), (int) apX, (int) apY);
            }
        } else {
            g2.setFont(arial_15);
            double apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 18;
            double apY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 22;
            if (gameH.player.fabimonTeam[0].move[0] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[0].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 5;
            if (gameH.player.fabimonTeam[0].move[1] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[1].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 18;
            apY = gameH.myGUI.frame.getHeight() - (gameH.myGUI.frame.getHeight() / 100) * 10;
            if (gameH.player.fabimonTeam[0].move[2] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[2].currentap), (int) apX, (int) apY);
            }
            apX = gameH.myGUI.frame.getWidth() - (gameH.myGUI.frame.getWidth() / 100) * 5;
            if (gameH.player.fabimonTeam[0].move[3] != null) {
                g2.drawString(String.valueOf(gameH.player.fabimonTeam[0].move[3].currentap), (int) apX, (int) apY);
            }
        }
    }

    public void drawFloatingText(String text) {
        int textYScaling;
        int textXScaling;
        g2.setColor(Color.WHITE);
        if (gameH.fullscreen) {
            g2.setFont(arial_80B);
            textXScaling = gameH.myGUI.frame.getWidth() / 2 - getXforCenteredText(text) - getXforCenteredText(text) / 2;
            textYScaling = gameH.myGUI.frame.getHeight() / 3;
            g2.drawString(text, textXScaling, textYScaling);
        } else {
            g2.setFont(arial_40);
            textXScaling = gameH.myGUI.frame.getWidth() / 2 - getXforCenteredText(text);
            textYScaling = gameH.myGUI.frame.getHeight() / 3;
            g2.drawString(text, textXScaling, textYScaling);

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