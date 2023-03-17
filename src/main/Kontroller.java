package main;

import net.java.games.input.*;

public class Kontroller {
    public Boolean viereck, dreieck, kreis, kreuz, rTrigger, lTrigger, rBumper,
            lBumper, rJoystick, lJoystick, rJoystick_rechts, rJoystick_links, rJoystick_unten,
            rJoystick_oben, lJoystick_rechts, lJoystick_links, lJoystick_unten, lJoystick_oben,
            start, select, d_Pad_oben, d_Pad_unten, d_Pad_rechts, d_Pad_links = false;
    Controller[] controllers;
    Controller controller;
    EventQueue eventQueue;
    Event event;
    Boolean test;

    public Kontroller() {
    }

    public void VerbindeKontroller() {

        controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        controller = null;

        for (Controller value : controllers) {
            if (value.getType() == Controller.Type.GAMEPAD)
                controller = value;
        }

        eventQueue = controller.getEventQueue();
        event = new Event();
        test = true;

    }

    public void NeuVerbinden() {
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
    }

    public void TesteVerbindung() {
        test = controller.poll();
        if (!test) {
            NeuVerbinden();
        }

    }

    void KontrollerEvent() {


        TesteVerbindung();

        eventQueue.getNextEvent(event);

        Component component = event.getComponent();

        if (component != null) {
            Component.Identifier identifier = component.getIdentifier();
            float data = component.getPollData();
            if (identifier == Component.Identifier.Axis.POV) {
                System.out.println(data);
                if (data == 0.25) {
                    d_Pad_oben = true;
                } else if (data == 0.5) {
                    d_Pad_rechts = true;
                } else if (data == 0.75) {
                    d_Pad_unten = true;
                } else if (data == 1) {
                    d_Pad_links = true;
                }
            }
            if (identifier == Component.Identifier.Button._0) {
                System.out.println("test");
                viereck = true;
            } else if (identifier == Component.Identifier.Button._1) {
                System.out.println("test");
                kreuz = true;
            } else if (identifier == Component.Identifier.Button._2) {
                System.out.println("test");
                kreis = true;
            } else if (identifier == Component.Identifier.Button._3) {
                System.out.println("test");
                dreieck = true;
            } else if (identifier == Component.Identifier.Button._4) {
                System.out.println("test");
                lBumper = true;
            } else if (identifier == Component.Identifier.Button._5) {
                System.out.println("test");
                rBumper = true;
            } else if (identifier == Component.Identifier.Button._6) {
                System.out.println("test");
                lTrigger = true;
            } else if (identifier == Component.Identifier.Button._7) {
                System.out.println("test");
                rTrigger = true;
            } else if (identifier == Component.Identifier.Button._8) {
                System.out.println("test");
                select = true;
            } else if (identifier == Component.Identifier.Button._9) {
                System.out.println("test");
                start = true;
            } else if (identifier == Component.Identifier.Button._10) {
                System.out.println("test");
                lJoystick = true;
            } else if (identifier == Component.Identifier.Button._11) {
                System.out.println("test");
                rJoystick = true;
            } else if (identifier == Component.Identifier.Axis.RZ) {
                if (data > 0.2) {
                    System.out.println(data);
                    rJoystick_unten = true;
                } else if (data < -0.2) {
                    System.out.println(data);
                    rJoystick_oben = true;
                }
            } else if (identifier == Component.Identifier.Axis.Z) {
                if (data > 0.2) {
                    System.out.println(data);
                    rJoystick_rechts = true;
                } else if (data < -0.2) {
                    System.out.println(data);
                    rJoystick_links = true;
                }
            } else if (identifier == Component.Identifier.Axis.X) {
                if (data > 0.2) {
                    System.out.println(data);
                    lJoystick_rechts = true;
                } else if (data < -0.2) {
                    System.out.println(data);
                    lJoystick_links = true;
                }
            } else if (identifier == Component.Identifier.Axis.Y) {
                if (data > 0.2) {
                    System.out.println(data);
                    lJoystick_unten = true;
                } else if (data < -0.2) {
                    System.out.println(data);
                    lJoystick_oben = true;
                }
            }
        }

    }
}