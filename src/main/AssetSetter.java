package main;

import entity.NPCTest;
import objects.Object_FabiCenter;
import objects.Object_arenaPortal;

import java.io.BufferedReader;
import java.io.FileReader;

public class AssetSetter {

    GameHandler gameH;
    String[][] info = new String[10][12];

    public AssetSetter(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void setObject() {
        // arenaPortal
        gameH.obj[0] = new Object_arenaPortal(gameH);
        gameH.obj[0].worldX = gameH.tileSize * 24;
        gameH.obj[0].worldY = gameH.tileSize * 17;

        gameH.obj[1] = new Object_FabiCenter(gameH);
        gameH.obj[1].worldX = gameH.tileSize * 19;
        gameH.obj[1].worldY = gameH.tileSize * 16;

    }

    public void setNPC(String fileName) {// lest die Daten aus createNPC.txt aus und kreiert ein NPC mit diesen Daten

        try {

            // https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/

            String fileLocation = "res/NPC/" + fileName + ".txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);
            //InputStream mapFile = getClass().getResourceAsStream(fileLocation);

            int npcNum = 0;
            while (npcNum < 10) {
                String line = br.readLine();
                String[] lineSplit = line.split("~");
                System.arraycopy(lineSplit, 0, info[npcNum], 0, 12);
                npcNum++;

            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        for (int i = 0; i < 10; i++) {
            if (info[i][0] != null) {
                if (info[i][0].equals("TestNPC")) {
                    createTestNPC(Integer.parseInt(info[i][1]), Integer.parseInt(info[i][2]), Integer.parseInt(info[i][3]),
                                  Integer.parseInt(info[i][4]), info[i][5], Integer.parseInt(info[i][6]), Integer.parseInt(info[i][7]),
                                  Integer.parseInt(info[i][8]), Integer.parseInt(info[i][9]), Integer.parseInt(info[i][10]),
                                  Integer.parseInt(info[i][11]));
                }
            }
        }
    }
    public void setFabimonTeam(String fileName){
        try {

            String fileLocation = "res/NPC/" + fileName + ".txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);
            //InputStream mapFile = getClass().getResourceAsStream(fileLocation);
            
            int npc = 0;
            int phase = 0;
            String psinfo[] = new String[4];
            int pev[] = new int[6];
            int piv[] = new int[7];
            int level;
            int fabimon = 0;
            Boolean lastLine = false;
            while (!lastLine) {
                String line = br.readLine();
                String[] lineSplit = line.split("~");
                for(int i = 0; i< lineSplit.length; i++){
                    System.out.print(lineSplit[i] + " ");
                }
                System.out.println("");
                if(line.equals("next")){
                    phase = 0;
                }else if(line == null){
                    lastLine = true;
                }else if(phase == 0){
                    npc = Integer.parseInt(line);
                    phase = 1;
                    fabimon = 0;
                }else if(phase == 1){
                    for(int i =0; i<4; i++){
                        psinfo[i] = lineSplit[i];
                    }
                    for(int i =0; i<6; i++){
                       piv[i] = Integer.parseInt(lineSplit[i+5]);
                       pev[i] = Integer.parseInt(lineSplit[i+11]);
                    }
                    level = Integer.parseInt(lineSplit[4]);
                    gameH.fabimon.setNPCFabimon(npc, fabimon, psinfo, pev, piv, level);
                    fabimon++;
                }

            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void createTestNPC(int npcNum, int spawnX, int spawnY, int pMap, String pDirection, int pSpeed, int rangeL, int rangeR, int rangeU, int rangeD, int trainer) {
        gameH.npc[npcNum] = new NPCTest(gameH);
        gameH.npc[npcNum].originalWorldX = spawnX;
        gameH.npc[npcNum].originalWorldY = spawnY;
        gameH.npc[npcNum].worldX = gameH.tileSize * spawnX;
        gameH.npc[npcNum].worldY = gameH.tileSize * spawnY;
        gameH.npc[npcNum].map = gameH.availableMaps[pMap];
        gameH.npc[npcNum].direction = pDirection;
        gameH.npc[npcNum].speed = pSpeed;
        gameH.npc[npcNum].trainer = 1 == trainer;
        gameH.npc[npcNum].visionRangeRight = spawnX + rangeR + 1;
        gameH.npc[npcNum].visionRangeLeft = spawnX - rangeL;
        gameH.npc[npcNum].visionRangeUp = spawnY - rangeU;
        gameH.npc[npcNum].visionRangeDown = spawnY + rangeD + 1;
    }

}