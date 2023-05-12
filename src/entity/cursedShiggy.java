package entity;

import main.GameHandler;
import main.ImageHandler;

public class cursedShiggy extends Fabimon{
    ImageHandler imageH = new ImageHandler();
    public cursedShiggy(GameHandler gameH, String fabimonName, int fabimonEvo, int plevel){
        super(gameH);
        getcursedShiggyimage();
        setIV();
        tempFabimon.nature = nat.setNature();
        if(tempFabimon.nature.equals("redo")){
            tempFabimon.nature = nat.setNature();
        }
        getBaseInfo(fabimonName, fabimonEvo);
        setFabimonInfo(plevel);
    }
    public void getcursedShiggyimage(){
        imageH.ImageInitializer(0, "Fabimon/cursed Shiggy", "cursed Shiggy", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
    }
}
