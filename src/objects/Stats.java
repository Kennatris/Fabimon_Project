package objects;

public class Stats extends Fabimon{

    //множитель multiplier stat
    public final double multiplier = 1.1;

    //IV ночь Iv werte noch
    //Ev масштабирование Ev scaling

    //Статистика здоровья Health stats
    private double health_raw;
    private double health;
    private double health_current;

    //Статистика атаки Attack stats
    private double attack_raw;
    private double attack;
    private double attack_current;

    //Статистика защиты Defense stats
    private double defense_raw;
    private double defense;
    private double defense_current;

    //sp.Atk статистика sp.Atk stats
    private double special_attack_raw;
    private double special_attack;
    private double special_attack_current;

    //статистика sp.Def sp.Def stats
    private double special_defense_raw;
    private double special_defense;
    private double special_defense_current;

    //статистика скорости speed stats
    private double speed_raw;
    private double speed;
    private double speed_current;

    //назначение элементов Elemente zuweisung

    //Фабио ?? для чего эти переменные Fabio ?? wofür diese Variablen

    //закрытый элемент int; private int element;
    //элемент 1 = огонь | 2 = вода | 3 = трава | 4 = полет element 1 = fire | 2 = water | 3 = grass | 4 = flight
    private double element_fire = 1;
    private double element_water = 2;
    private double element_grass = 3;
    private double element_flight = 4;
    private double element_bunny; // -,-

}
