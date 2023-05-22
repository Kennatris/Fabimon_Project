package entity;

import Battle.Attack;
import Battle.attacks.Ember;
import Battle.attacks.Growl;
import Battle.attacks.Scary_Face;
import Battle.attacks.Scratch;
import entity.FabimonOrdner.CursedShiggy;
import entity.FabimonOrdner.Feirir;
import main.GameHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Fabimon extends Entity {

    public Fabimon tempFabimon;
    Nature nat = new Nature();
    public int baseStats[] = new int[6];
    public int giveEV[] = new int[6];
    public int haveEV[] = {0, 0, 0, 0, 0, 0};
    public String sInfo[] = new String[3];
    public String name;
    public int baseEp;
    public int currentEp;
    public int level;
    public int hp;
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
    public Attack move[] = new Attack[4];
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
            }

        }else if(fabimonName.equals("cursed Shiggy")){
            if(fabimonEvo == 0){
                tempFabimon = new CursedShiggy(gameH);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
            }
        }
    }
    public int berechneHP(){
        double ev = (haveEV[0]/4);
        double stat = (2*baseStats[0]+iv[0]+ (int)ev);
        double statdurch100 = ((int)stat * tempFabimon.level)/100;
        double tempHP = (int)statdurch100+tempFabimon.level+10;
        return (int)tempHP;
    }
    public int berechneStat(int basestatIndex){
        double ev = (haveEV[0]/4);
        double stat = (2*baseStats[basestatIndex]+iv[basestatIndex]+ (int)ev);
        double nature = nat.getmultiplikator(tempFabimon.nature, basestatIndex);
        double statdurch100 = ((stat * tempFabimon.level)/100)+5;
        double berechnung = (int)statdurch100*nature;
        return (int)berechnung;
    }
    private void setIv(){
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
        tempFabimon.nature = nat.setNature();
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);;
        tempFabimon.sp_atk = berechneStat(3);;
        tempFabimon.sp_dev = berechneStat(4);;
        tempFabimon.init = berechneStat(5);;
        tempFabimon.item = "none";
        tempFabimon.currentHp = tempFabimon.hp;
    }
    public void setPlayerFabimon(int index, String psinfo[], String pmove[], int pap[], int pev[], int piv[], int pinfo[]){
        createPlayerFabimon(psinfo[0], index);
        gameH.player.fabimonTeam[index].name = psinfo[0];
        gameH.player.fabimonTeam[index].item = psinfo[1];
        gameH.player.fabimonTeam[index].gender = psinfo[2];
        gameH.player.fabimonTeam[index].nature = psinfo[3];
        gameH.player.fabimonTeam[index].currentEp = pinfo[2];
        gameH.player.fabimonTeam[index].currentHp = pinfo[1];
        gameH.player.fabimonTeam[index].level = pinfo[0];
        for(int i = 0; i<pmove.length; i++){
            setMove(index, pmove[i], i);
            gameH.player.fabimonTeam[index].move[i].ap = pap[i];
            System.out.println(gameH.player.fabimonTeam[index].move[i].ap);
        }
        for(int i = 0; i<pev.length; i++){
            gameH.player.fabimonTeam[index].haveEV[i] = pev[i];
            gameH.player.fabimonTeam[index].iv[i] = piv[i];
        }
        tempFabimon.hp = berechneHP();
        tempFabimon.atk = berechneStat(1);
        tempFabimon.dev = berechneStat(2);;
        tempFabimon.sp_atk = berechneStat(3);;
        tempFabimon.sp_dev = berechneStat(4);;
        tempFabimon.init = berechneStat(5);;
    }
    private void createPlayerFabimon(String name, int index){
        switch(name){
            case "Feirir": gameH.player.fabimonTeam[index] = new Feirir(gameH); break;
            case "cursed Shiggy": gameH.player.fabimonTeam[index] = new CursedShiggy(gameH); break;
        }
    }
    private void setMove(int index, String pmove, int moveIndex){
        switch(pmove){
            case "Scratch": gameH.player.fabimonTeam[index].move[moveIndex] = new Scratch(gameH); break;
            case "Ember": gameH.player.fabimonTeam[index].move[moveIndex] = new Ember(gameH); break;
            case "Scary_face": gameH.player.fabimonTeam[index].move[moveIndex] = new Scary_Face(gameH); break;
            case "Growl": gameH.player.fabimonTeam[index].move[moveIndex] = new Growl(gameH); break;
            default: break;
        }
    }
    public void getBaseInfo(String fileName, int evo) {
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
