package entity;

import main.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GameHandler gameH;
    public int worldX, worldY;
    public int speed;
    public int defaultspeed = 4;
    public Boolean isApproaching = false;
    public int originalWorldX, originalWorldY;
    public Boolean approached = false;
    public Boolean innactive = false;
    public Boolean drawing = true;
    public Boolean checkingVision = true;
    public Boolean updating = true;

    public String map;
    int turnTimer;
    int timer;
    int approachphase = 0;
    int innactiveTimer;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // 48 size of the hitbox
    public Rectangle visionArea = new Rectangle(0, 0, 48, 48);
    public int visionRangeUp, visionRangeRight, visionRangeLeft, visionRangeDown;
    public int solidAreaDefaultX, solidAreaDefaultY, visionAreaDefaultX, visionAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void setAction(){

    }
    public void endBattle(int i){
        gameH.gameState = gameH.playState;
        if(gameH.npc[i].speed == 0){
            gameH.npc[i].worldX = gameH.npc[i].originalWorldX *gameH.tileSize;
            gameH.npc[i].worldY = gameH.npc[i].originalWorldY *gameH.tileSize;
        }
        gameH.npc[i].isApproaching = false;
        gameH.player.beingApproached = false;
        gameH.npc[i].approached = false;
        gameH.npc[i].innactive = true ;
        approachphase = 0;
    }
    public void approach(int i){
        int abstand;
        gameH.npc[i].isApproaching = true;
        gameH.player.beingApproached = true;
        gameH.npcBattle=i;
        if( approachphase == 0){
            updating = false;
            gameH.csManager.csNum = gameH.csManager.ausrufezeichen;
            approachphase++;
            timer = 0;
        }else if(approachphase == 1){
            timer++;
            if(timer == 120){
                approachphase++;
                gameH.csManager.csNum = 0;
                timer = 0;
                updating = true;
            }
        }else if(approachphase == 2){


        if(gameH.npc[i].direction.equals("right")){
            abstand = gameH.player.worldX - gameH.npc[i].worldX-gameH.tileSize;
            if(gameH.npc[i].speed == 0){
                gameH.npc[i].worldX += gameH.npc[i].defaultspeed;
            }
                if(abstand<=0) {
                    gameH.csManager.csNum = gameH.csManager.battleBegin;

                    gameH.npc[i].approached = true;

                }
        }else if(gameH.npc[i].direction.equals("left")){
            abstand = gameH.npc[i].worldX-gameH.tileSize - gameH.player.worldX;
            if(gameH.npc[i].speed == 0){
                gameH.npc[i].worldX -= gameH.npc[i].defaultspeed;
            }
            if(abstand<=0) {

                gameH.csManager.csNum = gameH.csManager.battleBegin;
                gameH.npc[i].approached = true;
            }

        }else if(gameH.npc[i].direction.equals("up")){
            abstand = gameH.npc[i].worldY-gameH.tileSize- gameH.player.worldY;
            if(gameH.npc[i].speed == 0){
                gameH.npc[i].worldY -= gameH.npc[i].defaultspeed;
            }
            if(abstand<=0) {

                gameH.csManager.csNum = gameH.csManager.battleBegin;
                gameH.npc[i].approached = true;

            }

        }else if(gameH.npc[i].direction.equals("down")){
            abstand = gameH.player.worldY-gameH.tileSize - gameH.npc[i].worldY;
            if(gameH.npc[i].speed == 0 && abstand > 0){
                gameH.npc[i].worldY += gameH.npc[i].defaultspeed;
            }
            if(abstand<=0) {
                gameH.csManager.csNum = gameH.csManager.battleBegin;
                gameH.npc[i].approached = true;
            }
        }}
    }

    public void innactivechecker(){
        if(!innactive){
            return;
        }else{
            checkingVision = false;
            updating = false;
            innactiveTimer++;
            if(innactiveTimer%10 == 0){
                drawing = !drawing;
                if(innactiveTimer == 180){
                    innactive = false;
                    innactiveTimer = 0;
                    drawing = true;
                    checkingVision = true;
                    updating = true;
                }

            }
        }

    }

    public void update() {
        setAction();
        innactivechecker();

        collisionOn = false;
        gameH.cChecker.checkTile(this);
        gameH.cChecker.checkObject(this, false);
        gameH.cChecker.checkPlayer(this);

        // IF COLLISION IS FALSE, NPC CAN MOVE
        if(!approached && updating == true){
        if(!collisionOn) {

            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }


        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    }

    public void draw(Graphics2D g2) {

        if (gameH.map == map && drawing) {
            BufferedImage image = null;

            int screenX = worldX - gameH.player.worldX + gameH.player.screenX;
            int screenY = worldY - gameH.player.worldY + gameH.player.screenY;

            if(worldX + gameH.tileSize > gameH.player.worldX - gameH.player.screenX &&
                    worldX - gameH.tileSize < gameH.player.worldX + gameH.player.screenX &&
                    worldY + gameH.tileSize > gameH.player.worldY - gameH.player.screenY &&
                    worldY - gameH.tileSize < gameH.player.worldY + gameH.player.screenY) {

                switch (direction) {
                    case "up":
                        if(spriteNum == 1) {
                            image = up1;
                        }
                        if(spriteNum == 2) {
                            image = up2;
                        }
                        break;
                    case "down":
                        if(spriteNum == 1) {
                            image = down1;
                        }
                        if(spriteNum == 2) {
                            image = down2;
                        }
                        break;
                    case "left":
                        if(spriteNum == 1) {
                            image = left1;
                        }
                        if(spriteNum == 2) {
                            image = left2;
                        }
                        break;
                    case "right":
                        if(spriteNum == 1) {
                            image = right1;
                        }
                        if(spriteNum == 2) {
                            image = right2;
                        }
                        break;
                }

                g2.drawImage(image, screenX, screenY, gameH.tileSize, gameH.tileSize, null);

            }
        }

    }
}