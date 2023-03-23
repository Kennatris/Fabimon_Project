package main;

public class Main {
    public static void main(String[] args) {

        // initializer
        GameHandler gameH = new GameHandler();

        // start and config GameHandler
        gameH.setupGame();
        gameH.startGameThread();

    }
}