package main;

import entity.NPCTest;
import objects.Object_arenaPortal;

public class AssetSetter {

    GameHandler gameH;

    public AssetSetter(GameHandler gameH) {
        this.gameH = gameH;
    }
    public void setObject() {
        // arenaPortal
        gameH.obj[0] = new Object_arenaPortal(gameH);
        gameH.obj[0].worldX = gameH.tileSize*24;
        gameH.obj[0].worldY = gameH.tileSize*17;
    }

    public void setNPC() {
        /* EXAMPLE
            createNPC(index, spawnTileX, spawnTileY, map, spawnDirection, speed);
        */

        createTestNPC(0, 24, 18, 0, "left", 2, 12, 25, 18,18);
        createTestNPC(1, 24, 19, 0, "left", 2, 12, 25, 19, 19);
        createTestNPC(2, 34, 17, 0, "up", 0, 32, 37, 15, 19);
    }
    private void createTestNPC(int npcNum, int spawnX, int spawnY, int pMap, String pDirection, int pSpeed, int rangeL, int rangeR, int rangeU, int rangeD){
        gameH.npc[npcNum] = new NPCTest(gameH);
        gameH.npc[npcNum].worldX = gameH.tileSize*spawnX;
        gameH.npc[npcNum].worldY = gameH.tileSize*spawnY;
        gameH.npc[npcNum].map = gameH.availableMaps[pMap];
        gameH.npc[npcNum].direction = pDirection;
        gameH.npc[npcNum].speed = pSpeed;
        gameH.npc[npcNum].visionRangeRight = rangeR;
        gameH.npc[npcNum].visionRangeLeft = rangeL;
        gameH.npc[npcNum].visionRangeUp = rangeU;
        gameH.npc[npcNum].visionRangeDown = rangeD;
    }

}