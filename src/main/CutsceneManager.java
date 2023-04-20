package main;

import java.awt.*;

public class CutsceneManager {
    GameHandler gameH;
    Graphics2D g2;
    public int csNum;
    public int csPhase = 0;
    int width;
    int height;
    int x = 0;
    public final int battleBegin = 1;
    public final int test2 = 2;
    public final int test3 = 3;


    public CutsceneManager(GameHandler gameH){
        this.gameH = gameH;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        switch(csNum){
            case battleBegin: battleBegin(); break;
            case test2: cstest2(); break;
            case test3: cstest3(); break;
        }
    }
    private void battleBegin(){

        if(csPhase == 0){
             width = 0;
             height = gameH.myGUI.frame.getHeight();
             x = gameH.myGUI.frame.getWidth();
             g2.setColor(Color.black);
             csPhase++;
        }else if(csPhase == 1)
            width += 10;
            x -= 10;
            g2.fillRect(0, 0, width, height);
            g2.fillRect(x, 0, width, height);
            if(width > gameH.myGUI.frame.getWidth()/2){
                gameH.gameState = gameH.battleState;
                csNum = 0;
            }


    }
    private void cstest2(){

    }
    private void cstest3(){

    }
}
