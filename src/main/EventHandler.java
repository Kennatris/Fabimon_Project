package main;

import java.awt.*;

public class EventHandler {

    GameHandler gameH;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GameHandler gameH) {
        this.gameH = gameH;

        eventRect = new Rectangle();
        eventRect.x = gameH.tileSize/2;
        eventRect.y = gameH.tileSize/2;
        eventRect.width = 5;
        eventRect.height = 5;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        
        /* Example
        if(hit(INWICHCOLUMN_MAP, INWICHROW_MAP, requiredDIRECTION) == true) {Method();}
        */
        if(hit(24, 18, "up") == true) {
            if (gameH.mapType == 0) {
                gameH.map = gameH.availableMaps[3];
                gameH.mapType = 3;
            } else if (gameH.mapType == 3) {
                gameH.map = gameH.availableMaps[0];
                gameH.mapType = 0;
            }
            gameH.tileM.loadMap(gameH.map);
            // set Player
            gameH.player.worldY = 19 * gameH.tileSize;
            gameH.player.direction = "down";
            // reset Movement
            gameH.keyH.wPressed = false;
            gameH.keyH.sPressed = false;
            gameH.keyH.aPressed = false;
            gameH.keyH.dPressed = false;
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