package local.oop.model.arena;

import local.oop.model.PlayerPosition;

import java.util.*;

public class Level {

    BlockType[][] enumLevel;
    private int[][] level;
    private int width;
    private int height;


    public Level(int width, int height) {
        this.level = generate(width, height);
        generateEnumLevel();
    }




    public BlockType[][] getEnumLevel() {
        return enumLevel;
    }

    public void generateEnumLevel() {

        enumLevel = new BlockType[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                switch (level[i][j]) {
                    case 0:
                        enumLevel[i][j] = BlockType.BACKGROUND;
                        break;
                    case 1:
                        enumLevel[i][j] = BlockType.EXPLODABLE;
                        break;
                    case 2:
                        enumLevel[i][j] = BlockType.SOLID;
                        break;
                    case 3:
                        enumLevel[i][j] = BlockType.POWER_UP;
                        break;
                    case 4:
                        enumLevel[i][j] = BlockType.SPEED_UP;
                        break;
                    case 5:
                        enumLevel[i][j] = BlockType.EXTRA_BOMB;
                        break;
                }
            }
        }
    }

    public Map<BlockPosition, BlockType> getGeneratedLevel() {
        Map<BlockPosition, BlockType> result = new HashMap<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                switch (level[i][j]) {
                    case 0:
                        result.put(new BlockPosition(i, j), BlockType.BACKGROUND);
                        break;
                    case 1:
                        result.put(new BlockPosition(i, j), BlockType.EXPLODABLE);
                        break;
                    case 2:
                        result.put(new BlockPosition(i, j), BlockType.SOLID);
                        break;
                    case 3:
                        result.put(new BlockPosition(i, j), BlockType.POWER_UP);
                        break;
                    case 4:
                        result.put(new BlockPosition(i, j), BlockType.SPEED_UP);
                        break;
                    case 5:
                        result.put(new BlockPosition(i, j), BlockType.EXTRA_BOMB);
                        break;
                }
            }
        }
        return result;
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
    private int[][] generate(int width, int height) {
        this.width = width;
        this.height = height;
        int[][] level = new int[width][height];
        int number;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((i == 0 || i == 1 || i == width - 1 || i == width - 2) && (j == 0 || j == 1 || j == height - 1 || j == height - 2) && !((i == 1 || i == width - 2) && (j == 1 || j == height - 2))) {
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
        while (!generated) {
            Random r = new Random();
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            if (level[x][y] == 1) {
                level[x][y] = i;
                i++;
            }
            if (i == 6)
                generated = true;
        }

        return level;
    }

    public int[][] getRawLevel() {
        return level;
    }


    public void printLevel() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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

    public int at(int width, int height) {
        return level[width][height];
    }
}
