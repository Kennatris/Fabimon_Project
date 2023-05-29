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
    public int baseStats[] = new int[6];
    public int giveEV[] = new int[6]; // die Ev die ein Fabimon beim sieg übergibt.
    public int haveEV[] = {0, 0, 0, 0, 0, 0};
    public String sInfo[] = new String[3];
    public String name;
    public int baseEp;// EXP die ein Fabimon beim sieg übergibt
    public int currentEp;
    public int level;
    public int hp; // max HP
    public int currentHp;
    public int atk;
    public int sp_atk;
    public int dev;
    public int sp_dev;
    public int init;
    public String type1;
    public String type2;
    public String nature;
    public int haveEffect[] = {0, 0, 0, 0, 0, 0, 0};
    public Attack move[] = new Attack[5]; // die Attacken die ein Fabimon hat der 5 Attacke ist immer Struggle
    public String item;
    public String gender;
    public int iv[] = {0, 0, 0, 0, 0, 0};
    public GameHandler gameH;

    public Fabimon(GameHandler gameH) {
        super(gameH);
        this.gameH = gameH;

    }

    public void createFabimon(String fabimonName, int fabimonEvo, int plevel) {

        if(fabimonName.equals("Feirir")){
            if(fabimonEvo == 0){
                tempFabimon = new Feirir(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                setStats();
            }
        }else if(fabimonName.equals("cursed Shiggy")){
            if(fabimonEvo == 0){
                tempFabimon = new CursedShiggy(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                setStats();
            }
        }else if(fabimonName.equals("electric type")){
            if(fabimonEvo == 0){
                tempFabimon = new ElectricType(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                setStats();
            }
        }else if(fabimonName.equals("grass type")){
            if(fabimonEvo == 0){
                tempFabimon = new GrassType(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                setStats();
            }
        }else if(fabimonName.equals("Jubby")){
            if(fabimonEvo == 0){
                tempFabimon = new Jubby(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
                setStats();
            }
        }
    }
    public int berechneHP(){
        double ev = (tempFabimon.haveEV[0]/4);
        double stat = (2*baseStats[0]+tempFabimon.iv[0]+(int)ev);
        double statdurch100 = ((int)stat * tempFabimon.level)/100;
        double tempHP = (int)statdurch100+tempFabimon.level+10;
        return (int)tempHP;
    }
    public int berechneStat(int basestatIndex){
        double ev = (tempFabimon.haveEV[0]/4);
        double stat = (2*baseStats[basestatIndex]+tempFabimon.iv[basestatIndex]+ (int)ev);
        double nature = nat.getmultiplikator(tempFabimon.nature, basestatIndex);
        double statdurch100 = ((stat * tempFabimon.level)/100)+5;
        double berechnung = (int)statdurch100*nature;
        return (int)berechnung;
    }
    private void setIv(){ // setzt einen zufälligen wert zwischen 0 und 31
        for(int i = 0; i<iv.length; i++){
            int temp = (int)(Math.random()*32);
            tempFabimon.iv[i] = temp;
        }
        tempFabimon.move[3] = new Scratch(gameH);
        tempFabimon.move[1] = new Ember(gameH);
        tempFabimon.move[2] = new Scary_Face(gameH);
        tempFabimon.move[0] = new Growl(gameH);
    }
    void setFabimonInfo(int plevel) {
        setIv();
        double zahl = Math.random() * 2;
        if(zahl < 0.5){
            tempFabimon.gender = "Female";
        }else{
            tempFabimon.gender = "Male";
        }
        tempFabimon.name = sInfo[0];
        tempFabimon.type1 = sInfo[1];
        tempFabimon.type2 = sInfo[2];
        tempFabimon.level = plevel;
        tempFabimon.nature = nat.setNature(); //gibt eine zufällige Nature zurück
        tempFabimon.move[4] = new Struggle(gameH);

    }
    void setStats(){
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);
        tempFabimon.sp_atk = berechneStat(3);
        tempFabimon.sp_dev = berechneStat(4);
        tempFabimon.init = berechneStat(5);
        tempFabimon.item = "none";
        tempFabimon.currentHp = tempFabimon.hp;
    }
    public void setPlayerFabimon(int index, String psinfo[], String pmove[], int pap[], int pev[], int piv[], int pinfo[]){
        createFabimon(psinfo[0], 0, pinfo[0]);
        for(int i = 0; i<pev.length; i++) {
            tempFabimon.haveEV[i] = pev[i];
            tempFabimon.iv[i] = piv[i];
        }
        for(int i = 0; i<pmove.length; i++){
            setMove(pmove[i], i);
            tempFabimon.move[i].currentap = pap[i];
        }
        tempFabimon.nature = psinfo[3];
        tempFabimon.item = psinfo[1];
        tempFabimon.gender = psinfo[2];
        tempFabimon.currentEp = pinfo[2];
        tempFabimon.currentHp = pinfo[1];
        recalculate();
        gameH.player.fabimonTeam[index] = tempFabimon;
    }
    private void recalculate(){ // zum neuberechnen der Stats
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);
        tempFabimon.sp_atk = berechneStat(3);
        tempFabimon.sp_dev = berechneStat(4);
        tempFabimon.init = berechneStat(5);
    }
    public void recalculatePlayerFabimon(int index){ // zum neuberechnen der Stats nach bestimmte konditionen
        getBaseInfo(gameH.player.fabimonTeam[index].name, 0);
        gameH.player.fabimonTeam[index].hp = berechnePlayerFabimonHp(index);
        gameH.player.fabimonTeam[index].atk = berechnePlayerFabimonStats(index, 1);
        gameH.player.fabimonTeam[index].dev = berechnePlayerFabimonStats(index, 2);
        gameH.player.fabimonTeam[index].sp_atk = berechnePlayerFabimonStats(index, 3);
        gameH.player.fabimonTeam[index].sp_dev = berechnePlayerFabimonStats(index, 4);
        gameH.player.fabimonTeam[index].init = berechnePlayerFabimonStats(index, 5);
    }
    private int berechnePlayerFabimonStats(int index, int basestatIndex){
        double ev = (gameH.player.fabimonTeam[index].haveEV[0]/4);
        double stat = (2*baseStats[basestatIndex]+gameH.player.fabimonTeam[index].iv[basestatIndex]+ (int)ev);
        double nature = nat.getmultiplikator(gameH.player.fabimonTeam[index].nature, basestatIndex);
        double statdurch100 = ((stat * gameH.player.fabimonTeam[index].level)/100)+5;
        double berechnung = (int)statdurch100*nature;
        return (int)berechnung;
    }
    private int berechnePlayerFabimonHp(int index){
        double ev = (gameH.player.fabimonTeam[index].haveEV[0]/4);
        double stat = (2*baseStats[0]+gameH.player.fabimonTeam[index].iv[0]+(int)ev);
        double statdurch100 = ((int)stat * gameH.player.fabimonTeam[index].level)/100;
        double tempHP = (int)statdurch100+gameH.player.fabimonTeam[index].level+10;
        return (int)tempHP;
    }
    private void setMove(String pmove, int moveIndex){
        switch(pmove){
            case "Scratch": tempFabimon.move[moveIndex] = new Scratch(gameH); break;
            case "Ember": tempFabimon.move[moveIndex]  = new Ember(gameH); break;
            case "Scary_face": tempFabimon.move[moveIndex]  = new Scary_Face(gameH); break;
            case "Growl": tempFabimon.move[moveIndex]  = new Growl(gameH); break;
            default: break;
        }
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

                if(statNum == 0 || statNum == 1 || statNum == 2){
                    sInfo[statNum] = lineSplit[0];
                }else if(statNum > 2 && statNum < 9){
                    baseStats[statNum - 3] = Integer.parseInt(lineSplit[evo]);
                }else if(statNum > 8 && statNum < 15){
                    tempFabimon.giveEV[statNum - 9] = Integer.parseInt(lineSplit[evo]);
                }else if(statNum == 15){
                    tempFabimon.baseEp = Integer.parseInt(lineSplit[evo]);
                }
                statNum++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
