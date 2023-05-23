package main;

import java.awt.*;

public class CutsceneManager {
    public final int battleBegin = 1;
    public final int ausrufezeichen = 2;
    public final int test3 = 3;
    public int csNum;
    public int csPhase = 0;
    GameHandler gameH;
    Graphics2D g2;
    int width;
    int height;
    int x = 0;
    int y = 0;


    public CutsceneManager(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;


        switch (csNum) {
            case battleBegin:
                battleBegin();
                break;
            case ausrufezeichen:
                ausrufezeichen();
                break;
            case test3:
                cstest3();
                break;
        }
    }

    private void battleBegin() {
        if (csPhase == 0) {
            width = 0;
            height = gameH.myGUI.frame.getHeight();
            x = gameH.myGUI.frame.getWidth();
            g2.setColor(Color.black);
            csPhase++;
        } else if (csPhase == 1) width += 10;
        x -= 10;
        g2.fillRect(0, 0, width, height);
        g2.fillRect(x, 0, width, height);
        if (width > gameH.myGUI.frame.getWidth() / 2) {

            gameH.gameState = gameH.battleState;
            csNum = 0;
            width = 0;
            x = 0;
            csPhase = 0;
        }
    }

    private void ausrufezeichen() {
        int x = gameH.npc[gameH.npcInteracted].worldX - gameH.player.worldX + gameH.player.screenX;
        int y = gameH.npc[gameH.npcInteracted].worldY - gameH.player.worldY + gameH.player.screenY - gameH.tileSize;
        /*
        if (gameH.debugMode) {
            System.out.println("Cutscene: 1");
            System.out.println("NPC: " + gameH.npcBattle);
            System.out.println("X: " + x + ", Y: " + y);
        }
         */


          g2.drawImage(gameH.tileM.tile[9].image, x, y, gameH.tileSize, gameH.tileSize, null);
    }

    private void cstest3() {

    }
}
