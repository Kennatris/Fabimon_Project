package main.control;

import net.java.games.input.*;

import java.util.Arrays;

public class Kontroller {
    public Boolean viereck = false;
    public Boolean dreieck = false;
    public Boolean kreis = false;
    public Boolean kreuz = false;
    public Boolean rTrigger = false;
    public Boolean lTrigger = false;
    public Boolean rBumper = false;
    public Boolean lBumper = false;
    public Boolean start = false;
    public Boolean select = false;
    public Boolean[] d_Pad = new Boolean[8];
    public Controller[] controllers;
    Controller controller;
    EventQueue eventQueue;
    Event event;
    Boolean istVerbunden;

    public Kontroller() {
        Arrays.fill(d_Pad, 0, 8, false);
    }

    public void verbindeKontroller() {
        try {
            controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();   //Speichert alle Controller die es findet im Array controllers ab.
            controller = null;

            for (Controller value : controllers) {      //Filtert im Array nach controller vom Typ Gamepad oder STICK und speichert diese in controller ab.
                if (value.getType() == Controller.Type.STICK || value.getType() == Controller.Type.GAMEPAD)
                    controller = value;
            }

            eventQueue = controller.getEventQueue();    //erstellt eine art Warteliste für den Input
            event = new Event();
            istVerbunden = true;
        } catch (Exception e) {

        }

    }

    private void NeuVerbinden() {       //Macht dasselbe wie VerbindeKontroller()
        DirectAndRawInputEnvironmentPlugin directEnv = new DirectAndRawInputEnvironmentPlugin();
        if (directEnv.isSupported()) {
            controllers = directEnv.getControllers();
        } else {
            controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        }

        for (Controller value : controllers) {
            if (value.getType() == Controller.Type.STICK || value.getType() == Controller.Type.GAMEPAD)
                controller = value;
        }

        eventQueue = controller.getEventQueue();
        event = new Event();
    }

    private void TesteVerbindung() {
        istVerbunden = controller.poll();       //Prüft, ob ein Kontroller Verbunden ist.
        if (!istVerbunden) {
            NeuVerbinden();     //Falls kein Kontroller verbunden ist, wird diese Methode ausgeführt.
        }

    }

    public void gamepad() {
        TesteVerbindung();

        while (eventQueue.getNextEvent(event)) {    //Macht weiter so lange es Events gibt.

            Component component = event.getComponent();     //Speichert den Komponent ab der den event ausgelöst hat.

            if (component != null) {
                Component.Identifier identifier = component.getIdentifier();    //Identifiziert den Komponent.
                float data = component.getPollData();   //Fragt nach Daten vom Komponent.

                if (identifier == Component.Identifier.Axis.POV) {      //Überprüft welche Taste gedrückt wurde.
                    if (data == 0.25) {

                        d_Pad[0] = true;
                    } else if (data == 0.5) {

                        d_Pad[1] = true;
                    } else if (data == 0.75) {

                        d_Pad[2] = true;
                    } else if (data == 1) {

                        d_Pad[3] = true;
                    } else if (data == 0.125) {

                        d_Pad[4] = true;
                    } else if (data == 0.375) {

                        d_Pad[5] = true;
                    } else if (data == 0.875) {

                        d_Pad[6] = true;
                    } else if (data == 0.625) {

                        d_Pad[7] = true;
                    } else if (data == 0) {
                        Arrays.fill(d_Pad, 0, 8, false);
                    }

                }
                if (identifier == Component.Identifier.Button._0) {

                    viereck = data == 1;
                } else if (identifier == Component.Identifier.Button._1) {

                    kreuz = data == 1;
                } else if (identifier == Component.Identifier.Button._2) {

                    kreis = data == 1;
                } else if (identifier == Component.Identifier.Button._3) {

                    dreieck = data == 1;
                } else if (identifier == Component.Identifier.Button._4) {

                    lBumper = data == 1;
                } else if (identifier == Component.Identifier.Button._5) {

                    rBumper = data == 1;
                } else if (identifier == Component.Identifier.Button._6) {

                    lTrigger = data == 1;
                } else if (identifier == Component.Identifier.Button._7) {

                    rTrigger = data == 1;
                } else if (identifier == Component.Identifier.Button._8) {

                    select = data == 1;
                } else if (identifier == Component.Identifier.Button._9) {

                    start = data == 1;
                }
            }
        }
    }
}