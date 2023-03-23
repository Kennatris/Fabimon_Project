package entity;

import main.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GameHandler gameH;
    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // 48 size of the hitbox
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void update() {

        collisionOn = false;
        gameH.cChecker.checkTile(this);
        gameH.cChecker.checkObject(this, false);
        gameH.cChecker.checkPlayer(this);

        // IF COLLISION IS FALSE, NPC CAN MOVE
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

    public void draw(Graphics2D g2) {

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