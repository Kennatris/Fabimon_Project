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
        if (gameH.own_Fabimon.currentHp <= 0) {
            System.out.println("verloren");
        } else if (gameH.enemy_Fabimon.currentHp <= 0) {
            System.out.println("gewonnen");
        }
        if (phase == 0) {
            if (gameH.own_Fabimon.move[gameH.ui.commandNum].ap == 0) {
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
                    gameH.ui.currentDialogue[0] = gameH.own_Fabimon.move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
            } else if (phase == 1) {
                if (checkEnemyHit()) {
                    gameH.own_Fabimon.currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }

            } else if (phase == 2) {
                for (int i = 0; i < gameH.own_Fabimon.haveEffect.length; i++) {
                    System.out.print(gameH.own_Fabimon.haveEffect[i] + " ");
                }
                System.out.println();
                for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                    System.out.print(gameH.enemy_Fabimon.haveEffect[i] + " ");
                }
                System.out.println();
                gameH.battleSubState = gameH.mainMenu;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        } else if (prio.equals("enemy")) {
            if (phase == 0) {
                if (checkEnemyHit()) {
                    gameH.own_Fabimon.currentHp -= calculateEnemyDamage(enemyattack);
                } else {
                    gameH.ui.currentDialogue[0] = "Die gegnerische Attacke hat nicht getroffen.";
                }
            } else if (phase == 1) {
                if (checkOwnHit()) {
                    gameH.enemy_Fabimon.currentHp -= calculateOwnDamage();
                } else {
                    gameH.ui.currentDialogue[0] = gameH.own_Fabimon.move[gameH.ui.commandNum].name + " hat nicht getroffen!";
                }
            } else if (phase == 2) {
                System.out.println("");
                gameH.battleSubState = gameH.mainMenu;
                gameH.ui.commandNum = 0;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        }
    }

    private Boolean checkOwnHit() {
        gameH.own_Fabimon.move[gameH.ui.commandNum].ap--;
        int stufe = gameH.own_Fabimon.haveEffect[1] - gameH.enemy_Fabimon.haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.own_Fabimon.move[gameH.ui.commandNum].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.own_Fabimon.move[gameH.ui.commandNum].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    private Boolean checkEnemyHit() {
        gameH.enemy_Fabimon.move[enemyattack].ap--;
        int stufe = gameH.enemy_Fabimon.haveEffect[1] - gameH.own_Fabimon.haveEffect[0];
        double step = getaccStep(stufe);
        double trefferchance = gameH.enemy_Fabimon.move[enemyattack].accuracy * step;
        int rand = (int) (Math.random() * 101);
        if (gameH.enemy_Fabimon.move[enemyattack].trifftImmer) {
            return true;
        } else return rand <= (int) trefferchance;
    }

    public int getenemyattack() {
        for (int i = 0; i < 4; i++) {
            int temp = gameH.own_Fabimon.currentHp - testCalculateEnemyDamage(i);
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
        if (gameH.enemy_Fabimon.move[i].priority > gameH.own_Fabimon.move[gameH.ui.commandNum].priority) {
            return "enemy";
        } else if (gameH.enemy_Fabimon.move[i].priority < gameH.own_Fabimon.move[gameH.ui.commandNum].priority) {
            return "own";
        } else if (gameH.enemy_Fabimon.move[i].priority == gameH.own_Fabimon.move[gameH.ui.commandNum].priority) {
            if (gameH.enemy_Fabimon.init > gameH.own_Fabimon.init) {
                return "enemy";
            } else if (gameH.enemy_Fabimon.init < gameH.own_Fabimon.init) {
                return "own";
            } else if (gameH.enemy_Fabimon.init == gameH.own_Fabimon.init) {
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

        if (gameH.own_Fabimon.move[gameH.ui.commandNum].category.equals("special")) {
            double basisschaden = gameH.own_Fabimon.move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.own_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.own_Fabimon.sp_atk * getStep(gameH.own_Fabimon.haveEffect[4])) / (50 * gameH.enemy_Fabimon.sp_dev * getStep(gameH.enemy_Fabimon.haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
            return (int) zr2;
        } else if (gameH.own_Fabimon.move[gameH.ui.commandNum].category.equals("physical")) {
            double basisschaden = gameH.own_Fabimon.move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.own_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.own_Fabimon.atk * getStep(gameH.own_Fabimon.haveEffect[2])) / (50 * gameH.enemy_Fabimon.dev * getStep(gameH.enemy_Fabimon.haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
            return (int) zr2;
        } else if (gameH.own_Fabimon.move[gameH.ui.commandNum].category.equals("status")) {
            if (gameH.own_Fabimon.move[gameH.ui.commandNum].target.equals("enemy")) {
                gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
                affectEnemy("own");
                return 0;
            } else if (gameH.own_Fabimon.move[gameH.ui.commandNum].target.equals("own")) {
                gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
                affectyourself("own");
                return 0;
            }
        }

        return 0;
    }

    private void affectyourself(String attacker) {
        if (attacker.equals("own")) {
            for (int i = 0; i < gameH.own_Fabimon.haveEffect.length; i++) {
                if (gameH.own_Fabimon.haveEffect[i] == -6 || gameH.own_Fabimon.haveEffect[i] == 6) {
                    int temp = gameH.own_Fabimon.haveEffect[i] + gameH.own_Fabimon.move[gameH.ui.commandNum].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen";
                        return;
                    }
                }
                gameH.own_Fabimon.haveEffect[i] += gameH.own_Fabimon.move[gameH.ui.commandNum].effect[i];
                if (gameH.own_Fabimon.haveEffect[i] < -6) {
                    gameH.own_Fabimon.haveEffect[i] = -6;
                } else if (gameH.own_Fabimon.haveEffect[i] > 6) {
                    gameH.own_Fabimon.haveEffect[i] = 6;
                }
            }
        } else if (attacker.equals("enemy")) {
            for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                if (gameH.enemy_Fabimon.haveEffect[i] == -6 || gameH.enemy_Fabimon.haveEffect[i] == 6) {
                    int temp = gameH.enemy_Fabimon.haveEffect[i] + gameH.enemy_Fabimon.move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen";
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
                    int temp = gameH.enemy_Fabimon.haveEffect[i] + gameH.own_Fabimon.move[gameH.ui.commandNum].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.enemy_Fabimon.haveEffect[i] += gameH.own_Fabimon.move[gameH.ui.commandNum].effect[i];
                if (gameH.enemy_Fabimon.haveEffect[i] < -6) {
                    gameH.enemy_Fabimon.haveEffect[i] = -6;
                } else if (gameH.enemy_Fabimon.haveEffect[i] > 6) {
                    gameH.enemy_Fabimon.haveEffect[i] = 6;
                }
            }
        } else if (attacker.equals("enemy")) {
            for (int i = 0; i < gameH.enemy_Fabimon.haveEffect.length; i++) {
                if (gameH.own_Fabimon.haveEffect[i] == -6 || gameH.own_Fabimon.haveEffect[i] == 6) {
                    int temp = gameH.own_Fabimon.haveEffect[i] + gameH.enemy_Fabimon.move[enemyattack].effect[i];
                    if (temp < -6 || temp > 6) {
                        gameH.ui.currentDialogue[0] = "Deine Attacke ist fehlgeschlagen!";
                        return;
                    }
                }
                gameH.own_Fabimon.haveEffect[i] += gameH.enemy_Fabimon.move[enemyattack].effect[i];
                if (gameH.own_Fabimon.haveEffect[i] < -6) {
                    gameH.own_Fabimon.haveEffect[i] = -6;
                } else if (gameH.own_Fabimon.haveEffect[i] > 6) {
                    gameH.own_Fabimon.haveEffect[i] = 6;
                }
            }
        }
    }
    public int testCalculateEnemyDamage(int i){
        if (gameH.enemy_Fabimon.move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.sp_atk * getStep(gameH.enemy_Fabimon.haveEffect[4])) / (50 * gameH.own_Fabimon.sp_dev * getStep(gameH.own_Fabimon.haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.atk * getStep(gameH.enemy_Fabimon.haveEffect[2])) / (50 * gameH.own_Fabimon.dev * getStep(gameH.own_Fabimon.haveEffect[3])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
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
            double zr1 = (zr0 * gameH.enemy_Fabimon.sp_atk * getStep(gameH.enemy_Fabimon.haveEffect[4])) / (50 * gameH.own_Fabimon.sp_dev * getStep(gameH.own_Fabimon.haveEffect[5])) + 2;
            double zr2 = (int) zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("physical")) {
            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            double zr1 = (zr0 * gameH.enemy_Fabimon.atk * getStep(gameH.enemy_Fabimon.haveEffect[2])) / (50 * gameH.own_Fabimon.dev * getStep(gameH.own_Fabimon.haveEffect[3])) + 2;
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