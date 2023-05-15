package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class cursedShiggy extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public cursedShiggy(GameHandler gameH, String fabimonName, int fabimonEvo, int plevel){
        super(gameH);
        getcursedShiggyimage();

    }
    public void getcursedShiggyimage(){
        imageH.ImageInitializer(0, "Fabimon/cursed Shiggy", "cursed Shiggy", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
