package entity;


import main.GameHandler;
import main.ImageHandler;


public class NPCTest extends Entity {
    ImageHandler imageH = new ImageHandler();


    public NPCTest(GameHandler gameH) {
        super(gameH);

        getTestNPCImage();
        loadDialogue("NPCTestDialogues");
    }

    public void dialogue(int npc) {
        if (npc == 0) {
            if (dialoguePhase == 0) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[2][i];
                }
                dialoguePhase++;
            } else if (dialoguePhase == 1) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[3][i];
                }
                dialoguePhase++;
            } else if (dialoguePhase == 2) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[4][i];
                }
                dialoguePhase++;
            } else if (dialoguePhase == 3) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[5][i];
                }
                dialoguePhase++;
            } else if (dialoguePhase == 4) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[6][i];
                }
                dialoguePhase = 0;
                gameH.npc[npc].endDialogue = true;
            }
        } else if (npc == 1 && dialogueSelect == 0 || npc == 2 && dialogueSelect == 0) {
            if (gameH.npc[npc].defeated) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[11][i];
                }
                gameH.npc[npc].endDialogue = true;
            }else {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[0][i];
                }
                gameH.npc[npc].endDialogue = true;
            }
        } else if (npc == 1 && dialogueSelect == 1 || npc == 2 && dialogueSelect == 1) {
            for (int i = 0; i < 3; i++) {
                gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[9][i];
                dialogueSelect = 0;
            }
            gameH.npc[npc].endDialogue = true;
        } else if (npc == 3) {
            for (int i = 0; i < 3; i++) {
                gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[7][i];
            }
            gameH.npc[npc].endDialogue = true;
        } else if (npc == 4) {
            if (gameH.player.fabimonTeam[0] != null) {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[8][i];
                }
                gameH.fabimon.createFabimon("Feirir", 0, 5);
                gameH.player.fabimonTeam[0] = gameH.fabimon.tempFabimon;
                gameH.fabimon.createFabimon("cursed Shiggy", 0, 5);
                gameH.player.fabimonTeam[1] = gameH.fabimon.tempFabimon;
                gameH.fabimon.createFabimon("Jubby", 0, 5);
                gameH.player.fabimonTeam[2] = gameH.fabimon.tempFabimon;
                gameH.fabimon.createFabimon("grass type", 0, 5);
                gameH.player.fabimonTeam[3] = gameH.fabimon.tempFabimon;
                gameH.fabimon.createFabimon("electric type", 0, 5);
                gameH.player.fabimonTeam[4] = gameH.fabimon.tempFabimon;
                gameH.fabimon.createFabimon("electric type", 0, 5);
                gameH.player.fabimonTeam[5] = gameH.fabimon.tempFabimon;
                gameH.npc[npc].endDialogue = true;
            } else {
                for (int i = 0; i < 3; i++) {
                    gameH.ui.currentDialogue[i] = gameH.npc[npc].dialogues[10][i];
                }
                gameH.npc[npc].endDialogue = true;
            }
        }

    }

    public void getTestNPCImage() {
        imageH.ImageInitializer(0, "NPC/NPCTest", "uparrow", "png", gameH.tileSize, gameH.tileSize);
        up1 = imageH.image[0];
        imageH.ImageInitializer(1, "NPC/NPCTest", "uparrow2", "png", gameH.tileSize, gameH.tileSize);
        up2 = imageH.image[1];
        imageH.ImageInitializer(2, "NPC/NPCTest", "downarrow", "png", gameH.tileSize, gameH.tileSize);
        down1 = imageH.image[2];
        imageH.ImageInitializer(3, "NPC/NPCTest", "downarrow2", "png", gameH.tileSize, gameH.tileSize);
        down2 = imageH.image[3];
        imageH.ImageInitializer(4, "NPC/NPCTest", "leftarrow", "png", gameH.tileSize, gameH.tileSize);
        left1 = imageH.image[4];
        imageH.ImageInitializer(5, "NPC/NPCTest", "leftarrow2", "png", gameH.tileSize, gameH.tileSize);
        left2 = imageH.image[5];
        imageH.ImageInitializer(6, "NPC/NPCTest", "rightarrow", "png", gameH.tileSize, gameH.tileSize);
        right1 = imageH.image[6];
        imageH.ImageInitializer(7, "NPC/NPCTest", "rightarrow2", "png", gameH.tileSize, gameH.tileSize);
        right2 = imageH.image[7];
    }

    public void setAction() {// hier werden die Bewegungen der NPC festgelegt
        if (gameH.npc[1].worldX > gameH.tileSize * 24) {
            gameH.npc[1].direction = "left";
        } else if (gameH.npc[1].worldX < gameH.tileSize * 12) {
            gameH.npc[1].direction = "right";
        }
        if (!gameH.npc[2].isApproaching && !gameH.npc[2].innactive) {

            gameH.npc[2].turnTimer++;
            if (gameH.npc[2].turnTimer >= 80) {
                gameH.npc[2].turnTimer = 0;
                double zahl = Math.random() * 2;


                if (zahl > 0 && zahl < 0.25) {
                    gameH.npc[2].direction = "left";
                } else if (zahl > 0.25 && zahl < 0.50) {
                    gameH.npc[2].direction = "right";
                } else if (zahl > 0.50 && zahl < 0.75) {
                    gameH.npc[2].direction = "up";
                } else if (zahl > 0.75 && zahl < 1) {
                    gameH.npc[2].direction = "down";
                }
            }
        }
    }
}
