package objects;

public class Stats extends Fabimon{

    //multiplier stat
    public final double multiplier = 1.1;

    //Iv werte noch
    //Ev scaling

    //Health stats
    private double health_raw;
    private double health;
    private double health_current;

    //Attack stats
    private double attack_raw;
    private double attack;
    private double attack_current;

    //Defense stats
    private double defense_raw;
    private double defense;
    private double defense_current;

    //sp.Atk stats
    private double special_attack_raw;
    private double special_attack;
    private double special_attack_current;

    //sp.Def stats
    private double special_defense_raw;
    private double special_defense;
    private double special_defense_current;

    //speed stats
    private double speed_raw;
    private double speed;
    private double speed_current;

    //Elemente zuweisung

    // Fabio ?? wofür diese Variablen

    // private int element;
    // element 1 = fire | 2 = water | 3 = grass | 4 = flight
    private double element_fire = 1;
    private double element_water = 2;
    private double element_grass = 3;
    private double element_flight = 4;
    private double element_bunny; // -,-

}
