package Battle;

import main.GameHandler;

public class Battle {
    public int phase = 0;
    GameHandler gameH;
    String prio = "";
    int enemyattack;

    public Battle(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void battleRound() {
        if (phase == 0) {
            if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].ap == 0) {
                gameH.ui.currentDialogue[0] = "Die ap dieser Attacke sind verbraucht";
                phase = -1;
            } else {
                enemyattack = getenemyattack();
                prio = priority(enemyattack);
            }
        }
        if (prio.equals("own")) {
            if (phase == 0) {
                if (checkOwnHit()) {
                    gameH.enemy_Fabimon.currentHp -= calculateOwnDamage();
                } else {
                    gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
                checkForWinner();
            } else if (phase == 1) {
                if (checkEnemyHit()) {
                    gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
                checkForWinner();

            } else if (phase == 2) {
                gameH.battleSubState = gameH.mainMenu;
                gameH.ui.commandNum = 0;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        } else if (prio.equals("enemy")) {
            if (phase == 0) {
                if (checkEnemyHit()) {
                    gameH.player.fabimonTeam[0].currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
                checkForWinner();
            } else if (phase == 1) {
                if (checkOwnHit()) {
                    gameH.enemy_Fabimon.currentHp -= calculateOwnDamage();
                } else {
                    gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
                checkForWinner();
            } else if (phase == 2) {
                gameH.battleSubState = gameH.mainMenu;
                gameH.ui.commandNum = 0;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        }
    }
    private void checkForWinner(){
        if (gameH.player.fabimonTeam[0].currentHp <= 0) {
            System.out.println("verloren");
        } if (gameH.enemy_Fabimon.currentHp <= 0) {
            System.out.println("gewonnen");
            calculateExp();
            gameH.ui.currentDialogue[0] = "Das gegnerische Fabimon ist besiegt";
            phase = -1;
        }
    }
    private Boolean checkOwnHit() {
        gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].ap--;
        int stufe = gameH.player.fabimonTeam[0].haveEffect[1] - gameH.enemy_Fabimon.haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    private Boolean checkEnemyHit() {
        gameH.enemy_Fabimon.move[enemyattack].ap--;
        int stufe = gameH.enemy_Fabimon.haveEffect[1] - gameH.player.fabimonTeam[0].haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.enemy_Fabimon.move[enemyattack].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.enemy_Fabimon.move[enemyattack].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    public int getenemyattack() {
        for (int i = 0; i < 4; i++) {
            int temp = gameH.player.fabimonTeam[0].currentHp - testCalculateEnemyDamage(i);
            if (temp <= 0 && gameH.enemy_Fabimon.move[i].ap != 0) {
                return i;
            }
        }
        int rand = (int) (Math.random() * 4);
        return rand;
    }

    private int volltreffer() {
        int ran = (int) (Math.random() * 101);
        if (ran <= 6) {
            gameH.ui.currentDialogue[1] = "Ein Volltreffer!";
            return 2;
        }
        gameH.ui.currentDialogue[1] = "";
        return 1;
    }

    private String priority(int i) {
        if (gameH.enemy_Fabimon.move[i].priority > gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            return "enemy";
        } else if (gameH.enemy_Fabimon.move[i].priority < gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            return "own";
        } else if (gameH.enemy_Fabimon.move[i].priority == gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].priority) {
            if (gameH.enemy_Fabimon.init > gameH.player.fabimonTeam[0].init) {
                return "enemy";
            } else if (gameH.enemy_Fabimon.init < gameH.player.fabimonTeam[0].init) {
                return "own";
            } else if (gameH.enemy_Fabimon.init == gameH.player.fabimonTeam[0].init) {
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
        if(gameH.player.fabimonTeam[0].type1.equals(gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type) || gameH.player.fabimonTeam[0].type2.equals(gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].type)){
            typeBonus = 1.5;
        }
        if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].category.equals("special")) {
            double basisschaden = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.player.fabimonTeam[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.player.fabimonTeam[0].sp_atk * getStep(gameH.player.fabimonTeam[0].haveEffect[4])) / (50 * gameH.enemy_Fabimon.sp_dev * getStep(gameH.enemy_Fabimon.haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer()*typeBonus;
            gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
            return (int) zr2;
        } else if (gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].category.equals("physical")) {
            double basisschaden = gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.player.fabimonTeam[0].level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.player.fabimonTeam[0].atk * getStep(gameH.player.fabimonTeam[0].haveEffect[2])) / (50 * gameH.enemy_Fabimon.dev * getStep(gameH.enemy_Fabimon.haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer()*typeBonus;
            gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " nutzt " + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].name + ".";
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
            for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                if (gameH.enemy_Fabimon.haveEffect[i] == -6 || gameH.enemy_Fabimon.haveEffect[i] == 6) {
                    int temp = gameH.enemy_Fabimon.haveEffect[i] + gameH.enemy_Fabimon.move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Die gegnerische Attacke ist fehlgeschlagen";
                        return;
                    }
                }
                gameH.enemy_Fabimon.haveEffect[i] += gameH.enemy_Fabimon.move[enemyattack].effect[i];
                if (gameH.enemy_Fabimon.haveEffect[i] < -6) {
                    gameH.enemy_Fabimon.haveEffect[i] = -6;
                } else if (gameH.enemy_Fabimon.haveEffect[i] > 6) {
                    gameH.enemy_Fabimon.haveEffect[i] = 6;
                }
            }
        }
    }

    private void affectEnemy(String attacker) {
        if (attacker.equals("own")) {
            for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                if (gameH.enemy_Fabimon.haveEffect[i] == -6 || gameH.enemy_Fabimon.haveEffect[i] == 6) {
                    int temp = gameH.enemy_Fabimon.haveEffect[i] + gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.enemy_Fabimon.haveEffect[i] += gameH.player.fabimonTeam[0].move[gameH.ui.commandNum].effect[i];
                if (gameH.enemy_Fabimon.haveEffect[i] < -6) {
                    gameH.enemy_Fabimon.haveEffect[i] = -6;
                } else if (gameH.enemy_Fabimon.haveEffect[i] > 6) {
                    gameH.enemy_Fabimon.haveEffect[i] = 6;
                }
            }
        } else if (attacker.equals("enemy")) {
            for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                if (gameH.player.fabimonTeam[0].haveEffect[i] == -6 || gameH.player.fabimonTeam[0].haveEffect[i] == 6) {
                    int temp = gameH.player.fabimonTeam[0].haveEffect[i] + gameH.enemy_Fabimon.move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Die gegnerische Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.player.fabimonTeam[0].haveEffect[i] += gameH.enemy_Fabimon.move[enemyattack].effect[i];
                if (gameH.player.fabimonTeam[0].haveEffect[i] < -6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = -6;
                } else if (gameH.player.fabimonTeam[0].haveEffect[i] > 6) {
                    gameH.player.fabimonTeam[0].haveEffect[i] = 6;
                }
            }
        }
    }
    public int testCalculateEnemyDamage(int i){
        double typeBonus = 1;
        if(gameH.enemy_Fabimon.type1.equals(gameH.player.fabimonTeam[0].move[enemyattack].type) || gameH.enemy_Fabimon.type2.equals(gameH.player.fabimonTeam[0].move[enemyattack].type)){
            typeBonus = 1.5;
        }
        if (gameH.enemy_Fabimon.move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.sp_atk * getStep(gameH.enemy_Fabimon.haveEffect[4])) / (50 * gameH.player.fabimonTeam[0].sp_dev * getStep(gameH.player.fabimonTeam[0].haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer()*typeBonus;
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.atk * getStep(gameH.enemy_Fabimon.haveEffect[2])) / (50 * gameH.player.fabimonTeam[0].dev * getStep(gameH.player.fabimonTeam[0].haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer()*typeBonus;
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[enemyattack].category.equals("status")) {
        }
        return 0;
    }

    public int calculateEnemyDamage(int i) {
        if (gameH.enemy_Fabimon.move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.sp_atk * getStep(gameH.enemy_Fabimon.haveEffect[4])) / (50 * gameH.player.fabimonTeam[0].sp_dev * getStep(gameH.player.fabimonTeam[0].haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.atk * getStep(gameH.enemy_Fabimon.haveEffect[2])) / (50 * gameH.player.fabimonTeam[0].dev * getStep(gameH.player.fabimonTeam[0].haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[enemyattack].category.equals("status")) {
            if (gameH.enemy_Fabimon.move[enemyattack].target.equals("enemy")) {
                gameH.ui.currentDialogue[0] = gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
                affectEnemy("enemy");
                return 0;
            } else if (gameH.enemy_Fabimon.move[enemyattack].target.equals("own")) {
                gameH.ui.currentDialogue[0] = gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
                affectyourself("enemy");
                return 0;
            }
        }
        return 0;
    }

    private void calculateExp(){
    int g = 1;
    int a = 1;
    double ep = (a * gameH.enemy_Fabimon.baseEp * g * gameH.enemy_Fabimon.level )/7;
    gameH.ui.currentDialogue[1]= "du hast " + (int)ep + " Erfahrungspunkte erhalten";
    gameH.player.fabimonTeam[0].currentEp+=(int)ep;
    checkLevelUp();
    }

    private void checkLevelUp(){
        // 11 Wochen
        int neededExp = (gameH.player.fabimonTeam[0].level+1)*(gameH.player.fabimonTeam[0].level+1)*(gameH.player.fabimonTeam[0].level+1);
        System.out.println(neededExp);
            while (gameH.player.fabimonTeam[0].currentEp >= neededExp) {
                gameH.player.fabimonTeam[0].level++;
                gameH.player.fabimonTeam[0].currentEp -= neededExp;
                neededExp=(gameH.player.fabimonTeam[0].level+1)^3;
            }
    }

    private double getaccStep(int i) {
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

    private double getStep(int i) {
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