package entity.FabimonOrdner;

import entity.Fabimon;
import main.GameHandler;
import main.ImageHandler;

public class ElectricType extends Fabimon {
    ImageHandler imageH = new ImageHandler();
    public ElectricType(GameHandler gameH){
        super(gameH);
        getElectricTypeimage();

    }
    public void getElectricTypeimage(){
        imageH.ImageInitializer(0, "Fabimon/Electric Type", "ElectricType", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
