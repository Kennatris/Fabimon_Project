package main;

import entity.Entity;

public class CollisionChecker {

    GameHandler gameH;

    public CollisionChecker(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gameH.tileSize;
        int entityRightCol = entityRightWorldX/gameH.tileSize;
        int entityTopRow = entityTopWorldY/gameH.tileSize;
        int entityBottomRow = entityBottomWorldY/gameH.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gameH.tileSize;
                tileNum1 = gameH.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gameH.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gameH.tileM.tile[tileNum1].collision == true || gameH.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gameH.tileSize;
                tileNum1 = gameH.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gameH.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gameH.tileM.tile[tileNum1].collision == true || gameH.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gameH.tileSize;
                tileNum1 = gameH.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gameH.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if (gameH.tileM.tile[tileNum1].collision == true || gameH.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gameH.tileSize;
                tileNum1 = gameH.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gameH.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gameH.tileM.tile[tileNum1].collision == true || gameH.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
        }
    }

    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < gameH.obj.length; i++) {

            if(gameH.obj[i] != null) {

                // Get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get the object's solid area position
                gameH.obj[i].solidArea.x = gameH.obj[i].worldX + gameH.obj[i].solidArea.x;
                gameH.obj[i].solidArea.y = gameH.obj[i].worldY + gameH.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gameH.obj[i].solidArea)) {
                            if(gameH.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gameH.obj[i].solidArea)) {
                            if(gameH.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gameH.obj[i].solidArea)) {
                            if(gameH.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gameH.obj[i].solidArea)) {
                            if(gameH.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gameH.obj[i].solidArea.x = gameH.obj[i].solidAreaDefaultX;
                gameH.obj[i].solidArea.y = gameH.obj[i].solidAreaDefaultY;
            }

        }

        return index;
    }

    // NPC OR MONSTER
    public int checkEntity(Entity entity, Entity[] target) {

        int index = 999;

        for(int i = 0; i < target.length; i++) {

            if(target[i] != null) {

                // Get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get the object's solid area position
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }

        }

        return index;
    }

    public void checkPlayer(Entity entity) {

        // Get entity's solid area position
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;

        // Get the object's solid area position
        gameH.player.solidArea.x = gameH.player.worldX + gameH.player.solidArea.x;
        gameH.player.solidArea.y = gameH.player.worldY + gameH.player.solidArea.y;

        switch(entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                if(entity.solidArea.intersects(gameH.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                if(entity.solidArea.intersects(gameH.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if(entity.solidArea.intersects(gameH.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if(entity.solidArea.intersects(gameH.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
        }

        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gameH.player.solidArea.x = gameH.player.solidAreaDefaultX;
        gameH.player.solidArea.y = gameH.player.solidAreaDefaultY;
    }

}