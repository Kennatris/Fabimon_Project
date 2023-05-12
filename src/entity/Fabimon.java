package entity;

import main.GameHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Fabimon extends Entity {

    public Fabimon tempFabimon;
    nature nat = new nature();
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
    public String move[] = new String[4];
    public String item;
    public String gender;
    public int iv[] = {15, 0, 0, 0, 0, 0};

    public Fabimon(GameHandler gameH) {
        super(gameH);
    }

    public void createFabimon(String fabimonName, int fabimonEvo, int plevel) {
        if(fabimonName.equals("Feirir")){
            if(fabimonEvo == 0){
                tempFabimon = new Feirir(gameH);
                setIV();
                tempFabimon.nature = nat.setNature();
                tempFabimon.type = ("Fire");
                if(tempFabimon.nature.equals("redo")){
                    tempFabimon.nature = nat.setNature();
                }
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);

            }

        }else if(fabimonName.equals("cursed Shiggy")){
            if(fabimonEvo == 0){
                tempFabimon = new cursedShiggy(gameH);
                setIV();
                tempFabimon.nature = nat.setNature();
                if(tempFabimon.nature.equals("redo")){
                    tempFabimon.nature = nat.setNature();
                }
                getBaseInfo(fabimonName, fabimonEvo);
                setFabimonInfo(plevel);

            }
        }
    }
    public void setIV(){
        for(int i = 0; i<iv.length; i++){
            int temp = (int)(Math.random()*32);
            iv[i] = temp;
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

    private void setFabimonInfo(int plevel) {
        tempFabimon.name = sInfo[0];
        tempFabimon.type = sInfo[1];
        tempFabimon.level = plevel;
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
