package entity;


import main.GameHandler;
import main.ImageHandler;
import main.control.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    KeyHandler keyH;
    ImageHandler imageH = new ImageHandler();

    public final int screenX;
    public final int screenY;
    int standCounter = 0;

    public Player(GameHandler gameH, KeyHandler keyH) {

        super(gameH);

        this.keyH = keyH;

        screenX = gameH.screenWidth/2 - (gameH.tileSize/2);
        screenY = gameH.screenHeight/2 - (gameH.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = gameH.tileSize/2;
        solidArea.y = gameH.tileSize-(gameH.tileSize/8);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = gameH.tileSize/3; // hitbox width
        solidArea.height = gameH.tileSize/3; // hitbox height

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues () {

        worldX = gameH.playerPosX;
        worldY = gameH.playerPosY;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage() {

        imageH.ImageInitializer(0,"player","Skully_up_1","png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        imageH.ImageInitializer(1,"player","Skully_up_2","png", gameH.tileSize, gameH.tileSize);
        up2 = imageH.image[1];
        imageH.ImageInitializer(2,"player","Skully_down_1","png", gameH.tileSize, gameH.tileSize);
        down1 = imageH.image[2];
        imageH.ImageInitializer(3,"player","Skully_down_2","png", gameH.tileSize, gameH.tileSize);
        down2 = imageH.image[3];
        imageH.ImageInitializer(4,"player","Skully_left_1","png", gameH.tileSize, gameH.tileSize);
        left1 = imageH.image[4];
        imageH.ImageInitializer(5,"player","Skully_left_2","png", gameH.tileSize, gameH.tileSize);
        left2 = imageH.image[5];
        imageH.ImageInitializer(6,"player","Skully_right_1","png", gameH.tileSize, gameH.tileSize);
        right1 = imageH.image[6];
        imageH.ImageInitializer(7,"player","Skully_right_2","png", gameH.tileSize, gameH.tileSize);
        right2 = imageH.image[7];

    }

    public void update() {

        if(keyH.wPressed == true || keyH.sPressed == true || keyH.aPressed == true || keyH.dPressed == true) {

            if(keyH.wPressed == true) {
                direction = "up";

//				playerY = playerY - playerSpeed;
            } else if(keyH.sPressed == true) {
                direction = "down";

            } else if(keyH.aPressed == true) {
                direction = "left";

            } else if(keyH.dPressed == true) {
                direction = "right";

            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gameH.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gameH.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gameH.cChecker.checkEntity(this, gameH.npc);
            interactNPC(npcIndex);


            // CHECK EVENT
            gameH.eHandler.checkEvent();

            gameH.keyH.spacePressed = false;

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false) {

                switch(direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
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

        } else {
            standCounter++;
            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
        }

    }

    public void pickUpObject(int i) {

        if(i != 999) {

        }

    }

    public void interactNPC(int i) {

        if(i != 999) {

            // NPC code
            // ...

        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

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

        g2.drawImage(image, screenX, screenY, null);
    }
}