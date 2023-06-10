package main;

import java.awt.*;

public class EventHandler {

    GameHandler gameH;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    // creates a "collision box"
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


    // checks whether an event takes place
    public void checkEvent() {

            if(hit(24, 18, "any")) {
                gameH.stopMusic();
                if (gameH.mapType == 0) {
                    gameH.map = gameH.availableMaps[3];
                    gameH.mapType = 3;
                    gameH.playMusic(17);
                    gameH.aSetter.setObject();
                } else if (gameH.mapType == 3) {
                    gameH.map = gameH.availableMaps[0];
                    gameH.mapType = 0;
                    gameH.playMusic(15);
                    gameH.aSetter.setObject();
                }

                gameH.gameState = gameH.playState;

                gameH.tileM.loadMap(gameH.map);

                // set Player
                gameH.player.worldY = 19 * gameH.tileSize;
                gameH.player.direction = "idle";
                // reset Movement
                gameH.keyH.wPressed = false;
                gameH.keyH.sPressed = false;
                gameH.keyH.aPressed = false;
                gameH.keyH.dPressed = false;
            }

        if (hit(19,17,"any")) {
            gameH.playSE(1);

            // set Player
            gameH.player.direction = "down";
            gameH.player.worldY = 17 * gameH.tileSize;
            gameH.player.worldX = 18 * gameH.tileSize;
            // reset Movement
            gameH.keyH.wPressed = false;
            gameH.keyH.sPressed = false;
            gameH.keyH.aPressed = false;
            gameH.keyH.dPressed = false;

            for(int i = 0; i<gameH.player.fabimonTeam.length; i++){
                if(gameH.player.fabimonTeam[i] != null){
                gameH.player.fabimonTeam[i].currentHp = gameH.player.fabimonTeam[i].hp;
                for(int j = 0; j<4; j++){
                    if(gameH.player.fabimonTeam[i].move[j] != null) {
                        gameH.player.fabimonTeam[i].move[j].currentap = gameH.player.fabimonTeam[i].move[j].ap;
                    }
                }
            }
            }

            gameH.gameState = gameH.healState;

        }


    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {

        boolean hit = false;

        gameH.player.solidArea.x = gameH.player.worldX + gameH.player.solidArea.x;
        gameH.player.solidArea.y = gameH.player.worldY + gameH.player.solidArea.y;
        eventRect.x = eventCol * gameH.tileSize + eventRect.x;
        eventRect.y = eventRow * gameH.tileSize + eventRect.y;

        if (gameH.player.solidArea.intersects(eventRect)) {
            if (gameH.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
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