package entity;


import main.GameHandler;
import main.ImageHandler;


public class NPCTest extends Entity{
    ImageHandler imageH = new ImageHandler();

  public  NPCTest(GameHandler gameH){
      super(gameH);

      this.direction = "right";
      this.speed = 10;
      this.map = gameH.availableMaps[0];

      getTestNPCImage();
  }

    public void getTestNPCImage() {
        imageH.ImageInitializer(0,"NPC","uparrow","png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        imageH.ImageInitializer(1,"NPC","uparrow2","png", gameH.tileSize, gameH.tileSize);
        up2 = imageH.image[1];
        imageH.ImageInitializer(2,"NPC","downarrow","png", gameH.tileSize, gameH.tileSize);
        down1 = imageH.image[2];
        imageH.ImageInitializer(3,"NPC","downarrow2","png", gameH.tileSize, gameH.tileSize);
        down2 = imageH.image[3];
        imageH.ImageInitializer(4,"NPC","leftarrow","png", gameH.tileSize, gameH.tileSize);
        left1 = imageH.image[4];
        imageH.ImageInitializer(5,"NPC","leftarrow2","png", gameH.tileSize, gameH.tileSize);
        left2 = imageH.image[5];
        imageH.ImageInitializer(6,"NPC","rightarrow","png", gameH.tileSize, gameH.tileSize);
        right1 = imageH.image[6];
        imageH.ImageInitializer(7,"NPC","rightarrow2","png", gameH.tileSize, gameH.tileSize);
        right2 = imageH.image[7];
    }
    public void setAction(){
      if(gameH.npc[0].worldX > gameH.tileSize*24){
            direction = "left";
      }
      else if(gameH.npc[0].worldX <gameH.tileSize*12){
          direction = "right";
      }
    }
}
