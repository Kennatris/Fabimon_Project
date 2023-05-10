package entity;

import java.util.Random;

public class Stats{


    protected static int typeValue[];
    protected static double HP_Fire[];
    protected static double Atk_Fire[];
    protected static double DEV_Fire[];
    protected static double Sp_Atk_Fire[];
    protected static double Sp_Dev_Fire[];
    protected static double Speed_Fire[];
    protected static double HP_Grass[];
    protected static double Atk_Grass[];
    protected static double DEV_Grass[];
    protected static double Sp_Atk_Grass[];
    protected static double Sp_Dev_Grass[];
    protected static double Speed_Grass[];
    protected static double HP_Water[];
    protected static double Atk_Water[];
    protected static double DEV_Water[];
    protected static double Sp_Atk_Water[];
    protected static double Sp_Dev_Water[];
    protected static double Speed_Water[];
    protected static double EXP[];
    protected static String moves[];
    protected static String types[];
    protected static int atk_move[];
    protected static double aktuelles_level;
    protected static  int accuracy_move[];


    //Base
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    //grass stats
    public double[] grass() {
        double HP_Grass[] = {45, 60, 80};
        double Atk_Grass[] = {49, 62, 82};
        double DEV_Grass[] = {49, 63, 83};
        double Sp_Atk_Grass[] = {65, 80, 100};
        double Sp_Dev_Grass[] = {65, 80, 100};
        double Speed_Grass[] = {45, 60, 80};
        return grass();
    }

    //------------------------------------------------------------------------------------------------------------------
    //water stats
    public double[] water() {
        double HP_Water[] = {45, 60, 80};
        double Atk_Water[] = {49, 62, 82};
        double DEV_Water[] = {49, 63, 83};
        double Sp_Atk_Water[] = {65, 80, 100};
        double Sp_Dev_Water[] = {65, 80, 100};
        double Speed_Water[] = {45, 60, 80};
        return water();
    }
    //------------------------------------------------------------------------------------------------------------------
    // IVs stats
    //generats a random value
    public static void ivs() {
        // Instance of random class
        Random rand = new Random();
        // Setting the upper bound to generate the
        // random numbers in specific range
        int upperbound = 31;
        // Generating random values from 0 to 31
        // using nextInt()
        int int_random = rand.nextInt(upperbound);
        // Generating random using nextDouble
        // in 0.0 and 1.0 range
        // Printing the generated random numbers
        System.out.println("Random integer(IVS) value from 0 to" + (upperbound) + " : " + int_random);

    }

    //------------------------------------------------------------------------------------------------------------------
    // EVs stats
    public void evs() {
        int EVs_Sp_Atk_Grass[] = {1, 1, 2};
        //first evolution has no evs for sp.dev grass
        int EVs_Sp_Dev_Grass[] = {0, 1, 1};
        int Evs_Speed_fire[] = {1, 1, 0};
        //first evolution has no evs for sp.atk fire
        int Evs_Sp_Atk_fire[] = {1, 3};
        int Evs_Dev_water[] = {1, 1};
        //first evolution has no evs for sp.dev water
        int Evs_Sp_Dev_water[] = {1, 3};
    }

