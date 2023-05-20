package entity;

public class Nature {
    public final double nature[][] = {{0, 0.9, 1.1, 1, 1, 1},
                                     {0, 0.9, 1, 1.1, 1, 1},
                                     {0, 0.9, 1, 1, 1.1, 1},
                                     {0, 0.9, 1, 1, 1, 1.1},
                                     {0, 1.1, 0.9, 1, 1, 1},
                                     {0, 1, 0.9, 1.1, 1, 1},
                                     {0, 1, 0.9, 1, 1.1, 1},
                                     {0, 1, 0.9, 1, 1, 1.1},
                                     {0, 1, 1, 0.9, 1, 1.1},
                                     {0, 1, 1, 0.9, 1.1, 1},
                                     {0, 1, 1.1, 0.9, 1, 1},
                                     {0, 1.1, 1, 0.9, 1, 1},
                                     {0, 1.1, 1, 1, 0.9, 1},
                                     {0, 1, 1.1, 1, 0.9, 1},
                                     {0, 1, 1, 1.1, 0.9, 1},
                                     {0, 1, 1, 1, 0.9, 1.1},
                                     {0, 1, 1, 1, 1.1, 0.9},
                                     {0, 1, 1, 1.1, 1, 0.9},
                                     {0, 1, 1.1, 1, 1, 0.9},
                                     {0, 1.1, 1, 1, 1, 0.9}};

    public double getmultiplikator(String pNature, int baseStatIndex){
        switch(pNature){
            case "kühn": return nature[0][baseStatIndex];
            case "mäßig": return nature[1][baseStatIndex];
            case "still": return nature[2][baseStatIndex];
            case "scheu": return nature[3][baseStatIndex];
            case "solo": return nature[4][baseStatIndex];
            case "mild": return nature[5][baseStatIndex];
            case "zart": return nature[6][baseStatIndex];
            case "hastig": return nature[7][baseStatIndex];
            case "froh": return nature[8][baseStatIndex];
            case "sacht": return nature[9][baseStatIndex];
            case "pfiffig": return nature[10][baseStatIndex];
            case "hart": return nature[11][baseStatIndex];
            case "frech": return nature[12][baseStatIndex];
            case "lasch": return nature[13][baseStatIndex];
            case "hitzig": return nature[14][baseStatIndex];
            case "naiv": return nature[15][baseStatIndex];
            case "forsch": return nature[16][baseStatIndex];
            case "ruhig": return nature[17][baseStatIndex];
            case "locker": return nature[18][baseStatIndex];
            case "mutig": return nature[19][baseStatIndex];
        }
        return 0.0;
    }
    public String setNature(){
        int rand = (int)(Math.random()*20);
        switch(rand){
            case 0: return "kühn";
            case 1: return "mäßig";
            case 2: return "still";
            case 3: return "scheu";
            case 4: return "solo";
            case 5: return "mild";
            case 6: return "zart";
            case 7: return "hastig";
            case 8: return "froh";
            case 9: return "sacht";
            case 10: return "pfiffig";
            case 11: return "hart";
            case 12: return "frech";
            case 13: return "lasch";
            case 14: return "hitzig";
            case 15: return "naiv";
            case 16: return "forsch";
            case 17: return "ruhig";
            case 18: return "locker";
            case 19: return "mutig";


        }
        return"redo";
    }

}
