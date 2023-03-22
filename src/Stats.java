import java.util.Random;

public class Stats {
    public int base;
    public int item_lucky_egg;
    private double Atk_Fire[];
    private double DEV_Fire[];
    private double Sp_Atk_Fire[];
    private double Sp_Dev_Fire[];
    private double Speed_Fire[];
    private double Atk_Grass[];
    private double DEV_Grass[];
    private double Sp_Atk_Grass[];
    private double Sp_Dev_Grass[];
    private double Speed_Grass[];
    private double Atk_Water[];
    private double DEV_Water[];
    private double Sp_Atk_Water[];
    private double Sp_Dev_Water[];
    private double Speed_Water[];



    //Base
    //------------------------------------------------------------------------------------------------------------------
    //Fire stats
    public double[] fire() {
        double HP_Fire[] = {39, 58, 78};
        double Atk_Fire[] = {52, 64, 84};
        double DEV_Fire[] = {43, 58, 78};
        double Sp_Atk_Fire[] = {60, 80, 109};
        double Sp_Dev_Fire[] = {50, 65, 85};
        double Speed_Fire[] = {65, 80, 100};
        return fire();
    }

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
    public static void main( String args[] ) {
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
        //System.out.println("Random integer value from 0 to" + (upperbound) + " : " + int_random);
    }

    //------------------------------------------------------------------------------------------------------------------
    // EVs stats
    public void evs() {
         int EVs_Sp_Atk_Grass[] = {1, 2, 2};
        //first evolution has no evs for sp.dev grass
         int EVs_Sp_Dev_Grass[] = {2, 2};
         int Evs_Speed_fire[] = {1, 1};
        //first evolution has no evs for sp.atk fire
         int Evs_Sp_Atk_fire[] = {1, 3};
         int Evs_Dev_water[] = {1, 1};
        //first evolution has no evs for sp.dev water
         int Evs_Sp_Dev_water[] = {1, 3};
    }

    //------------------------------------------------------------------------------------------------------------------
    //level
    public void exp() {


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
        double EXP[] = {((exp_fire[1] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_fire[2] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_fire[3] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[1] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[2] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_grass[3] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_water[1] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_water[2] * base) / 7) * 1 / 8 * e * a * t,
                ((exp_water[3] * base) / 7) * 1 / 8 * e * a * t,};
        //xp needed for next level
        int next_level_xp[] = {0, 9, 57, 96, 135, 179, 236, 314, 419, 560,
                742, 973, 1261, 1612, 2035, 2535, 3120, 3798, 4575, 5460,
                6458, 7577, 8825, 10208, 11735, 13411, 15244, 17242, 19411, 21760,
                24294, 27021, 29949, 33084, 36435, 40007, 43808, 47846, 52127, 56660,
                61450, 66505, 71833, 77440, 83335, 89523, 96012, 102810, 109923, 117360,
                125126, 133229, 141677, 150476, 159635, 169159, 179056, 189334, 199999, 211060,
                222522, 234393, 246681, 259392, 272535, 286115, 300140, 314618, 329555, 344960,
                360838, 377197, 394045, 411388, 429235, 447591, 466464, 485862, 505791, 526260,
                547274, 568841, 590969, 613664, 636935, 660787, 685228, 710266, 735907, 762160,
                789030, 816525, 844653, 873420, 902835, 932903, 963632, 995030, 1027103, 1059860};

    }

    //------------------------------------------------------------------------------------------------------------------
    //Naturepublic void natue() {

