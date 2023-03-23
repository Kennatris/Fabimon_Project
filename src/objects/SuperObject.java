package objects;

import main.GameHandler;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, GameHandler gameH) {

        int screenX = worldX - gameH.player.worldX + gameH.player.screenX;
        int screenY = worldY - gameH.player.worldY + gameH.player.screenY;

        if(worldX + gameH.tileSize > gameH.player.worldX - gameH.player.screenX &&
                worldX - gameH.tileSize < gameH.player.worldX + gameH.player.screenX &&
                worldY + gameH.tileSize > gameH.player.worldY - gameH.player.screenY &&
                worldY - gameH.tileSize < gameH.player.worldY + gameH.player.screenY) {

            g2.drawImage(image, screenX, screenY, gameH.tileSize, gameH.tileSize, null);

        }

    }

}