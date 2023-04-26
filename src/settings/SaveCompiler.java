package settings;

import main.GameHandler;

import java.io.*;
// tmp
public class SaveCompiler extends Settings{
    public void SaveReader(GameHandler gameH, String fileName) {

        try {
            File f = new File("res/saves/" + fileName + gameH.fileTyp);

            if (gameH.debugMode) {
                System.out.println(f.getPath());
            }

            if (!f.exists()) {
                fileName = "save_Default";
            }
            String fileLocation = "res/saves/" + fileName + gameH.fileTyp;

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);
            int parameter = 0; // column and stat at the same time
            boolean last = false;
            String line;

            while(!last) {
                line = br.readLine();
                if (gameH.debugMode) {
                    System.out.println("Line Input: " + line);
                }


                if (parameter >= 0 && parameter <= systemSavable) {
                    switch (parameter) {
                        case 0:
                            unsavedBoolean[0][0] = Boolean.parseBoolean(line);
                            if (gameH.debugMode) {
                                System.out.println(">>> Start of System Settings <<<");
                                System.out.println("Fullscreen: " + line);
                            }
                            break;
                        case 1:
                            unsavedInt[0][0] = Integer.parseInt(line);
                            if (gameH.debugMode) {
                                System.out.println("Screen Width: " + line);
                            }
                            break;
                        case 2:
                            unsavedInt[0][1] = Integer.parseInt(line);
                            if (gameH.debugMode) {
                                System.out.println("Screen Height: " + line);
                            }
                            break;
                        case 3:
                            unsavedInt[0][2] = Integer.parseInt(line);
                            if (gameH.debugMode) {
                                System.out.println("Player Pos X: " + line);
                            }
                            break;
                        case 4:
                            unsavedInt[0][3] = Integer.parseInt(line);
                            if (gameH.debugMode) {
                                System.out.println("Player Pos Y: " + line);
                            }
                            break;
                        case 5:
                            unsavedBoolean[0][1] = Boolean.parseBoolean(line);
                            if (gameH.debugMode) {
                                System.out.println("Keyboard: " + line);
                            }
                            break;
                        case 6:
                            unsavedFloat[0][0] = Float.parseFloat(line);
                            if (gameH.debugMode) {
                                System.out.println("Music Volume: " + line);
                            }
                            break;
                        case 7:
                            unsavedFloat[0][1] = Float.parseFloat(line);
                            if (gameH.debugMode) {
                                System.out.println("Sound Volume: " + line);
                            }
                            break;
                        case 8:
                            unsavedString[0][0] = line;
                            if (gameH.debugMode) {
                                System.out.println("Loaded Map: " + line);
                                System.out.println(">>> End of System Settings <<<");
                            }
                            break;
                    }
                }

                if (parameter >= systemSavable + 1) {
                    for (int i = 0; i < gameH.npc.length; i++) {
                        if (gameH.npc[i] != null) {
                            for (int j = 0; j < entitySavableINT; j++) {
                                line = br.readLine();
                                unsavedInt[i+1][j] = Integer.parseInt(line);
                                parameter++;
                            }
                            for (int j = 0; j < entitySavableBOOLEAN; j++) {
                                line = br.readLine();
                                unsavedBoolean[i+1][j] = Boolean.parseBoolean(line);
                                parameter++;
                            }
                            for (int j = 0; j < entitySavableFLOAT; j++) {
                                line = br.readLine();
                                unsavedFloat[i+1][j] = Float.parseFloat(line);
                                parameter++;
                            }
                            for (int j = 0; j < entitySavableSTRING; j++) {
                                line = br.readLine();
                                unsavedString[i+1][j] = line;
                                parameter++;
                            }
                        }
                    }
                }

                if (line == null) {
                    last = true;
                } else {
                    parameter++;
                }
            }

        } catch(Exception e) {
            if (gameH.debugMode) {
                System.out.println("Error-ReadFile: " + e);
            }
        }

        installSettings(gameH, unsavedBoolean, unsavedInt, unsavedFloat, unsavedString);
    }

    public void SaveWriter(GameHandler gameH, String fileName) {

        String fileLocation = "res/saves/" + fileName + gameH.fileTyp;
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
                bw.write(String.valueOf(gameH.player.worldX/gameH.tileSize));
                bw.newLine();
                bw.write(String.valueOf(gameH.player.worldY/gameH.tileSize));
                bw.newLine();
                bw.write(String.valueOf(gameH.keyboard));
                bw.newLine();
                bw.write(String.valueOf(gameH.musicVolume));
                bw.newLine();
                bw.write(String.valueOf(gameH.soundVolume));
                bw.newLine();
                bw.write(String.valueOf(gameH.map));
                bw.newLine();

                // ENTITY SHIT = FABIO SHIT
                // NPC SHIT = FABIO SHIT
                for (int i = 0; i < gameH.npc.length; i++) {
                    if (gameH.npc[i] != null) {
                        for (int j = 0; j < entitySavableINT; j++) {
                            //unsavedInt[i+1][j];
                        }
                        for (int j = 0; j < entitySavableBOOLEAN; j++) {
                            //unsavedBoolean[i+1][j];
                        }
                        for (int j = 0; j < entitySavableFLOAT; j++) {
                            //unsavedFloat[i+1][j];
                        }
                        for (int j = 0; j < entitySavableSTRING; j++) {
                            //unsavedString[i+1][j];
                        }
                    }
                }

                bw.close();

                if (gameH.debugMode) {
                    System.out.println(">>> Start Writing Data <<<");
                    System.out.println("FileLocation: " + fileLocation);
                    System.out.println(">>> Data has been Written <<<");
                }

            } else {
                if (gameH.debugMode) {
                    System.out.println("Error-WriteFile: file does not exist");
                }
            }

        } catch (Exception e) {
            if (gameH.debugMode) {
                System.out.println("Error-WriteFile: " + e);
            }
        }

    }

}
