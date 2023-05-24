package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class Jubby extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public Jubby(GameHandler gameH){
        super(gameH);
        getJubbyimage();

    }
    public void getJubbyimage(){
        imageH.ImageInitializer(0, "Fabimon/Jubby", "Jubby", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
