import java.util.Random;

public class Stats {
    //Base
    //_-------------------------------------------------------------------
    //Fire stats
    public double HP_Fire[] = {39, 58, 78};
    public double Atk_Fire[] = {52, 64, 84};
    public double DEV_Fire[] = {43, 58, 78};
    public double Sp_Atk_Fire[] = {60, 80, 109};
    public double Sp_Dev_Fire[] = {50, 65, 85};
    public double Speed_Fire[] = {65, 80, 100};

    //--------------------------------------------------------------------
    //grass stats
    public double HP_Grass[] = {45, 60, 80};
    public double Atk_Grass[] = {49, 62, 82};
    public double DEV_Grass[] = {49, 63, 83};
    public double Sp_Atk_Grass[] = {65, 80, 100};
    public double Sp_Dev_Grass[] = {65, 80, 100};
    public double Speed_Grass[] = {45, 60, 80};

    //--------------------------------------------------------------------
    //water stats
    public double HP_Water[] = {45, 60, 80};
    public double Atk_Water[] = {49, 62, 82};
    public double DEV_Water[] = {49, 63, 83};
    public double Sp_Atk_Water[] = {65, 80, 100};
    public double Sp_Dev_Water[] = {65, 80, 100};
    public double Speed_Water[] = {45, 60, 80};
    //----------------------------------------------------------------------
    // IVs stats
    Random random = new Random();
    int upperbound = 31;

    //-----------------------------------------------------------------------
    // EVs stats
    public int EVs_Sp_Atk_Grass[] = {1, 2, 2};
    //erste entwicklung hat keinen evs für sp.dev grass
    public int EVs_Sp_Dev_Grass[] = {2, 2};
    public int Evs_Speed_fire[] = {1, 1};
    //erste entwicklung hat keinen evs für sp.atk fire
    public int Evs_Sp_Atk_fire[] = {1, 3};
    public int Evs_Dev_water[] = {1, 1};
    //erste entwicklung hat keinen evs für sp.dev water
    public int Evs_Sp_Dev_water[] = {1, 3};

    //--------------------------------------------------------------------------
    //level
    public int level;

    //--------------------------------------------------------------------------
    //Nature

    private double multiplikator_nature = 0.1;

    public double[] nature_Hardy =
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

    public double[] nature_Bold =
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

    public double[] nature_Modest =
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

    public double[] nature_Calm =
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

    public double[] nature_Timid =
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


    public double[] nature_Lonely =
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

    public double[] nature_Docile =
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

    public double[] nature_Mild =
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

    public double[] nature_Gentle =
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

    public double[] nature_Hasty =
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

    public double[] nature_Adamant =
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

    public double[] nature_Bashful =
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

    public double[] nature_Careful =
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

    public double[] nature_jolly =
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

    public double[] nature_Naughty =
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

    public double[] nature_Lax =
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

    public double[] nature_Rash =
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

    public double[] nature_Quirky =
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

    public double[] nature_Naive =
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

    public double[] nature_Brave =
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

    public double[] nature_Relaxed =
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

    public double[] nature_Quiet =
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

    public double[] nature_Sassy =
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

    public double[] nature_Serious =
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

//------------------------------------------------------------------------------------------------------------------
//
}