package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class GrassType extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public GrassType(GameHandler gameH){
        super(gameH);
        getGrassTypeimage();

    }
    public void getGrassTypeimage(){
        imageH.ImageInitializer(0, "Fabimon/Grass Type", "GrassType", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
