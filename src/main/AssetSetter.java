package main;

import entity.NPCTest;
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