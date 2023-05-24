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
                        default:
                            for(int i = 1; i<gameH.player.fabimonTeam.length+1; i++){
                                    unsavedString[i][0] = line;
                                    line = br.readLine();
                                    unsavedString[i][1] = line;
                                    line = br.readLine();
                                    unsavedString[i][2] = line;
                                    line =  br.readLine();
                                    unsavedString[i][3] = line;
                                    line =  br.readLine();
                                    unsavedInt[i][0] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][1] = Integer.parseInt(line);
                                    line = br.readLine();
                                    unsavedInt[i][2] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][3] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][4] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][5] = Integer.parseInt(line);
                                    line = br.readLine();
                                    unsavedInt[i][6] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][7] = Integer.parseInt(line);
                                    line =   br.readLine();
                                    unsavedInt[i][8] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][9] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][10] = Integer.parseInt(line);
                                    line =   br.readLine();
                                    unsavedInt[i][11] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][12] = Integer.parseInt(line);
                                    line =   br.readLine();
                                    unsavedInt[i][13] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][14] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedString[i][4] = line;
                                    line =  br.readLine();
                                    unsavedString[i][5] = line;
                                    line =  br.readLine();
                                    unsavedString[i][6] = line;
                                    line = br.readLine();
                                    unsavedString[i][7] = line;
                                    line =  br.readLine();
                                    unsavedInt[i][15] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][16] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][17] = Integer.parseInt(line);
                                    line =  br.readLine();
                                    unsavedInt[i][18] = Integer.parseInt(line);
                                    line = br.readLine();
                            }
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
        String psinfo[] = new String[4];
        String move[] = new String[4];
        int pap[] =new int[4];
        int pev[] = new int[6];
        int piv[] = new int[6];
        int pinfo[] = new int[3];
        for(int i = 1; i< gameH.player.fabimonTeam.length+1; i++) {

           if(unsavedString[i][0].equals("nichts")) {

           }else{
               for (int j = 0; j < 4; j++) {
                   psinfo[j] = unsavedString[i][j];
                   move[j] = unsavedString[i][4 + j];
                   pap[j] = unsavedInt[i][15 + j];
               }
               for (int j = 0; j < 3; j++) {
                   pinfo[j] = unsavedInt[i][j];
               }
               for (int j = 0; j < 6; j++) {
                   pev[j] = unsavedInt[i][3 + j];
                   piv[j] = unsavedInt[i][9 + j];
               }
               gameH.fabimon.setPlayerFabimon(i-1, psinfo, move, pap, pev, piv, pinfo);
           }
        }
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
                //bw.write(String.valueOf(gameH.screenWidth));
                bw.write(String.valueOf(1152));
                bw.newLine();
                //bw.write(String.valueOf(gameH.screenHeight));
                bw.write(String.valueOf(567));
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
                for(int i = 0; i < gameH.player.fabimonTeam.length; i++){
                    if(gameH.player.fabimonTeam[i] != null) {
                        bw.write(gameH.player.fabimonTeam[i].name);
                        bw.newLine();
                        bw.write(gameH.player.fabimonTeam[i].item);
                        bw.newLine();
                        bw.write(gameH.player.fabimonTeam[i].gender);
                        bw.newLine();
                        bw.write(gameH.player.fabimonTeam[i].nature);
                        bw.newLine();
                        bw.write(String.valueOf(gameH.player.fabimonTeam[i].level));
                        bw.newLine();
                        bw.write(String.valueOf(gameH.player.fabimonTeam[i].currentHp));
                        bw.newLine();
                        bw.write(String.valueOf(gameH.player.fabimonTeam[i].currentEp));
                        bw.newLine();
                        for (int j = 0; j < gameH.player.fabimonTeam[i].haveEV.length; j++) {
                            bw.write(String.valueOf(gameH.player.fabimonTeam[i].haveEV[j]));
                            bw.newLine();
                        }
                        for (int j = 0; j < gameH.player.fabimonTeam[i].iv.length; j++) {
                            bw.write(String.valueOf(gameH.player.fabimonTeam[i].iv[j]));
                            bw.newLine();
                        }
                        for (int j = 0; j < gameH.player.fabimonTeam[i].move.length; j++) {
                            bw.write(gameH.player.fabimonTeam[i].move[j].name);
                            bw.newLine();
                        }
                        for(int j = 0; j< gameH.player.fabimonTeam[i].move.length; j++){
                            bw.write(String.valueOf(gameH.player.fabimonTeam[i].move[j].currentap));
                            bw.newLine();
                        }
                    }else{
                        bw.write("nichts");
                        bw.newLine();
                        bw.write("nichts");
                        bw.newLine();
                        bw.write("nichts");
                        bw.newLine();
                        bw.write("nichts");
                        bw.newLine();
                        bw.write("1");
                        bw.newLine();
                        bw.write("1");
                        bw.newLine();
                        bw.write("1");
                        bw.newLine();
                        for (int j = 0; j < 6; j++) {
                            bw.write("0");
                            bw.newLine();
                        }
                        for (int j = 0; j < 6; j++) {
                            bw.write("0");
                            bw.newLine();
                        }
                        for (int j = 0; j < 4; j++) {
                            bw.write("nichts");
                            bw.newLine();
                        }
                        for (int j = 0; j < 4; j++) {
                            bw.write("0");
                            bw.newLine();
                        }
                    }
                }
                // ENTITY SHIT = FABIO SHIT
                // NPC SHIT = FABIO SHIT
                for (int i = 0; i < gameH.npc.length; i++) {
                    if (gameH.npc[i] != null) {
                        for (int j = 0; j < entitySavableINT; j++) {
                            //unsavedInt[i+1][j];
                            bw.write(String.valueOf(unsavedInt[i+1][j]));
                        }
                        for (int j = 0; j < entitySavableBOOLEAN; j++) {
                            //unsavedBoolean[i+1][j];
                            bw.write(String.valueOf(unsavedBoolean[i+1][j]));
                        }
                        for (int j = 0; j < entitySavableFLOAT; j++) {
                            //unsavedFloat[i+1][j];
                            bw.write(String.valueOf(unsavedFloat[i+1][j]));
                        }
                        for (int j = 0; j < entitySavableSTRING; j++) {
                            //unsavedString[i+1][j];
                            bw.write(String.valueOf(unsavedString[i+1][j]));
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
