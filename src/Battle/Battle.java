package Battle;

import main.GameHandler;

public class Battle {
    public int phase = 0;
    public int opponent;
    GameHandler gameH;
    int winPhase = 0;
    String prio = "";
    int enemyattack;


    public Battle(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void battleRound() {

        if (phase == 0) {
            if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum] != null) {
                Boolean haveAp = false;     // checkt, ob noch ap vorhanden sind
                for (int i = 0; i < gameH.player.fabimonTeam[0].move.length - 1; i++) {
                    if (gameH.player.fabimonTeam[0].move[i] != null && gameH.player.fabimonTeam[0].move[i].currentap != 0) {
                        haveAp = true;
                        break;
                    }
                }
                if (!haveAp) {
                    gameH.ui.commandNum = 4;    //setzt commandNum auf 4 wenn nicht.
                }
                if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].currentap == 0 && haveAp) { // Attacke nicht benutzbar wenn ap = 0
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = "Die ap dieser Attacke sind verbraucht";
                    phase = -1;
                } else {
                    enemyattack = getenemyattack();     //wählt für gegner eine Attacke aus
                    prio = priority(enemyattack);       //checkt wer als erstes angreifen darf.
                }
            } else {
                phase = -1;
            }
        }
        if (prio.equals("own")) {
            if (phase == 0) {
                if (checkOwnHit()) { // checkt, ob der Angriff trifft
                    gameH.enemy_Fabimon[0].currentHp -= calculateOwnDamage();
                } else {
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
                checkForWinner(); // checkt für einen gewinner
            } else if (phase == 1) {
                if (checkEnemyHit()) {
                    gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
                checkForWinner();

            } else if (phase == 2) {    // battleround wird beendet
                gameH.gameSubState = gameH.noSubState;
                gameH.ui.commandNum = 0;
                phase = -1;
                gameH.ui.clearTextfield();
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
            } else if (phase == 3) {
                checkForWinner();
            }
        } else if (prio.equals("enemy")) {
            if (phase == 0) {
                if (checkEnemyHit()) {
                    gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
                checkForWinner();
            } else if (phase == 1) {
                if (checkOwnHit()) {
                    gameH.enemy_Fabimon[0].currentHp -= calculateOwnDamage();
                } else {
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
                checkForWinner();

            } else if (phase == 2) {
                gameH.gameSubState = gameH.noSubState;
                gameH.ui.commandNum = 0;
                phase = -1;
                gameH.ui.clearTextfield();
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
            } else if (phase == 3) {
                checkForWinner();
            }
        }
    }

    public void enemyturn(){
        enemyattack = getenemyattack();
        if (checkEnemyHit()) {
            gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
        } else {
            gameH.ui.clearTextfield();
            gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
        }
        checkForWinner();
    }
    private void checkForWinner() {
        if (gameH.enemy_Fabimon[0].currentHp <= 0 || gameH.player.fabimonTeam[0].currentHp <= 0) {
            if (gameH.player.fabimonTeam[0].currentHp <= 0) {
                gameH.player.fabimonTeam[0].currentHp = 0;
                phase = 2;
                if (winPhase == 1) {
                    gameH.ui.clearTextfield();
                    gameH.ui.currentDialogue[0] = "Dein Fabimon wurde besiegt";
                    phase = 2;
                } else if (winPhase == 2) {
                    Boolean haveFabimon = false; // checkt, ob eine Fabimon noch kampffähig ist
                    for (int i = 0; i < gameH.player.fabimonTeam.length; i++) {
                        if (gameH.player.fabimonTeam[i] != null) {
                            if (gameH.player.fabimonTeam[i].currentHp > 0) {
                                haveFabimon = true;
                            }
                        }
                    }
                    if (haveFabimon) {
                        gameH.ui.clearTextfield();
                        gameH.ui.currentDialogue[0] = "Welches Fabimon soll zum Kampf";
                        gameH.gameSubState = gameH.fabimonMenu;
                        phase = -1;
                        winPhase = -1;
                    } else {
                        gameH.ui.clearTextfield();
                        gameH.ui.currentDialogue[0] = "Du hast keine Fabimons mehr.";
                        gameH.ui.currentDialogue[1] = " Du hast Verloren!";
                        phase = 2;
                    }
                } else if (winPhase == 3) {
                    lostBattle();
                    winPhase = -1;
                    phase = -1;
                }
            } else if (gameH.enemy_Fabimon[0].currentHp <= 0) {
                if (winPhase == 0) {
                    getEV();
                    phase = 2;
                    gameH.ui.currentDialogue[1] = "Das gegnerische Fabimon ist besiegt";
                    calculateExp();
                } else if (winPhase == 1) {
                    checkLevelUp();
                    gameH.fabimon.recalculatePlayerFabimon(0);
                    phase = 2;
                }
                if (winPhase == 2) {
                    int index = 0;
                    Boolean haveFabimon = false;
                    for (int i = 0; i < gameH.enemy_Fabimon.length; i++) {
                        if (gameH.enemy_Fabimon[i] != null) {
                            if (gameH.enemy_Fabimon[i].currentHp > 0) {
                                haveFabimon = true;
                                index = i;
                            }
                        }
                    }
                    if (haveFabimon) {
                        changeEnemyFabimon(index);
                        phase = 1;
                        winPhase = -1;
                    } else {
                        gameH.ui.clearTextfield();
                        gameH.ui.currentDialogue[0] = "Der Gegnerische Trainer hat keine Fabimons mehr.";
                        gameH.ui.currentDialogue[1] = " Du hast Gewonnen!";
                        phase = -1;
                    }
                } else if (winPhase == 3) {
                    gameH.npc[opponent].endBattle(opponent);
                    gameH.gameSubState = gameH.noSubState;
                    phase = -1;
                    winPhase = -1;
                }
            }
            winPhase++;
        }
    }

    private void getEV() {
        int temp = 0;
        for (int i = 0; i < 6; i++) {
            temp += gameH.player.fabimonTeam[0].haveEV[i];
        }
        if (temp < 510) {
            for (int i = 0; i < 6; i++) {
                if (gameH.player.fabimonTeam[0].haveEV[i] < 255) {
                    gameH.player.fabimonTeam[0].haveEV[i] += gameH.enemy_Fabimon[0].giveEV[i];
                    if (gameH.player.fabimonTeam[0].haveEV[i] > 255) {
                        gameH.player.fabimonTeam[0].haveEV[i] = 255;
                    }
                    temp = 0;
                    for (int j = 0; j < 6; j++) {
                        temp += gameH.player.fabimonTeam[0].haveEV[j];
                    }
                    if (temp > 510) {
                        while (temp != 510) {
                            gameH.player.fabimonTeam[0].haveEV[i]--;
                            temp--;
                        }
                    }
                }
            }
        }

    }

    private void lostBattle() {
        gameH.reloadLastSave(); // es wird der letzte save geladen
        gameH.gameSubState = gameH.noSubState;
        gameH.gameState = gameH.playState;
        gameH.npc[opponent].isApproaching = false;
        gameH.player.beingApproached = false;
        gameH.npc[opponent].approached = false;
        gameH.npc[opponent].approachphase = 0;
    }

    private void changeEnemyFabimon(int index) {
        gameH.fabimon.tempFabimon = gameH.enemy_Fabimon[0];
        gameH.enemy_Fabimon[0] = gameH.enemy_Fabimon[index];
        gameH.enemy_Fabimon[index] = gameH.fabimon.tempFabimon;
        gameH.ui.clearTextfield();
        gameH.ui.currentDialogue[0] = "Der Gegnerische Trainer hat zu " + gameH.enemy_Fabimon[0].name + " gewechselt";
    }

    public void changeOwnFabimon(int index) {
        if (index == 0) { // lässt einen nicht wechseln falls mit dem Fabimon das schon kämpft versucht wird zu wechseln
            gameH.ui.clearTextfield();
            gameH.ui.currentDialogue[0] = "Dieses Fabimon ist schon am kämpfen.";
            gameH.ui.currentDialogue[1] = "Wähle ein anderes Fabimon.";
        } else if (gameH.player.fabimonTeam[index].currentHp == 0) { // lässt einen nicht wechseln falls das Fabimon schon besiegt ist
            gameH.ui.clearTextfield();
            gameH.ui.currentDialogue[0] = "Dieses Fabimon wurde schon besiegt.";
            gameH.ui.currentDialogue[1] = "Wähle ein anderes Fabimon.";
        } else {
            if (gameH.player.fabimonTeam[0].currentHp == 0 || gameH.gameState == gameH.fabimonState) {
                gameH.fabimon.tempFabimon = gameH.player.fabimonTeam[0];
                gameH.player.fabimonTeam[0] = gameH.player.fabimonTeam[index];
                gameH.player.fabimonTeam[index] = gameH.fabimon.tempFabimon;
                gameH.gameSubState = gameH.noSubState;
                gameH.ui.clearTextfield();
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
            } else { // gegner darf noch angreifen falls wechsel freiwillig war
                gameH.fabimon.tempFabimon = gameH.player.fabimonTeam[0];
                gameH.player.fabimonTeam[0] = gameH.player.fabimonTeam[index];
                gameH.player.fabimonTeam[index] = gameH.fabimon.tempFabimon;
                gameH.gameSubState = gameH.noSubState;
                enemyattack = getenemyattack();
                if (checkEnemyHit()) {
                    gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
                checkForWinner();
            }
            gameH.ui.commandNum = 0;
        }
    }

    private Boolean checkOwnHit() {
        gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].currentap--;
        int stufe = gameH.player.fabimonTeam[0].haveEffect[1] - gameH.enemy_Fabimon[0].haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    private Boolean checkEnemyHit() {
        gameH.enemy_Fabimon[0].move[enemyattack].currentap--;
        int stufe = gameH.enemy_Fabimon[0].haveEffect[1] - gameH.player.fabimonTeam[0].haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.enemy_Fabimon[0].move[enemyattack].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.enemy_Fabimon[0].move[enemyattack].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    public int getenemyattack() {
        Boolean haveAP = false;
        for (int i = 0; i < 4; i++) {
            if (gameH.enemy_Fabimon[0].move[i] != null && gameH.enemy_Fabimon[0].move[i].currentap != 0) {
                haveAP = true;
                break;
            }
        }
        if (!haveAP) {
            return 4;
        }
        for (int i = 0; i < 4; i++) {
            if (gameH.enemy_Fabimon[0].move[i] != null) {
                int temp = gameH.player.fabimonTeam[0].currentHp - testCalculateEnemyDamage(i);
                if (temp <= 0 && gameH.enemy_Fabimon[0].move[i].currentap != 0) {
                    return i;
                }
            }
        }
        int rand = 0;
        do {
            rand = (int) (Math.random() * 4);
        } while (gameH.enemy_Fabimon[0].move[rand] == null);
        return rand;
    }

    private int volltreffer() {
        int ran = (int) (Math.random() * 101);
        if (ran <= 6) {
            gameH.ui.currentDialogue[1] = "Ein Volltreffer!";
            return 2;
        }
        gameH.ui.clearTextfield();
        return 1;
    }

    private String priority(int i) {
        if (gameH.enemy_Fabimon[0].move[i].priority > gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            return "enemy";
        } else if (gameH.enemy_Fabimon[0].move[i].priority < gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            return "own";
        } else if (gameH.enemy_Fabimon[0].move[i].priority == gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            if (gameH.enemy_Fabimon[0].init > gameH.player.fabimonTeam[0].init) {
                return "enemy";
            } else if (gameH.enemy_Fabimon[0].init < gameH.player.fabimonTeam[0].init) {
                return "own";
            } else if (gameH.enemy_Fabimon[0].init == gameH.player.fabimonTeam[0].init) {
                int rand = (int) (Math.random() * 2);
                if (rand == 1) {
                    return "own";
                } else {
                    return "enemy";
                }
            }
        }
        return "enemy";
    }

    public int calculateOwnDamage() {
        double typeBonus = 1;
        if (gameH.player.fabimonTeam[0].type1.equals(gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type) || gameH.player.fabimonTeam[0].type2.equals(gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type)) {
            typeBonus = 1.5;
        }
        if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].category.equals("special")) {
            double basisschaden = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.player.fabimonTeam[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.player.fabimonTeam[0].sp_atk * getStep(gameH.player.fabimonTeam[0].haveEffect[4])) / (50 * gameH.enemy_Fabimon[0].sp_dev * getStep(gameH.enemy_Fabimon[0].haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeBonus * typeVorteil(1) * typeVorteil(2);
            System.out.println(zr2);
            gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
            return (int) zr2;
        } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].category.equals("physical")) {
            double basisschaden = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.player.fabimonTeam[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.player.fabimonTeam[0].atk * getStep(gameH.player.fabimonTeam[0].haveEffect[2])) / (50 * gameH.enemy_Fabimon[0].dev * getStep(gameH.enemy_Fabimon[0].haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeBonus * typeVorteil(1) * typeVorteil(2);
            gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
            if (gameH.ui.commandNum == 4) {
                double temp = gameH.player.fabimonTeam[0].currentHp - ((int) zr2 * 0.25);
                gameH.player.fabimonTeam[0].currentHp = (int) temp;
            }
            return (int) zr2;
        } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].category.equals("status")) {
            if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].target.equals("enemy")) {
                gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
                affectEnemy("own");
                return 0;
            } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].target.equals("own")) {
                gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
                affectyourself("own");
                return 0;
            }
        }

        return 0;
    }

    private double typeVorteil(int dingsbums) {
        //(normal), fire, water, grass, water, elektro, dark
        //gameh.enemy_atk
        if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum] != null) {
            if (dingsbums == 1) {
                if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("Fire")) {
                    switch (gameH.enemy_Fabimon[0].type1) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 2;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("water")) {
                    switch (gameH.enemy_Fabimon[0].type1) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 2;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("grass")) {
                    switch (gameH.enemy_Fabimon[0].type1) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }

                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("electric")) {
                    switch (gameH.enemy_Fabimon[0].type1) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Electric":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("dark")) {
                    if (gameH.enemy_Fabimon[0].type1.equals("Dark")) {
                        return 0.5;
                    }
                    return 1;
                }
            } else if (dingsbums == 2) {
                if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("Fire")) {
                    switch (gameH.enemy_Fabimon[0].type2) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 2;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("water")) {
                    switch (gameH.enemy_Fabimon[0].type2) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 2;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("grass")) {
                    switch (gameH.enemy_Fabimon[0].type2) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }

                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("electric")) {
                    switch (gameH.enemy_Fabimon[0].type2) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Electric":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type.equals("dark")) {
                    if (gameH.enemy_Fabimon[0].type2.equals("Dark")) {
                        return 0.5;
                    }
                    return 1;
                }
            }
        }
        return 1;
    }

    private double typeVorteilEnemy(int enemyadvantage) {
        if (gameH.enemy_Fabimon[0].move[enemyattack] != null) {
            if (enemyadvantage == 1) {
                if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("Fire")) {
                    switch (gameH.player.fabimonTeam[0].type1) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 2;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("water")) {
                    switch (gameH.player.fabimonTeam[0].type1) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 2;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("grass")) {
                    switch (gameH.player.fabimonTeam[0].type1) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }

                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("electric")) {
                    switch (gameH.player.fabimonTeam[0].type1) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Electric":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("dark")) {
                    if (gameH.player.fabimonTeam[0].type1.equals("Dark")) {
                        return 0.5;
                    }
                    return 1;
                }
            } else if (enemyadvantage == 2) {
                if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("Fire")) {
                    switch (gameH.player.fabimonTeam[0].type2) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 2;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("water")) {
                    switch (gameH.player.fabimonTeam[0].type2) {
                        case "Water":
                            return 0.5;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 2;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("grass")) {
                    switch (gameH.player.fabimonTeam[0].type2) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Fire":
                            return 0.5;
                        default:
                            return 1;
                    }

                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("electric")) {
                    switch (gameH.player.fabimonTeam[0].type2) {
                        case "Water":
                            return 2;
                        case "Grass":
                            return 0.5;
                        case "Electric":
                            return 0.5;
                        default:
                            return 1;
                    }
                } else if (gameH.enemy_Fabimon[0].move[enemyattack].type.equals("dark")) {
                    if (gameH.player.fabimonTeam[0].type2.equals("Dark")) {
                        return 0.5;
                    }
                    return 1;
                }
            }
        }
        return 1;
    }

    private void affectyourself(String attacker) {
        if (attacker.equals("own")) {
            for (int i = 0; i < gameH.player.fabimonTeam[0].haveEffect.length; i++) {
                if (gameH.player.fabimonTeam[0].haveEffect[i] == -6 || gameH.player.fabimonTeam[0].haveEffect[i] == 6) {
                    int temp = gameH.player.fabimonTeam[0].haveEffect[i] + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen";
                        return;
                    }
                }
                gameH.player.fabimonTeam[0].haveEffect[i] += gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                if (gameH.player.fabimonTeam[0].haveEffect[i] < -6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = -6;
                } else if (gameH.player.fabimonTeam[0].haveEffect[i] > 6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = 6;
                }
            }
        } else if (attacker.equals("enemy")) {
            for (int i = 0; i < gameH.enemy_Fabimon[0].haveEffect.length; i++) {
                if (gameH.enemy_Fabimon[0].haveEffect[i] == -6 || gameH.enemy_Fabimon[0].haveEffect[i] == 6) {
                    int temp = gameH.enemy_Fabimon[0].haveEffect[i] + gameH.enemy_Fabimon[0].move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Die gegnerische Attacke ist fehlgeschlagen";
                        return;
                    }
                }
                gameH.enemy_Fabimon[0].haveEffect[i] += gameH.enemy_Fabimon[0].move[enemyattack].effect[i];
                if (gameH.enemy_Fabimon[0].haveEffect[i] < -6) {
                    gameH.enemy_Fabimon[0].haveEffect[i] = -6;
                } else if (gameH.enemy_Fabimon[0].haveEffect[i] > 6) {
                    gameH.enemy_Fabimon[0].haveEffect[i] = 6;
                }
            }
        }
    }

    private void affectEnemy(String attacker) {
        if (attacker.equals("own")) {
            for (int i = 0; i < gameH.enemy_Fabimon[0].haveEffect.length; i++) {
                if (gameH.enemy_Fabimon[0].haveEffect[i] == -6 || gameH.enemy_Fabimon[0].haveEffect[i] == 6) {
                    int temp = gameH.enemy_Fabimon[0].haveEffect[i] + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.enemy_Fabimon[0].haveEffect[i] += gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                if (gameH.enemy_Fabimon[0].haveEffect[i] < -6) {
                    gameH.enemy_Fabimon[0].haveEffect[i] = -6;
                } else if (gameH.enemy_Fabimon[0].haveEffect[i] > 6) {
                    gameH.enemy_Fabimon[0].haveEffect[i] = 6;
                }
            }
        } else if (attacker.equals("enemy")) {
            for (int i = 0; i < gameH.enemy_Fabimon[0].haveEffect.length; i++) {
                if (gameH.player.fabimonTeam[0].haveEffect[i] == -6 || gameH.player.fabimonTeam[0].haveEffect[i] == 6) {
                    int temp = gameH.player.fabimonTeam[0].haveEffect[i] + gameH.enemy_Fabimon[0].move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Die gegnerische Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.player.fabimonTeam[0].haveEffect[i] += gameH.enemy_Fabimon[0].move[enemyattack].effect[i];
                if (gameH.player.fabimonTeam[0].haveEffect[i] < -6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = -6;
                } else if (gameH.player.fabimonTeam[0].haveEffect[i] > 6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = 6;
                }
            }
        }
    }

    public int testCalculateEnemyDamage(int i) {// berechnet den schaden den ein angriff machen würde.
        double typeBonus = 1;
        if (gameH.enemy_Fabimon[0].type1.equals(gameH.player.fabimonTeam[0].move[i].type) || gameH.enemy_Fabimon[0].type2.equals(gameH.player.fabimonTeam[0].move[i].type)) {
            typeBonus = 1.5;
        }
        if (gameH.enemy_Fabimon[0].move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon[0].move[i].power;
            int zr0 = ((gameH.enemy_Fabimon[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon[0].sp_atk * getStep(gameH.enemy_Fabimon[0].haveEffect[4])) / (50 * gameH.player.fabimonTeam[0].sp_dev * getStep(gameH.player.fabimonTeam[0].haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeBonus * typeVorteilEnemy(1) * typeVorteilEnemy(2);
            return (int) zr2;
        } else if (gameH.enemy_Fabimon[0].move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon[0].move[i].power;
            int zr0 = ((gameH.enemy_Fabimon[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon[0].atk * getStep(gameH.enemy_Fabimon[0].haveEffect[2])) / (50 * gameH.player.fabimonTeam[0].dev * getStep(gameH.player.fabimonTeam[0].haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeBonus * typeVorteilEnemy(1) * typeVorteilEnemy(2);
            return (int) zr2;
        } else if (gameH.enemy_Fabimon[0].move[enemyattack].category.equals("status")) {
        }
        return 0;
    }

    public int calculateEnemyDamage(int i) {
        if (gameH.enemy_Fabimon[0].move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon[0].move[i].power;
            int zr0 = ((gameH.enemy_Fabimon[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon[0].sp_atk * getStep(gameH.enemy_Fabimon[0].haveEffect[4])) / (50 * gameH.player.fabimonTeam[0].sp_dev * getStep(gameH.player.fabimonTeam[0].haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeVorteilEnemy(1) * typeVorteilEnemy(2);
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon[0].name + " nutzt " + gameH.enemy_Fabimon[0].move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon[0].move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon[0].move[i].power;
            int zr0 = ((gameH.enemy_Fabimon[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon[0].atk * getStep(gameH.enemy_Fabimon[0].haveEffect[2])) / (50 * gameH.player.fabimonTeam[0].dev * getStep(gameH.player.fabimonTeam[0].haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer() * typeVorteilEnemy(1) * typeVorteilEnemy(2);
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon[0].name + " nutzt " + gameH.enemy_Fabimon[0].move[enemyattack].name + ".";
            if (enemyattack == 4) {
                double temp = gameH.enemy_Fabimon[0].currentHp - ((int) zr2 * 0.25);
                gameH.enemy_Fabimon[0].currentHp = (int) temp;
            }
            return (int) zr2;
        } else if (gameH.enemy_Fabimon[0].move[enemyattack].category.equals("status")) {
            if (gameH.enemy_Fabimon[0].move[enemyattack].target.equals("enemy")) {
                gameH.ui.currentDialogue[0] = gameH.enemy_Fabimon[0].name + " nutzt " + gameH.enemy_Fabimon[0].move[enemyattack].name + ".";
                affectEnemy("enemy");
                return 0;
            } else if (gameH.enemy_Fabimon[0].move[enemyattack].target.equals("own")) {
                gameH.ui.currentDialogue[0] = gameH.enemy_Fabimon[0].name + " nutzt " + gameH.enemy_Fabimon[0].move[enemyattack].name + ".";
                affectyourself("enemy");
                return 0;
            }
        }
        return 0;
    }

    private void calculateExp() {
        int g = 1;
        int a = 1;
        double ep = (a * gameH.enemy_Fabimon[0].baseEp * g * gameH.enemy_Fabimon[0].level) / 7;
        gameH.ui.currentDialogue[2] = "du hast " + (int) ep + " Erfahrungspunkte erhalten";
        gameH.player.fabimonTeam[0].currentEp += (int) ep;
    }

    private void checkLevelUp() {
        // 11 Wochen
        int neededExp = (gameH.player.fabimonTeam[0].level + 1) * (gameH.player.fabimonTeam[0].level + 1) * (gameH.player.fabimonTeam[0].level + 1);
        if (gameH.player.fabimonTeam[0].currentEp < neededExp) {
            winPhase++;
        }
        if (gameH.player.fabimonTeam[0].currentEp >= neededExp) {
            gameH.player.fabimonTeam[0].level++;
            gameH.gameSubState = gameH.newMoveState;
            gameH.player.fabimonTeam[0].currentEp -= neededExp;
            winPhase--;
            gameH.ui.clearTextfield();
            gameH.ui.currentDialogue[0] = "Dein Fabimon ist im Level aufgestiegen";
        }
    }

    private double getaccStep(int i) { // gibt den Multiplikator für die genauigkeit zurück
        switch (i) {
            case -6:
                return 0.33;
            case -5:
                return 0.38;
            case -4:
                return 0.43;
            case -3:
                return 0.5;
            case -2:
                return 0.6;
            case -1:
                return 0.75;
            case 0:
                return 1;
            case 1:
                return 1.33;
            case 2:
                return 1.67;
            case 3:
                return 2;
            case 4:
                return 2.33;
            case 5:
                return 2.67;
            case 6:
                return 3;
        }
        return 1.0;
    }

    private double getStep(int i) { // gibt den multiplikator für die statuswerte zurück
        switch (i) {
            case -6:
                return 0.25;
            case -5:
                return 0.29;
            case -4:
                return 0.33;
            case -3:
                return 0.4;
            case -2:
                return 0.5;
            case -1:
                return 0.67;
            case 0:
                return 1;
            case 1:
                return 1.5;
            case 2:
                return 2;
            case 3:
                return 2.5;
            case 4:
                return 3;
            case 5:
                return 3.5;
            case 6:
                return 4;
        }
        return 1.0;
    }
}