    //------------------------------------------------------------------------------------------------------------------
    //level
    public static void exp() {
       int level = 1;
        double aktuelles_level = 1;
        boolean pokemon_win = false;


        //EXP Formular
        //value b for the formular
        int exp_fire[] = {62, 142, 267};
        int exp_grass[] = {64, 142, 263};
        int exp_water[] = {63, 142, 265};

        //if(item_lucky_egg==1){
        //  double e = 1.5;
        //}else if(item_lucky_egg==0){
        int e = 1;
        //}
        //by wild Pokémon
        int a = 1;
        //int a = 1.5 by trainer combat
        int t = 1;
        //medium slow bulbasaur, all fire evo
        //earned xp from a fight
        double EXP[] = {((exp_fire[0] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_fire[1] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_fire[2] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[0] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[1] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[2] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_water[0] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_water[1] * aktuelles_level) / 7) * 1 / 8 * e * a * t,
                ((exp_water[2] * aktuelles_level) / 7) * 1 / 8 * e * a * t,};

        double aktuelle_xp = 0;

        //xp total for slow medium
        int total_xp[] = {0, 9, 57, 96, 135, 179, 236, 314, 419, 560,
                742, 973, 1261, 1612, 2035, 2535, 3120, 3798, 4575, 5460,
                6458, 7577, 8825, 10208, 11735, 13411, 15244, 17242, 19411, 21760,
                24294, 27021, 29949, 33084, 36435, 40007, 43808, 47846, 52127, 56660,
                61450, 66505, 71833, 77440, 83335, 89523, 96012, 102810, 109923, 117360,
                125126, 133229, 141677, 150476, 159635, 169159, 179056, 189334, 199999, 211060,
                222522, 234393, 246681, 259392, 272535, 286115, 300140, 314618, 329555, 344960,
                360838, 377197, 394045, 411388, 429235, 447591, 466464, 485862, 505791, 526260,
                547274, 568841, 590969, 613664, 636935, 660787, 685228, 710266, 735907, 762160,
                789030, 816525, 844653, 873420, 902835, 932903, 963632, 995030, 1027103, 1059860};

        //xp needed for level up(slow medium)
        int next_level_xp[] = {9, 48, 39, 39, 44, 57, 78, 105, 141, 182,
                231, 288, 351, 423, 500, 585, 678, 777, 885, 998,
                1119, 1248, 1383, 1527, 1676, 1833, 1998, 2169, 2349, 2534,
                2727, 2928, 3135, 3351, 3572, 3801, 4038, 4281, 4533, 4790,
                5055, 5328, 5607, 5895, 6188, 6489, 6798, 7113, 7437, 7766,
                8103, 8448, 8799, 9159, 9524, 9897, 10278, 10665, 11061, 11462,
                11871, 12288, 12711, 13143, 13580, 14025, 14478, 14937, 15405, 15878,
                16359, 16848, 17343, 17847, 18356, 18873, 19398, 19929, 20469, 21014,
                21567, 22128, 22695, 23271, 24441, 25038, 25641, 26253, 26870, 27495,
                28128, 28767, 29415, 30068, 30792, 31398, 32073, 32757};
        //
        int temp = level - 1;
        // level calculation
        if (pokemon_win == true){
            aktuelle_xp = aktuelle_xp + EXP[0];
            while(aktuelle_xp> next_level_xp[temp]){
                level++;
                aktuelle_xp = aktuelle_xp - aktuelle_xp;
                aktuelles_level = level;

            }
        }
        System.out.println("level: " + aktuelles_level);
    }


    //------------------------------------------------------------------------------------------------------------------
    //Naturepublic void natue() {

