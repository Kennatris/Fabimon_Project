package settings;

import entity.Player;
import main.GameHandler;

import java.io.*;

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
            File f = new File("res/saves/" + fileName + ".txt");

            if (gameH.debugMode) {
                System.out.println(f.getPath());
            }

            if (f.exists() == false) {
                fileName = "save_Default";
            }
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
            if (gameH.debugMode) {
                System.out.println("Error-ReadFile: " + e);
            }
        }

            settings.installSettings(gameH, fullscreen_us, screenWidth_us, screenHeight_us, playerPosX_us, playerPosY_us, keyboard_us, musicVolume_us, soundVolume_us);

    }

    public void SaveWriter(GameHandler gameH, String fileName) {

        String fileLocation = "res/saves/" + fileName + ".txt";
        File f = new File(fileLocation);

        try {
            if (f.exists()) {
                FileWriter fw = new FileWriter(fileLocation);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(String.valueOf(gameH.fullscreen));
                bw.newLine();
                bw.write(String.valueOf(gameH.screenWidth));
                bw.newLine();
                bw.write(String.valueOf(gameH.screenHeight));
                bw.newLine();
                bw.write(String.valueOf(gameH.playerPosX/gameH.tileSize));
                bw.newLine();
                bw.write(String.valueOf(gameH.playerPosY/gameH.tileSize));
                bw.newLine();
                bw.write(String.valueOf(gameH.keyboard));
                bw.newLine();
                bw.write(String.valueOf(gameH.musicVolume));
                bw.newLine();
                bw.write(String.valueOf(gameH.soundVolume));
                bw.newLine();

                bw.close();

                if (gameH.debugMode) {
                    System.out.println("FileLocation: " + fileLocation);
                    System.out.println("Data was Written");
                }

            } else {
                System.out.println("Error-WriteFile: ");
            }

        } catch (Exception e) {
            if (gameH.debugMode) {
                System.out.println("Error-WriteFile: " + e);
            }
        }

    }

}
