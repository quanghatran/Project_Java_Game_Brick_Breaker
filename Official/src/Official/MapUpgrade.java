package Official;


import java.awt.*;

public class MapUpgrade {
    public int map1[][];
    public int brickWidth1;
    public int brickHeight1;

    public MapUpgrade(int row, int col) {
        map1 = new int[row][col];
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                int r = (int) (Math.random() * 4 + 1);
                map1[i][j] = r;
            }
        }

        brickWidth1 = 540 / col;
        brickHeight1 = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                if (map1[i][j] > 0) {
                    if (map1[i][j] == 1) {
                    	 // 1 lan
                        g.setColor(Color.getHSBColor((float) Math.random(), .8f, .8f));
                    }
                    if (map1[i][j] == 2) {
                    	// 2 lan
                        g.setColor(Color.red);
                    }
                    if (map1[i][j] == 3) {
                    	// 3 lan
                        g.setColor(Color.white);
                    }
                    if (map1[i][j] == 4) {
                    	//4 lan
                        g.setColor(Color.green);
                    }

                    g.fillRect(j * brickWidth1 + 80, i * brickHeight1 + 50, brickWidth1, brickHeight1);

                    // this is just to show separate brick, game can still run without it
                    g.setStroke(new BasicStroke(2));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth1 + 80, i * brickHeight1 + 50, brickWidth1, brickHeight1);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map1[row][col] = value;
    }

    public void hitBrick(int row, int col) {
        map1[row][col] -= 1;
        if (map1[row][col] < 0) {
            map1[row][col] = 0;
        }
    }

}

