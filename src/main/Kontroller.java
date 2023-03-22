package main;

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
    Controller[] controllers;
    Controller controller;
    EventQueue eventQueue;
    Event event;
    Boolean istVerbunden;

    public Kontroller() {
        Arrays.fill(d_Pad, 0, 8, false);
    }

    public void VerbindeKontroller() {

        controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();   //Сохраняет все контроллеры, которые он находит в контроллерах массива. Speichert alle Controller die es findet im Array controllers ab.
        controller = null;

        for (Controller value : controllers) {      //Фильтрует массив для контроллеров типа Gamepad или STICK и сохраняет их в контроллере. Filtert im Array nach controller vom Typ Gamepad oder STICK und speichert diese in controller ab.
            if (value.getType() == Controller.Type.STICK || value.getType() == Controller.Type.GAMEPAD)
                controller = value;
        }

        eventQueue = controller.getEventQueue();    //создает своего рода список ожидания для ввода erstellt eine art Warteliste für den Input
        event = new Event();
        istVerbunden = true;

    }

    private void NeuVerbinden() {       //Делает то же самое, что и ConnectController(). Macht dasselbe wie VerbindeKontroller()
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

    public void TesteVerbindung() {
        istVerbunden = controller.poll();       //Проверяет, подключен ли контроллер. Prüft, ob ein Kontroller Verbunden ist.
        if (!istVerbunden) {
            NeuVerbinden();     //Если контроллер не подключен, этот метод будет выполнен. Falls kein Kontroller verbunden ist, wird diese Methode ausgeführt.
        }

    }


    public void KontrollerCheck() {     //Ищет, какой тип контроллера подключен, и выполняет соответствующий метод для запроса входных данных. Schaut nach welche art von controller angeschlossen ist und führt die jeweilige Methode aus zum Abfragen der Inputs.
        TesteVerbindung();

        while (eventQueue.getNextEvent(event)) {    //Продолжайте, пока есть события. Macht weiter so lange es Events gibt.

            Component component = event.getComponent();     //Сохраняет компонент, вызвавший событие. Speichert den Komponent ab der den event ausgelöst hat.

            if (component != null) {
                Component.Identifier identifier = component.getIdentifier();    //Идентифицирует компонент. Identifiziert den Komponent.
                float data = component.getPollData();   //Запрашивает данные у компонента. Fragt nach Daten vom Komponent.

                if (identifier == Component.Identifier.Axis.POV) {      //Проверяет, какая клавиша была нажата. Überprüft welche Taste gedrückt wurde.
                    System.out.println(data);
                    if (data == 0.25) {
                        System.out.println("oben");
                        d_Pad[0] = true;
                    } else if (data == 0.5) {
                        System.out.println("rechts");
                        d_Pad[1] = true;
                    } else if (data == 0.75) {
                        System.out.println("unten");
                        d_Pad[2] = true;
                    } else if (data == 1) {
                        System.out.println("links");
                        d_Pad[3] = true;
                    } else if (data == 0.125) {
                        System.out.println("oben links");
                        d_Pad[4] = true;
                    } else if (data == 0.375) {
                        System.out.println("oben rechts");
                        d_Pad[5] = true;
                    } else if (data == 0.875) {
                        System.out.println("unten links");
                        d_Pad[6] = true;
                    } else if (data == 0.625) {
                        System.out.println("unten rechts");
                        d_Pad[7] = true;
                    } else if (data == 0) {
                        Arrays.fill(d_Pad, 0, 8, false);
                    }

                }
                if (identifier == Component.Identifier.Button._0) {
                    System.out.println("test0");
                    viereck = data == 1;
                } else if (identifier == Component.Identifier.Button._1) {
                    System.out.println("test1");
                    kreuz = data == 1;
                } else if (identifier == Component.Identifier.Button._2) {
                    System.out.println("test2");
                    kreis = data == 1;
                } else if (identifier == Component.Identifier.Button._3) {
                    System.out.println("test3");
                    dreieck = data == 1;
                } else if (identifier == Component.Identifier.Button._4) {
                    System.out.println("test4");
                    lBumper = data == 1;
                } else if (identifier == Component.Identifier.Button._5) {
                    System.out.println("test5");
                    rBumper = data == 1;
                } else if (identifier == Component.Identifier.Button._6) {
                    System.out.println("test6");
                    lTrigger = data == 1;
                } else if (identifier == Component.Identifier.Button._7) {
                    System.out.println("test7");
                    rTrigger = data == 1;
                } else if (identifier == Component.Identifier.Button._8) {
                    System.out.println("test8");
                    select = data == 1;
                } else if (identifier == Component.Identifier.Button._9) {
                    System.out.println("test9");
                    start = data == 1;
                }
            }
        }
    }
}