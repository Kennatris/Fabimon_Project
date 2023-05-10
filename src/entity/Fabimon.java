package entity;

import main.GameHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Fabimon extends Entity {

    public Fabimon tempFabimon;
    public int info[] = new int[12];
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

    public Fabimon(GameHandler gameH) {
        super(gameH);
    }

    public void createFabimon(int fabimonNum, int fabimonEvo, int plevel) {
        if(fabimonNum == 0){
            if(fabimonEvo == 0){
                tempFabimon = new Feirir(gameH);
                getBaseInfo("Feirir", fabimonEvo);
                setFabimonInfo(plevel);
            }
        }
    }

    private void setFabimonInfo(int plevel) {
        tempFabimon.name = sInfo[0];
        tempFabimon.type = sInfo[1];
        tempFabimon.hp = info[0];
        tempFabimon.atk = info[1];
        tempFabimon.dev = info[2];
        tempFabimon.sp_atk = info[3];
        tempFabimon.sp_dev = info[4];
        tempFabimon.init = info[5];
        tempFabimon.item = "none";
        tempFabimon.level = plevel;
        tempFabimon.currentHp = info[0];
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
                }else {
                    info[statNum - 2] = Integer.parseInt(lineSplit[evo]);
                }
                statNum++;
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
