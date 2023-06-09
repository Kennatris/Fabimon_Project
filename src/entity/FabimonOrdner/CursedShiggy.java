package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class CursedShiggy extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public CursedShiggy(GameHandler gameH){
        super(gameH);
        getcursedShiggyimage();

    }
    public void getcursedShiggyimage(){
        imageH.ImageInitializer(0, "Fabimon/cursed Shiggy", "cursed Shiggy", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        up2 = imageH.image[0];
        down1 = imageH.image[0];
        down2 = imageH.image[0];
        left1 = imageH.image[0];
    }
}
