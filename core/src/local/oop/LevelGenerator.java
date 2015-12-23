package local.oop;

import java.util.Random;

public class LevelGenerator {

    private int[][] level;
    private int width;
    private int height;

    public LevelGenerator(int width, int height){
        this.level = generate(width, height);
    }

    /**
     * Returns matrix representing our level with integer values.
     * 0 - empty field
     * 1 - destructible block
     * 2 - indestructible block
     * Every other value represents a bonus
     * 3 - stronger bombs
     * 4 - faster character
     * 5 - more bombs ( 3 instead of 1 )
     */
    private int[][] generate(int width, int height){
        this.width = width;
        this.height = height;
        int [][] level = new int[width][height];
        int number;
        for(int i = 0; i<width ; i++){
            for(int j = 0; j<height; j++){
                if((i==0 || i==1 || i==width-1 || i==width-2) && (j==0 || j==1 || j==height-1 || j==height-2) && !((i==1 || i==width-2) && (j == 1 || j==height-2))){
                    number = 0;
                } else if (i % 2 == 1 && j % 2 == 1) {
                    number = 2;
                } else {
                    number = 1;
                }
                level[i][j] = number;
            }
        }
        boolean generated = false;
        int i = 3;
        while (!generated){
            Random r = new Random();
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            if(level[x][y]==1){
                level[x][y] = i;
                i++;
            }
            if(i==6)
                generated = true;
        }
        return level;
    }

    public int[][] getLevel(){
        return level;
    }

    public void printLevel(){
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                System.out.print(level[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int at(int width, int height){
        return level[width][height];
    }
}
