package entity;

import main.GameHandler;
import main.ImageHandler;

public class cursedShiggy extends Fabimon{
    ImageHandler imageH = new ImageHandler();
    public cursedShiggy(GameHandler gameH){
        super(gameH);
        getcursedShiggyimage();
    }
    public void getcursedShiggyimage(){
        imageH.ImageInitializer(0, "Fabimon/cursed Shiggy", "cursed Shiggy", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
