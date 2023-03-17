package main;

import net.java.games.input.*;

public class Kontroller {



    Boolean test;

    public void connectcontroller() {


        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        Controller controller = null;

        for (Controller value : controllers) {
            if (value.getType() == Controller.Type.GAMEPAD)
                controller = value;
        }

        EventQueue eventQueue = controller.getEventQueue();
        Event event = new Event();
        Boolean stopped = false;
        test = true;

        while (!stopped) {
            controller.poll();
            test = controller.poll();

            if (!test) {
                System.out.println("test");

                DirectAndRawInputEnvironmentPlugin directEnv = new DirectAndRawInputEnvironmentPlugin();
                if (directEnv.isSupported()) {
                    controllers = directEnv.getControllers();
                } else {
                    controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
                }

                for (Controller value : controllers) {
                    if (value.getType() == Controller.Type.GAMEPAD)
                        controller = value;
                }

                eventQueue = controller.getEventQueue();
                event = new Event();
            } else {


                eventQueue.getNextEvent(event);

                Component component = event.getComponent();

                if (component != null) {
                    Component.Identifier identifier = component.getIdentifier();
                    float data = component.getPollData();
                    if (identifier == Component.Identifier.Button._0) {
                        System.out.println(data);
                    } else if (identifier == Component.Identifier.Axis.RZ) {
                        if (data > 0.2 || data < -0.2) {
                            System.out.println(data);
                        }

                    } else if (identifier == Component.Identifier.Axis.Z) {
                        if (data > 0.2 || data < -0.2) {
                            System.out.println(data);
                        }
                    } else if (identifier == Component.Identifier.Axis.X) {
                        if (data > 0.2 || data < -0.2) {
                            System.out.println(data);
                        }
                    } else if (identifier == Component.Identifier.Axis.Y) {
                        if (data > 0.2 || data < -0.2) {
                            System.out.println(data);
                        }
                    }

                }
            }
        }

    }
}
