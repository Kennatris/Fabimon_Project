package tile;

import main.GameHandler;
import main.ImageHandler;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class TileManager {

    GameHandler gameH;
    public Tile[] tile;
    ImageHandler imageH;
    public int mapTileNum[] [];

    public TileManager(GameHandler gameH, String map) {

        System.out.println(map);

        this.gameH = gameH;

        tile = new Tile[50];
        imageH = new ImageHandler();

        mapTileNum = new int [gameH.worldColumns] [gameH.worldRows];

        getTileImage();
        loadMap(map);
    }

    public void getTileImage() {

        // LABEL
        setup(0, "main","Fabimon_Label","png",343, 110,false);



        // empty fill Space to skip
        setup(1, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(2, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(3, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(4, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(5, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(6, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(7, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(8, "tiles","PLACEHOLDER","png", gameH.tileSize, gameH.tileSize,false);
        setup(9, "NPC/Reaktionen","Ausrufezeichen","png", gameH.tileSize, gameH.tileSize,false);

        // PLACEHOLDER


        //Tiles
        setup(10, "tiles","l0_grass1","png", gameH.tileSize, gameH.tileSize,false);
        setup(11, "tiles","sprite_ground_mid0","png", gameH.tileSize, gameH.tileSize,false);
        setup(12, "tiles","grass_flowers","png", gameH.tileSize, gameH.tileSize,true);
        setup(13, "tiles","l0_water_middel_part1","png", gameH.tileSize, gameH.tileSize,true);
        setup(14, "tiles","l0_strand1","png", gameH.tileSize, gameH.tileSize,false);
        setup(15, "tiles","wood","png",gameH.tileSize, gameH.tileSize, false);
        setup(16, "tiles","stone","png",gameH.tileSize, gameH.tileSize, false);
        setup(29, "tiles","water_top_mid1","png",gameH.tileSize, gameH.tileSize, true);
        setup(30, "tiles","water_corner_left_top1","png",gameH.tileSize, gameH.tileSize, true);
        setup(31, "tiles","water_corner_right_top1","png",gameH.tileSize, gameH.tileSize, true);
        setup(32, "tiles","water_left_mid1","png",gameH.tileSize, gameH.tileSize, true);
        setup(33, "tiles","wasser_strand_übergang1","png",gameH.tileSize, gameH.tileSize, true);
        setup(34, "tiles","water_corners_right_bottom1","png",gameH.tileSize, gameH.tileSize, true);
        setup(35, "tiles","water_right_mid1","png",gameH.tileSize, gameH.tileSize, true);
        setup(36, "tiles","water_corner_left_bottom1","png",gameH.tileSize, gameH.tileSize, true);
        setup(38, "tiles","stone","png",gameH.tileSize, gameH.tileSize, false);


        //Main Buttons
        setup(17, "Buttons/MainButtons","Fight","png",96, 96,false);
        setup(18, "Buttons/MainButtons","FightS","png",343, 110,false);
        setup(19, "Buttons/MainButtons","Bag","png",343, 110,false);
        setup(20, "Buttons/MainButtons","BagS","png",343, 110,false);
        setup(21, "Buttons/MainButtons","Fabimon","png",343, 110,false);
        setup(22, "Buttons/MainButtons","FabimonS","png",343, 110,false);
        setup(23, "Buttons/MainButtons","Run","png",343, 110,false);
        setup(24, "Buttons/MainButtons","RunS","png",343, 110,false);


        //Textfields
        setup(25, "Textfields","Textfield_1","png", gameH.tileSize, gameH.tileSize,false);

        //Fabimon Info
        setup(26, "battleInfo","enemy_fabimon","png", gameH.tileSize, gameH.tileSize,false);
        setup(27, "battleInfo","own_fabimon","png", gameH.tileSize, gameH.tileSize,false);

        // null Button
        setup(28, "Buttons/AttackButtons","null","png", gameH.tileSize, gameH.tileSize,false);
        
    }

    public void setup(int index, String imageLocation, String imageName, String imageDataTyp, int refactoredWidth, int refactoredHeight, boolean collision) {

        tile [index] = new Tile();
        imageH.ImageInitializer(index, imageLocation, imageName, imageDataTyp, refactoredWidth, refactoredHeight);
        tile [index].image = imageH.image[index];
        tile [index].collision = collision;

    }

    public void loadMap (String fileName) {

        try {

            // https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/

            String fileLocation = "res/maps/" + fileName + ".txt";

            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);
            //InputStream mapFile = getClass().getResourceAsStream(fileLocation);

            System.out.println("mapfile: " + fileLocation);

            int col = 0;
            int row = 0;

            while(col < gameH.worldColumns && row < gameH.worldRows) {

                String line = br.readLine();

                while(col < gameH.worldColumns) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gameH.worldColumns) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        }catch(Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gameH.worldColumns && worldRow < gameH.worldRows) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gameH.tileSize;
            int worldY = worldRow * gameH.tileSize;
            int screenX = worldX - gameH.player.worldX + gameH.player.screenX;
            int screenY = worldY - gameH.player.worldY + gameH.player.screenY;

            if(worldX + gameH.tileSize > gameH.player.worldX - gameH.player.screenX &&
                worldX - gameH.tileSize < gameH.player.worldX + gameH.player.screenX &&
                worldY + gameH.tileSize > gameH.player.worldY - gameH.player.screenY &&
                worldY - gameH.tileSize < gameH.player.worldY + gameH.player.screenY) {


                g2.drawImage(tile[tileNum].image, screenX, screenY, null);

            }


            worldCol++;

            if(worldCol == gameH.worldColumns) {

                worldCol = 0;
                worldRow++;

            }
        }

    }
}