package objects;

import main.GameHandler;

public class Object_arenaPortal extends SuperObject{

    public Object_arenaPortal(GameHandler gameH) {
        name = "arenaPortal";
        imageH.ImageInitializer(0, "objects", "portal", "png", 96, 96);
        image = imageH.image[0];
        collision = true;
    }

}
