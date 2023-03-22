package main;

import de.ralleytn.plugins.jinput.xinput.XInputEnvironmentPlugin;
import net.java.games.input.ControllerEnvironment;

public class XKontroller {

    public void VerbindeXKontroller(){
        ControllerEnvironment environment = new XInputEnvironmentPlugin();
        if(!environment.isSupported()) {

            environment = ControllerEnvironment.getDefaultEnvironment();
        }

    }
}
