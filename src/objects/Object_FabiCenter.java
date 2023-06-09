package objects;

import main.GameHandler;

public class Object_FabiCenter  extends SuperObject{

    public Object_FabiCenter(GameHandler gameH) {
        name = "fabiCenter";
        imageH.ImageInitializer(0, "objects", "FabiCenter", "png", 96, 96);
        image = imageH.image[0];
        collision = true;
    }

}
