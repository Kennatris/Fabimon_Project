package main;

import java.awt.*;

public class CutsceneManager {
    GameHandler gameH;
    Graphics2D g2;
    public int csNum;
    public int csPhase = 0;
    public final int test1 = 1;
    public final int test2 = 2;
    public final int test3 = 3;


    public CutsceneManager(GameHandler gameH){
        this.gameH = gameH;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        switch(csNum){
            case test1: cstest1(); break;
            case test2: cstest2(); break;
            case test3: cstest3(); break;
        }
    }
    private void cstest1(){
        if(csPhase == 0){
        gameH.player.drawing = false;
        gameH.playerD.screenX = gameH.player.screenX;
        gameH.playerD.screenY = gameH.player.screenY;
        gameH.playerD.image = gameH.player.image;
        csPhase++;
        }
        if(csPhase == 1) {
            gameH.playerD.draw(g2);
            gameH.playerD.screenY += 2;
            gameH.player.worldY -= 2;
        }
    }
    private void cstest2(){

    }
    private void cstest3(){

    }
}
