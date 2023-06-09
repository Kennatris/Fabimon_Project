package entity;

import Battle.Attack;
import Battle.attacks.*;
import entity.FabimonOrdner.*;
import main.GameHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Fabimon extends Entity {

    public Fabimon tempFabimon;
    Nature nat = new Nature();
    public int[] baseStats = new int[6];
    public int[] giveEV = new int[6]; // die Ev die ein Fabimon beim sieg übergibt.
    public int[] haveEV = {0, 0, 0, 0, 0, 0};
    public String[][] moveSet = new String[2][30];
    public String[] sInfo = new String[3];
    public String name;
    public int baseEp;// EXP die ein Fabimon beim sieg übergibt
    public int currentEp;
    int[] newmoves = new int[3];
    int anzahl = 0;
    Boolean haveMove = false;
    public int level;
    public int hp; // max HP
    public int currentHp;
    public int phase = 0;
    public int atk;
    public int sp_atk;
    public int dev;
    public int sp_dev;
    public int init;
    public String type1;
    public String type2;
    public String nature;
    public int[] haveEffect = {0, 0, 0, 0, 0, 0, 0};
    public Attack[] move = new Attack[5]; // die Attacken die ein Fabimon hat, die 5 Attacke ist immer Struggle
    public String item;
    public String gender;
    public int[] iv = {0, 0, 0, 0, 0, 0};
    public GameHandler gameH;

    public Fabimon(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;

    }

    public void createFabimon(String fabimonName, int fabimonEvo, int plevel) {

        if (fabimonName.equals("Feirir")) {
            if (fabimonEvo == 0) {
                tempFabimon = new Feirir(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                getmoveSet(fabimonName);
                setMoveSet();
                setStats();
            }
        } else if (fabimonName.equals("cursed Shiggy")) {
            if (fabimonEvo == 0) {
                tempFabimon = new CursedShiggy(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                getmoveSet(fabimonName);
                setMoveSet();
                setStats();
            }
        } else if (fabimonName.equals("electric type")) {
            if (fabimonEvo == 0) {
                tempFabimon = new ElectricType(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                getmoveSet(fabimonName);
                setMoveSet();
                setStats();
            }
        } else if (fabimonName.equals("grass type")) {
            if (fabimonEvo == 0) {
                tempFabimon = new GrassType(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                getmoveSet(fabimonName);
                setMoveSet();
                setStats();
            }
        } else if (fabimonName.equals("Jubby")) {
            if (fabimonEvo == 0) {
                tempFabimon = new Jubby(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                getmoveSet(fabimonName);
                setMoveSet();
                setStats();
            }
        }
    }

    public int berechneHP() {
        double ev = (tempFabimon.haveEV[0] / 4);
        double stat = (2 * baseStats[0] + tempFabimon.iv[0] + (int) ev);
        double statdurch100 = ((int) stat * tempFabimon.level) / 100;
        double tempHP = (int) statdurch100 + tempFabimon.level + 10;
        return (int) tempHP;
    }

    public int berechneStat(int basestatIndex) {
        double ev = (tempFabimon.haveEV[0] / 4);
        double stat = (2 * baseStats[basestatIndex] + tempFabimon.iv[basestatIndex] + (int) ev);
        double nature = nat.getmultiplikator(tempFabimon.nature, basestatIndex);
        double statdurch100 = ((stat * tempFabimon.level) / 100) + 5;
        double berechnung = (int) statdurch100 * nature;
        return (int) berechnung;
    }

    private void setIv() { // setzt einen zufälligen wert zwischen 0 und 31
        for (int i = 0; i < iv.length; i++) {
            int temp = (int) (Math.random() * 32);
            tempFabimon.iv[i] = temp;
        }

    }

    public void setMoveSet() {
        int move = 0;
        while (Integer.parseInt(tempFabimon.moveSet[0][move]) <= tempFabimon.level) {
            move++;
        }
        move--;
        for (int i = 0; i < 4; i++) {
            if (move >= 0) {
                setMove(tempFabimon.moveSet[1][move], i);
                move--;
            }
        }

    }

    void setFabimonInfo(int plevel) {
        setIv();
        double zahl = Math.random() * 2;
        if (zahl < 0.5) {
            tempFabimon.gender = "Female";
        } else {
            tempFabimon.gender = "Male";
        }
        tempFabimon.name = sInfo[0];
        tempFabimon.type1 = sInfo[1];
        tempFabimon.type2 = sInfo[2];
        tempFabimon.level = plevel;
        tempFabimon.nature = nat.setNature(); //gibt eine zufällige Nature zurück
        tempFabimon.move[4] = new Struggle(gameH);
    }

    void setStats() {
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);
        tempFabimon.sp_atk = berechneStat(3);
        tempFabimon.sp_dev = berechneStat(4);
        tempFabimon.init = berechneStat(5);
        tempFabimon.item = "none";
        tempFabimon.currentHp = tempFabimon.hp;
    }

    public void setNPCFabimon(int npc, int index, String[] psinfo, int[] pev, int[] piv, int plevel) {
        createFabimon(psinfo[0], 0, plevel);
        for (int i = 0; i < pev.length; i++) {
            tempFabimon.haveEV[i] = pev[i];
            tempFabimon.iv[i] = piv[i];
        }

        tempFabimon.nature = psinfo[3];
        tempFabimon.item = psinfo[2];
        tempFabimon.gender = psinfo[1];
        recalculate();
        tempFabimon.currentHp = tempFabimon.hp;
        gameH.npc[npc].fabimonTeam[index] = tempFabimon;
    }

    public void setPlayerFabimon(int index, String[] psinfo, String[] pmove, int[] pap, int[] pev, int[] piv, int[] pinfo) {
        createFabimon(psinfo[0], 0, pinfo[0]);
        for (int i = 0; i < pev.length; i++) {
            tempFabimon.haveEV[i] = pev[i];
            tempFabimon.iv[i] = piv[i];
        }
        for (int i = 0; i < pmove.length; i++) {
            setMove(pmove[i], i);
            if (tempFabimon.move[i] != null) {
                tempFabimon.move[i].currentap = pap[i];
            }
        }
        tempFabimon.nature = psinfo[3];
        tempFabimon.item = psinfo[1];
        tempFabimon.gender = psinfo[2];
        tempFabimon.currentEp = pinfo[2];
        tempFabimon.currentHp = pinfo[1];
        recalculate();
        gameH.player.fabimonTeam[index] = tempFabimon;
    }

    private void recalculate() { // zum neuberechnen der Stats
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);
        tempFabimon.sp_atk = berechneStat(3);
        tempFabimon.sp_dev = berechneStat(4);
        tempFabimon.init = berechneStat(5);
    }

    public void recalculatePlayerFabimon(int index) { // zum neuberechnen der Stats nach bestimmte konditionen
        getBaseInfo(gameH.player.fabimonTeam[index].name, 0);
        gameH.player.fabimonTeam[index].hp = berechnePlayerFabimonHp(index);
        gameH.player.fabimonTeam[index].atk = berechnePlayerFabimonStats(index, 1);
        gameH.player.fabimonTeam[index].dev = berechnePlayerFabimonStats(index, 2);
        gameH.player.fabimonTeam[index].sp_atk = berechnePlayerFabimonStats(index, 3);
        gameH.player.fabimonTeam[index].sp_dev = berechnePlayerFabimonStats(index, 4);
        gameH.player.fabimonTeam[index].init = berechnePlayerFabimonStats(index, 5);
    }

    private int berechnePlayerFabimonStats(int index, int basestatIndex) {
        double ev = (gameH.player.fabimonTeam[index].haveEV[0] / 4);
        double stat = (2 * baseStats[basestatIndex] + gameH.player.fabimonTeam[index].iv[basestatIndex] + (int) ev);
        double nature = nat.getmultiplikator(gameH.player.fabimonTeam[index].nature, basestatIndex);
        double statdurch100 = ((stat * gameH.player.fabimonTeam[index].level) / 100) + 5;
        double berechnung = (int) statdurch100 * nature;
        return (int) berechnung;
    }

    private int berechnePlayerFabimonHp(int index) {
        double ev = (gameH.player.fabimonTeam[index].haveEV[0] / 4);
        double stat = (2 * baseStats[0] + gameH.player.fabimonTeam[index].iv[0] + (int) ev);
        double statdurch100 = ((int) stat * gameH.player.fabimonTeam[index].level) / 100;
        double tempHP = (int) statdurch100 + gameH.player.fabimonTeam[index].level + 10;
        return (int) tempHP;
    }

    private void setMove(String pmove, int moveIndex) {
        switch (pmove) {
            case "Scratch":
                tempFabimon.move[moveIndex] = new Scratch(gameH);
                break;
            case "Ember":
                tempFabimon.move[moveIndex] = new Ember(gameH);
                break;
            case "Scary Face":
                tempFabimon.move[moveIndex] = new Scary_Face(gameH);
                break;
            case "Absorb":
                tempFabimon.move[moveIndex] = new Absorb(gameH);
                break;
            case "Apple Acid":
                tempFabimon.move[moveIndex] = new Apple_Acid(gameH);
                break;
            case "Aqua Tail":
                tempFabimon.move[moveIndex] = new Aqua_Tail(gameH);
                break;
            case "Armor Cannon":
                tempFabimon.move[moveIndex] = new Armor_Cannon(gameH);
                break;
            case "Assurance":
                tempFabimon.move[moveIndex] = new Assurance(gameH);
                break;
            case "Baddy Bad":
                tempFabimon.move[moveIndex] = new Baddy_Bad(gameH);
                break;
            case "Bite":
                tempFabimon.move[moveIndex] = new Bite(gameH);
                break;
            case "Blast Burn":
                tempFabimon.move[moveIndex] = new Blast_Burn(gameH);
                break;
            case "Bouncy Bubble":
                tempFabimon.move[moveIndex] = new Bouncy_Bubble(gameH);
                break;
            case "Bubble":
                tempFabimon.move[moveIndex] = new Bubble(gameH);
                break;
            case "Drum Beating":
                tempFabimon.move[moveIndex] = new Drum_Beating(gameH);
                break;
            case "Growl":
                tempFabimon.move[moveIndex] = new Growl(gameH);
                break;
            default:
                break;
        }
    }
    private void lernMove(String pmove, int moveIndex){
        switch (pmove) {
            case "Scratch":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Scratch(gameH);
                break;
            case "Ember":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Ember(gameH);
                break;
            case "Scary Face":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Scary_Face(gameH);
                break;
            case "Absorb":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Absorb(gameH);
                break;
            case "Apple Acid":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Apple_Acid(gameH);
                break;
            case "Aqua Tail":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Aqua_Tail(gameH);
                break;
            case "Armor Cannon":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Armor_Cannon(gameH);
                break;
            case "Assurance":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Assurance(gameH);
                break;
            case "Baddy Bad":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Baddy_Bad(gameH);
                break;
            case "Bite":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Bite(gameH);
                break;
            case "Blast Burn":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Blast_Burn(gameH);
                break;
            case "Bouncy Bubble":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Bouncy_Bubble(gameH);
                break;
            case "Bubble":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Bubble(gameH);
                break;
            case "Drum Beating":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Drum_Beating(gameH);
                break;
            case "Growl":
                gameH.player.fabimonTeam[0].move[moveIndex] = new Growl(gameH);
                break;
            default:
                break;
        }
    }

    public void checkNewMove() {
        if (phase == 0) {
            anzahl = 0;
            for (int i = 0; i < gameH.player.fabimonTeam[0].moveSet[0].length; i++) {
                if ((gameH.player.fabimonTeam[0].moveSet[0][i]) != null) {
                    if (gameH.player.fabimonTeam[0].level == Integer.parseInt(gameH.player.fabimonTeam[0].moveSet[0][i])) {
                        for (int j = 0; j < 4; j++) {
                            if (gameH.player.fabimonTeam[0].move[j] != null) {
                                if (gameH.player.fabimonTeam[0].moveSet[1][i].equals(gameH.player.fabimonTeam[0].move[j].name)) {
                                    haveMove = true;
                                }
                            }
                        }
                        if (!haveMove) {
                            newmoves[anzahl] = i;
                            anzahl++;
                        }
                        haveMove = false;
                    }
                }
            }
            if(anzahl == 0){
                phase = -1;
                gameH.gameSubState = gameH.attackMenu;
                gameH.battle.battleRound();
                gameH.battle.phase++;


            }else {
                gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " möchte " + gameH.player.fabimonTeam[0].moveSet[1][newmoves[0]] + " erlernen";
            }

        } else if (phase == 1) {
            for (int j = 0; j < 3; j++) {
                if (!gameH.player.fabimonTeam[0].moveSet[1][newmoves[j]].equals("nichts")) {
                    Boolean learned = false;
                    for (int i = 0; i < 4; i++) {
                        if (gameH.player.fabimonTeam[0].move[i] == null && !learned) {
                            lernMove(gameH.player.fabimonTeam[0].moveSet[1][newmoves[j]], i);
                            gameH.ui.currentDialogue[0] = gameH.player.fabimonTeam[0].name + " hat " + gameH.player.fabimonTeam[0].move[i].name + " gelernt.";
                            learned = true;
                        }
                    }
                    if(!learned){
                    }
                }
            }


        }else if(phase == 2){
            phase = -1;
            gameH.battle.battleRound();
            gameH.battle.phase++;
            gameH.gameSubState = gameH.attackMenu;


        }
        phase++;
    }

    public void getBaseInfo(String fileName, int evo) {// lest die Daten aus BaseStats.txt aus
        try {

            String fileLocation = "res/Fabimon/" + fileName + "/BaseStats.txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);

            int statNum = 0;
            while (statNum < 16) {

                String line = br.readLine();

                String[] lineSplit = line.split(",");

                if (statNum == 0 || statNum == 1 || statNum == 2) {
                    sInfo[statNum] = lineSplit[0];
                } else if (statNum > 2 && statNum < 9) {
                    baseStats[statNum - 3] = Integer.parseInt(lineSplit[evo]);
                } else if (statNum > 8 && statNum < 15) {
                    tempFabimon.giveEV[statNum - 9] = Integer.parseInt(lineSplit[evo]);
                } else if (statNum == 15) {
                    tempFabimon.baseEp = Integer.parseInt(lineSplit[evo]);
                }
                statNum++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void getmoveSet(String fileName) {
        try {

            String fileLocation = "res/Fabimon/" + fileName + "/Moveset.txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);

            int moveNum = 0;
            Boolean lastLine = false;
            while (!lastLine) {

                String line = br.readLine();
                if (line == null) {
                    lastLine = true;
                } else {
                    String[] lineSplit = line.split("~");
                    tempFabimon.moveSet[0][moveNum] = lineSplit[0];
                    tempFabimon.moveSet[1][moveNum] = lineSplit[1];
                    moveNum++;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
