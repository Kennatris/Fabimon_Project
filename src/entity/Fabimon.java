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
    public String sInfo[] = new String[2];
    public String name;
    public int level;
    public int hp;
    public int currentHp;
    public int atk;
    public int sp_atk;
    public int dev;
    public int sp_dev;
    public int init;
    public String type;
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
                tempFabimon = new Feirir(gameH, fabimonName, fabimonEvo, plevel);
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);
            }

        }else if(fabimonName.equals("cursed Shiggy")){
            if(fabimonEvo == 0){
                tempFabimon = new CursedShiggy(gameH, fabimonName, fabimonEvo, plevel);
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
    void setFabimonInfo(int plevel) {
        tempFabimon.name = sInfo[0];
        tempFabimon.type = sInfo[1];
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
        double zahl = Math.random() * 2;
        if(zahl < 0.5){
            tempFabimon.gender = "Female";
        }else{
            tempFabimon.gender = "Male";
        }
        for(int i = 0; i<iv.length; i++){
            int temp = (int)(Math.random()*32);
            tempFabimon.iv[i] = temp;
        }
        tempFabimon.move[3] = new Scratch(gameH);
        tempFabimon.move[1] = new Ember(gameH);
        tempFabimon.move[2] = new Scary_Face(gameH);
        tempFabimon.move[0] = new Growl(gameH);
    }

    public void getBaseInfo(String fileName, int evo) {
        try {

            String fileLocation = "res/Fabimon/" + fileName + "/BaseStats.txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);

            int statNum = 0;
            while (statNum < 14) {

                String line = br.readLine();

                String[] lineSplit = line.split(",");

                if(statNum == 0 || statNum == 1){
                    sInfo[statNum] = lineSplit[0];
                }else if(statNum > 1 && statNum < 8){
                    baseStats[statNum - 2] = Integer.parseInt(lineSplit[evo]);
                }else if(statNum > 7 && statNum < 14){
                    giveEV[statNum - 8] = Integer.parseInt(lineSplit[evo]);
                }
                statNum++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