    private double multiplikator_nature = 0.1;
    public void nature(){
            double[] nature_Hardy =
            //stat that getting decreased
            {Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] - Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] - Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] - Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] + Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] + Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] + Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] + Atk_Water[3] * multiplikator_nature};

            double[] nature_Bold =
            //stat that getting decreased
            {Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] - Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] - Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] - Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] + DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] + DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] + DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] + DEV_Water[3] * multiplikator_nature};

            double[] nature_Modest =
            //stat that getting decreased
            {Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] - Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] - Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] - Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] + Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] + Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] + Sp_Atk_Water[3] * multiplikator_nature};

            double[] nature_Calm =
            //stat that getting decreased
            {Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] - Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] - Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] - Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] + Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] + Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] + Sp_Dev_Water[3] * multiplikator_nature};

            double[] nature_Timid =
            //stat that getting decreased
            {Atk_Fire[1] - Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] - Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] - Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] - Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] - Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] - Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] - Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] - Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] - Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] + Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] + Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] + Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] + Speed_Water[3] * multiplikator_nature};


             double[] nature_Lonely =
            //stat that getting decreased
            {DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] - DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] - DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] - DEV_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] + Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] + Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] + Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] + Atk_Water[3] * multiplikator_nature};

            double[] nature_Docile =
            //stat that getting decreased
            {DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] - DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] - DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] - DEV_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] + DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] + DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] + DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] + DEV_Water[3] * multiplikator_nature};

            double[] nature_Mild =
            //stat that getting decreased
            {DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] - DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] - DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] - DEV_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] + Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] + Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] + Sp_Atk_Water[3] * multiplikator_nature};

            double[] nature_Gentle =
            //stat that getting decreased
            {DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] - DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] - DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] - DEV_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] + Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] + Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] + Sp_Dev_Water[3] * multiplikator_nature};

            double[] nature_Hasty =
            //stat that getting decreased
            {DEV_Fire[1] - DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] - DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] - DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] - DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] - DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] - DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] - DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] - DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] - DEV_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] + Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] + Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] + Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] + Speed_Water[3] * multiplikator_nature};

             double[] nature_Adamant =
            //stat that getting decreased
            {Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] - Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] - Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] - Sp_Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] + Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] + Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] + Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] + Atk_Water[3] * multiplikator_nature};

             double[] nature_Bashful =
            //stat that getting decreased
            {Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] - Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] - Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] - Sp_Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] + Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] + Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] + Sp_Atk_Water[3] * multiplikator_nature};

             double[] nature_Careful =
            //stat that getting decreased
            {Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] - Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] - Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] - Sp_Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] + Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] + Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] + Sp_Dev_Water[3] * multiplikator_nature};

            double[] nature_jolly =
            ///stat that getting decreased
            {Sp_Atk_Fire[1] - Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] - Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] - Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] - Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] - Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] - Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] - Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] - Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] - Sp_Atk_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] + Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] + Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] + Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] + Speed_Water[3] * multiplikator_nature};

            double[] nature_Naughty =
            //stat that getting decreased
            {Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] - Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] - Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] - Sp_Dev_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] + Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] + Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] + Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] + Atk_Water[3] * multiplikator_nature};

            double[] nature_Lax =
            //stat that getting decreased
            {Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] - Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] - Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] - Sp_Dev_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] + DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] + DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] + DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] + DEV_Water[3] * multiplikator_nature};

            double[] nature_Rash =
            //stat that getting decreased
            {Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] - Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] - Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] - Sp_Dev_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] + Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] + Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] + Sp_Atk_Water[3] * multiplikator_nature};

            double[] nature_Quirky =
            //stat that getting decreased
            {Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] - Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] - Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] - Sp_Dev_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] + Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] + Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] + Sp_Dev_Water[3] * multiplikator_nature};

            double[] nature_Naive =
            //stat that getting decreased
            {Sp_Dev_Fire[1] - Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] - Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] - Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] - Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] - Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] - Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] - Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] - Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] - Sp_Dev_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] + Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] + Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] + Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] + Speed_Water[3] * multiplikator_nature};

            double[] nature_Brave =
            //stat that getting decreased
            {Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] - Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] - Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] - Speed_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Atk_Fire[1] + Atk_Fire[1] * multiplikator_nature,
                    Atk_Fire[2] + Atk_Fire[2] * multiplikator_nature,
                    Atk_Fire[3] + Atk_Fire[3] * multiplikator_nature,
                    Atk_Grass[1] + Atk_Grass[1] * multiplikator_nature,
                    Atk_Grass[2] + Atk_Grass[2] * multiplikator_nature,
                    Atk_Grass[3] + Atk_Grass[3] * multiplikator_nature,
                    Atk_Water[1] + Atk_Water[1] * multiplikator_nature,
                    Atk_Water[2] + Atk_Water[2] * multiplikator_nature,
                    Atk_Water[3] + Atk_Water[3] * multiplikator_nature};

            double[] nature_Relaxed =
            //stat that getting decreased
            {Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] - Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] - Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] - Speed_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    DEV_Fire[1] + DEV_Fire[1] * multiplikator_nature,
                    DEV_Fire[2] + DEV_Fire[2] * multiplikator_nature,
                    DEV_Fire[3] + DEV_Fire[3] * multiplikator_nature,
                    DEV_Grass[1] + DEV_Grass[1] * multiplikator_nature,
                    DEV_Grass[2] + DEV_Grass[2] * multiplikator_nature,
                    DEV_Grass[3] + DEV_Grass[3] * multiplikator_nature,
                    DEV_Water[1] + DEV_Water[1] * multiplikator_nature,
                    DEV_Water[2] + DEV_Water[2] * multiplikator_nature,
                    DEV_Water[3] + DEV_Water[3] * multiplikator_nature};

            double[] nature_Quiet =
            //stat that getting decreased
            {Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] - Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] - Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] - Speed_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Atk_Fire[1] + Sp_Atk_Fire[1] * multiplikator_nature,
                    Sp_Atk_Fire[2] + Sp_Atk_Fire[2] * multiplikator_nature,
                    Sp_Atk_Fire[3] + Sp_Atk_Fire[3] * multiplikator_nature,
                    Sp_Atk_Grass[1] + Sp_Atk_Grass[1] * multiplikator_nature,
                    Sp_Atk_Grass[2] + Sp_Atk_Grass[2] * multiplikator_nature,
                    Sp_Atk_Grass[3] + Sp_Atk_Grass[3] * multiplikator_nature,
                    Sp_Atk_Water[1] + Sp_Atk_Water[1] * multiplikator_nature,
                    Sp_Atk_Water[2] + Sp_Atk_Water[2] * multiplikator_nature,
                    Sp_Atk_Water[3] + Sp_Atk_Water[3] * multiplikator_nature};

            double[] nature_Sassy =
            //stat that getting decreased
            {Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] - Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] - Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] - Speed_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Sp_Dev_Fire[1] + Sp_Dev_Fire[1] * multiplikator_nature,
                    Sp_Dev_Fire[2] + Sp_Dev_Fire[2] * multiplikator_nature,
                    Sp_Dev_Fire[3] + Sp_Dev_Fire[3] * multiplikator_nature,
                    Sp_Dev_Grass[1] + Sp_Dev_Grass[1] * multiplikator_nature,
                    Sp_Dev_Grass[2] + Sp_Dev_Grass[2] * multiplikator_nature,
                    Sp_Dev_Grass[3] + Sp_Dev_Grass[3] * multiplikator_nature,
                    Sp_Dev_Water[1] + Sp_Dev_Water[1] * multiplikator_nature,
                    Sp_Dev_Water[2] + Sp_Dev_Water[2] * multiplikator_nature,
                    Sp_Dev_Water[3] + Sp_Dev_Water[3] * multiplikator_nature};

            double[] nature_Serious =
            //stat that getting decreased
            {Speed_Fire[1] - Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] - Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] - Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] - Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] - Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] - Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] - Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] - Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] - Speed_Water[3] * multiplikator_nature,
                    //stat that getting increased
                    Speed_Fire[1] + Speed_Fire[1] * multiplikator_nature,
                    Speed_Fire[2] + Speed_Fire[2] * multiplikator_nature,
                    Speed_Fire[3] + Speed_Fire[3] * multiplikator_nature,
                    Speed_Grass[1] + Speed_Grass[1] * multiplikator_nature,
                    Speed_Grass[2] + Speed_Grass[2] * multiplikator_nature,
                    Speed_Grass[3] + Speed_Grass[3] * multiplikator_nature,
                    Speed_Water[1] + Speed_Water[1] * multiplikator_nature,
                    Speed_Water[2] + Speed_Water[2] * multiplikator_nature,
                    Speed_Water[3] + Speed_Water[3] * multiplikator_nature};


    }

    //------------------------------------------------------------------------------------------------------------------
    //items
    public void items(){

    }
        public int getItem_lucky_egg() {
             return item_lucky_egg;
    }

    public void setItem_lucky_egg(int item_lucky_egg) {
        this.item_lucky_egg = item_lucky_egg;
    }
}