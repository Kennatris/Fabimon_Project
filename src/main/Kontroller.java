package main;

import net.java.games.input.*;

public class Kontroller {
    public void controller() {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        Controller controller = null;

        for (int i = 0; i < controllers.length; i++) {
            if (controllers[i].getType() == Controller.Type.GAMEPAD)
                controller = controllers[i];
        }

        EventQueue eventQueue = controller.getEventQueue();
        Event event = new Event();
        Boolean stopped = false;

        while (!stopped) {
            controller.poll();
            eventQueue.getNextEvent(event);

            Component component = event.getComponent();

            if (component != null) {
                Component.Identifier identifier = component.getIdentifier();
                float data = component.getPollData();
                if (identifier == Component.Identifier.Button._0) {
                    System.out.println(data);
                } else if (identifier == Component.Identifier.Axis.RZ) {
                    System.out.println(data);
                }
            }


        }
    }
}
