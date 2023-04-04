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
        gameH.npc[index] = new NPS_name(gameH);
        gameH.npc[index].worldX = gameH.tileSize*spawnTILE;
        gameH.npc[index].worldY = gameH.tileSize*spawnTILE;
        */

        gameH.npc[0] = new NPCTest(gameH);
        gameH.npc[0].worldX = gameH.tileSize*24;
        gameH.npc[0].worldY = gameH.tileSize*18;
    }

}