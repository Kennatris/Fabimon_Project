package settings;

import entity.Player;
import main.GameHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class SaveCompiler {
    Settings settings = new Settings();
    GameHandler gameH;
    Player player;

    // all available Variables
    public int screenWidth_us, screenHeight_us, playerPosX_us, playerPosY_us;
    public boolean fullscreen_us, keyboard_us;
    public float musicVolume_us, soundVolume_us;

    public void SaveReader(GameHandler gameH, String fileName) {

        try {
            String fileLocation = "res/saves/" + fileName + ".txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);

            int parameter = 0; // column and stat at the same time
            String line;

            while(parameter < settings.savableVARS) {
                line = br.readLine();
                switch (parameter) {
                    case 0:
                        fullscreen_us = Boolean.parseBoolean(line);

                        System.out.println("fullscreen: " + line);

                        break;
                    case 1:
                        screenWidth_us = Integer.parseInt(line);

                        System.out.println("screenWidth: " + line);

                        break;
                    case 2:
                        screenHeight_us = Integer.parseInt(line);

                        System.out.println("screenHeight: " + line);

                        break;
                    case 3:
                        playerPosX_us = Integer.parseInt(line);

                        System.out.println("playerPosX: " + line);

                        break;
                    case 4:
                        playerPosY_us = Integer.parseInt(line);

                        System.out.println("playerPosY: " + line);

                        break;
                    case 5:
                        keyboard_us = Boolean.parseBoolean(line);

                        System.out.println("keyboard: " + line);

                        break;
                    case 6:
                        musicVolume_us = Float.parseFloat(line);

                        System.out.println("musicVolume: " + line);

                        break;
                    case 7:
                        soundVolume_us = Float.parseFloat(line);

                        System.out.println("soundVolume: " + line);

                        break;
                    case 8:
                        System.out.println("End of Line");
                        break;
                }

                parameter++;
            }

        } catch(Exception e) {
            System.out.println(e);
        }

        settings.installSettings(gameH, fullscreen_us, screenWidth_us, screenHeight_us, playerPosX_us, playerPosY_us, keyboard_us, musicVolume_us, soundVolume_us);

    }

    public void SaveWriter() {

    }

}
