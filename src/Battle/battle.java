package Battle;

import main.GameHandler;

public class battle {
    public int phase = 0;
    GameHandler gameH;
    String prio = "";
    int enemyattack;

    public battle(GameHandler gameH) {
        this.gameH = gameH;
    }

    public void battleRound() {
        if(gameH.own_Fabimon.currentHp <= 0){
            System.out.println("verloren");
        }else if(gameH.enemy_Fabimon.currentHp <=0){
            System.out.println("gewonnen");
        }
        if (phase == 0) {
            enemyattack = getenemyattack();
            prio = priority(enemyattack);
        }
        if (prio.equals("own")) {
            if (phase == 0) {
                gameH.enemy_Fabimon.currentHp -= calculateOwnDamage();
            } else if (phase == 1) {
                gameH.own_Fabimon.currentHp -= calculateEnemyDamage(enemyattack);

            }else if(phase == 2){
                gameH.battleSubState = gameH.mainMenu;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        } else if (prio.equals("enemy")) {
            if (phase == 0) {
                gameH.own_Fabimon.currentHp -= calculateEnemyDamage(enemyattack);
            } else if (phase == 1) {
                gameH.enemy_Fabimon.currentHp -= calculateOwnDamage();
            }else if(phase == 2){
                gameH.battleSubState = gameH.mainMenu;
                phase = -1;
                gameH.ui.currentDialogue[0] = "Was willst du machen?";
                gameH.ui.currentDialogue[1] = "";
            }
        }
    }

    public int getenemyattack() {
        for (int i = 0; i < 4; i++) {
            int temp = gameH.own_Fabimon.currentHp - calculateEnemyDamage(i);
            if (temp <= 0 && gameH.enemy_Fabimon.move[i].ap != 0) {
                return i;
            }
        }
        int rand = (int) (Math.random() * 4);
        return rand;
    }
    private int volltreffer(){
        int ran = (int)(Math.random()*101);
        if(ran <= 6){
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
            int zr1 = (zr0 * gameH.own_Fabimon.sp_atk) / (50 * gameH.enemy_Fabimon.sp_dev) + 2;
            double zr2 = zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
            return (int) zr2;

        } else if (gameH.own_Fabimon.move[gameH.ui.commandNum].category.equals("physical")) {
            double basisschaden = gameH.own_Fabimon.move[gameH.ui.commandNum].power;
            int zr0 = ((gameH.own_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            int zr1 = (zr0 * gameH.own_Fabimon.atk) / (50 * gameH.enemy_Fabimon.dev) + 2;
            double zr2 = zr1 * z * volltreffer();
            gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
            return (int) zr2;
        } else if (gameH.own_Fabimon.move[gameH.ui.commandNum].category.equals("status")) {
            gameH.ui.currentDialogue[0] = gameH.own_Fabimon.name + " nutzt " + gameH.own_Fabimon.move[gameH.ui.commandNum].name + ".";
        }

        return 0;
    }

    public int calculateEnemyDamage(int i) {
        if (gameH.enemy_Fabimon.move[i].category.equals("special")) {

            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            int zr1 = (zr0 * gameH.enemy_Fabimon.sp_atk) / (50 * gameH.own_Fabimon.sp_dev) + 2;
            double zr2 = zr1 * z* volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("physical")) {

            double basisschaden = gameH.enemy_Fabimon.move[i].power;
            int zr0 = ((gameH.enemy_Fabimon.level * 2) / 5) + 2;
            zr0 = zr0 * (int) basisschaden;
            double z = (100 - (Math.random() * 16)) / 100;
            int zr1 = (zr0 * gameH.enemy_Fabimon.atk) / (50 * gameH.own_Fabimon.dev) + 2;
            double zr2 = zr1 * z *volltreffer();
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
            return (int) zr2;
        } else if (gameH.enemy_Fabimon.move[i].category.equals("status")) {
            gameH.ui.currentDialogue[0] = "Der gegnerische " + gameH.enemy_Fabimon.name + " nutzt " + gameH.enemy_Fabimon.move[enemyattack].name + ".";
        }

        return 0;
    }
}
