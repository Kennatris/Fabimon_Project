package main;

import java.awt.*;

public class EventHandler {

    GameHandler gameH;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GameHandler gameH) {
        this.gameH = gameH;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        
        /* Example
        if(hit(INWICHCOLUMN_MAP, INWICHROW_MAP, requiredDIRECTION) == true) {Method();}
        */
        if(hit(17, 24, "any") == true) {
            //gameH.map = "world_test.txt";
            //gameH.tileM.loadMap(gameH.map);
            System.out.println("hit");
        }

    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {

        boolean hit = false;

        gameH.player.solidArea.x = gameH.player.worldX + gameH.player.solidArea.x;
        gameH.player.solidArea.y = gameH.player.worldY + gameH.player.solidArea.y;
        eventRect.x = eventCol*gameH.tileSize + eventRect.x;
        eventRect.y = eventRow*gameH.tileSize + eventRect.y;

        if(gameH.player.solidArea.intersects(eventRect)) {
            if(gameH.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }

        gameH.player.solidArea.x = gameH.player.solidAreaDefaultX;
        gameH.player.solidArea.y = gameH.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

}