    public void nature(){
        double multiplikator_nature = 0.1;
        double[] nature_Hardy =
                //stat that getting decreased
                {Atk_Fire[0] - Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] - Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] - Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Atk_Fire[0] + Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] + Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] + Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] + Atk_Water[2] * multiplikator_nature};

        double[] nature_Bold =
                //stat that getting decreased
                {Atk_Fire[0] - Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] - Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] - Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        DEV_Fire[0] + DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] + DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] + DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] + DEV_Water[2] * multiplikator_nature};

        double[] nature_Modest =
                //stat that getting decreased
                {Atk_Fire[0] - Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] - Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] - Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Atk_Fire[0] + Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] + Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] + Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature};

        double[] nature_Calm =
                //stat that getting decreased
                {Atk_Fire[0] - Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] - Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] - Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Dev_Fire[0] + Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] + Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] + Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature};

        double[] nature_Timid =
                //stat that getting decreased
                {Atk_Fire[0] - Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] - Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] - Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Speed_Fire[0] + Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] + Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] + Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] + Speed_Water[2] * multiplikator_nature};


        double[] nature_Lonely =
                //stat that getting decreased
                {DEV_Fire[0] - DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] - DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] - DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Atk_Fire[0] + Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] + Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] + Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] + Atk_Water[2] * multiplikator_nature};

        double[] nature_Docile =
                //stat that getting decreased
                {DEV_Fire[0] - DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] - DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] - DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        DEV_Fire[0] + DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] + DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] + DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] + DEV_Water[2] * multiplikator_nature};

        double[] nature_Mild =
                //stat that getting decreased
                {DEV_Fire[0] - DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] - DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] - DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Atk_Fire[0] + Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] + Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] + Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature};

        double[] nature_Gentle =
                //stat that getting decreased
                {DEV_Fire[0] - DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] - DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] - DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Dev_Fire[0] + Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] + Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] + Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature};

        double[] nature_Hasty =
                //stat that getting decreased
                {DEV_Fire[0] - DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] - DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] - DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Speed_Fire[0] + Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] + Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] + Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] + Speed_Water[2] * multiplikator_nature};

        double[] nature_Adamant =
                //stat that getting decreased
                {Sp_Atk_Fire[0] - Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] - Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] - Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Atk_Fire[0] + Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] + Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] + Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] + Atk_Water[2] * multiplikator_nature};

        double[] nature_Bashful =
                //stat that getting decreased
                {Sp_Atk_Fire[0] - Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] - Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] - Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Atk_Fire[0] + Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] + Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] + Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature};

        double[] nature_Careful =
                //stat that getting decreased
                {Sp_Atk_Fire[0] - Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] - Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] - Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Dev_Fire[0] + Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] + Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] + Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature};

        double[] nature_jolly =
                ///stat that getting decreased
                {Sp_Atk_Fire[0] - Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] - Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] - Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Speed_Fire[0] + Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] + Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] + Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] + Speed_Water[2] * multiplikator_nature};

        double[] nature_Naughty =
                //stat that getting decreased
                {Sp_Dev_Fire[0] - Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] - Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] - Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Atk_Fire[0] + Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] + Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] + Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] + Atk_Water[2] * multiplikator_nature};

        double[] nature_Lax =
                //stat that getting decreased
                {Sp_Dev_Fire[0] - Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] - Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] - Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        DEV_Fire[0] + DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] + DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] + DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] + DEV_Water[2] * multiplikator_nature};

        double[] nature_Rash =
                //stat that getting decreased
                {Sp_Dev_Fire[0] - Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] - Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] - Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Atk_Fire[0] + Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] + Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] + Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature};

        double[] nature_Quirky =
                //stat that getting decreased
                {Sp_Dev_Fire[0] - Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] - Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] - Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Dev_Fire[0] + Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] + Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] + Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature};

        double[] nature_Naive =
                //stat that getting decreased
                {Sp_Dev_Fire[0] - Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] - Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] - Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Speed_Fire[0] + Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] + Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] + Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] + Speed_Water[2] * multiplikator_nature};

        double[] nature_Brave =
                //stat that getting decreased
                {Speed_Fire[0] - Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] - Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] - Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Atk_Fire[0] + Atk_Fire[0] * multiplikator_nature,
                        Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                        Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                        Atk_Grass[0] + Atk_Grass[0] * multiplikator_nature,
                        Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                        Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                        Atk_Water[0] + Atk_Water[0] * multiplikator_nature,
                        Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                        Atk_Water[2] + Atk_Water[2] * multiplikator_nature};

        double[] nature_Relaxed =
                //stat that getting decreased
                {Speed_Fire[0] - Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] - Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] - Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        DEV_Fire[0] + DEV_Fire[0] * multiplikator_nature,
                        DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                        DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                        DEV_Grass[0] + DEV_Grass[0] * multiplikator_nature,
                        DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                        DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                        DEV_Water[0] + DEV_Water[0] * multiplikator_nature,
                        DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                        DEV_Water[2] + DEV_Water[2] * multiplikator_nature};

        double[] nature_Quiet =
                //stat that getting decreased
                {Speed_Fire[0] - Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] - Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] - Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Atk_Fire[0] + Sp_Atk_Fire[0] * multiplikator_nature,
                        Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                        Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                        Sp_Atk_Grass[0] + Sp_Atk_Grass[0] * multiplikator_nature,
                        Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                        Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                        Sp_Atk_Water[0] + Sp_Atk_Water[0] * multiplikator_nature,
                        Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                        Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature};

        double[] nature_Sassy =
                //stat that getting decreased
                {Speed_Fire[0] - Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] - Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] - Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Sp_Dev_Fire[0] + Sp_Dev_Fire[0] * multiplikator_nature,
                        Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                        Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                        Sp_Dev_Grass[0] + Sp_Dev_Grass[0] * multiplikator_nature,
                        Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                        Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                        Sp_Dev_Water[0] + Sp_Dev_Water[0] * multiplikator_nature,
                        Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                        Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature};

        double[] nature_Serious =
                //stat that getting decreased
                {Speed_Fire[0] - Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] - Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] - Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                        //stat that getting increased
                        Speed_Fire[0] + Speed_Fire[0] * multiplikator_nature,
                        Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                        Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                        Speed_Grass[0] + Speed_Grass[0] * multiplikator_nature,
                        Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                        Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                        Speed_Water[0] + Speed_Water[0] * multiplikator_nature,
                        Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                        Speed_Water[2] + Speed_Water[2] * multiplikator_nature};


    }

    //------------------------------------------------------------------------------------------------------------------
    //items
    public void items(){
        //lucky egg
        //potion
        //super potion
        //hyper potion
        //max potion
        //revive
        // Power Lens 	Hold items 	A Pokémon held item that promotes Sp. Atk gain on leveling, but reduces the Speed stat.
        // Power Weight 	Hold items 	A Pokémon held item that promotes HP gain on leveling, but reduces the Speed stat.
        //Power Bracer 	Hold items 	A Pokémon held item that promotes Attack gain on leveling, but reduces the Speed stat.
        //Power Belt 	Hold items 	A Pokémon held item that promotes Defense gain on leveling, but reduces the Speed stat.
        //Power Band 	Hold items 	A Pokémon held item that promotes Sp. Def gain on leveling, but reduces the Speed stat.
        //Power Anklet 	Hold items 	A Pokémon held item that promotes Speed gain on leveling, but reduces the Speed stat.
        //xp-share An item to be held by a Pokémon. The holder gets a share of a battle's Exp. Points without battling.
        //X Attack raises the Attack stat of a Pokémon in battle by two stages.
        //X Defense raises the Defense of a Pokémon in battle by two stages.
    }

    public static void moves() {
        String moves[]= {"scratch","growl","scare","ember","bubble","Absorb"};
        int atk_move[]= {	35,	0,	0,	40,	40,	40};
        int accuracy_move[]= {100,	100,	100,	100,	100,	100};


        // System.out.println("move value " + list.getattacke("growl"));
        // System.out.println("move value " + list.getattacke("scare"));
        // System.out.println("move value " + list.getattacke("ember"));
        // System.out.println("move value " + list.getattacke("bubble"));
        // System.out.println("move value " + list.getattacke("Absorb"));

    }
    public static void type() {
        String type[]= {"Fire","Grass","Water"};
        int typeValue[] = {1,2,3,};
        type[0]= "1"; //Fire
        type[1]= "2"; //Grass
        type[2]= "3"; //Water
        //int typeValue[] = {Integer.parseInt(type[0]),Integer.parseInt(type[1]),Integer.parseInt(type[2])};
        //if(typeValue[0]<typeValue[0]){
        System.out.println("type Fire: " +typeValue[0]);

        // }
    }
}