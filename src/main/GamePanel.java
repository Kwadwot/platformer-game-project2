package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
//    private int frames = 0;
//    private long lastCheck = 0;
    private Color color = new Color(90, 83, 25);
    private Random random;

    // Temp for effects test
    private ArrayList<MyRect> rects = new ArrayList<>();

    public GamePanel() {

        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeDeltaX(int val) {
        this.xDelta += val;
    }

    public void changeDeltaY(int val) {
        this.yDelta += val;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void spawnRect(int x, int y) {
        rects.add(new MyRect(x,y));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Temp for effects test
        for (MyRect rect: rects) {
            rect.updateRect();
            rect.draw(g);
        }

        updateRectangle();

        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

//        repaint();
    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRandColor();
        }
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRandColor();
        }
    }

    private Color getRandColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }

    public class MyRect {
        int x, y, w, h;
        int xDir = 1, yDir = 1;
        Color color;

        public MyRect(int x, int y) {
            this.x = x;
            this.y = y;
            w = random.nextInt(50);
            h = w;
            color = newColor();
        }

        public void updateRect(){
            this.x += xDir;
            this.y += yDir;

            if ((x + w) > 400 || (x + w) < 0) {
                xDir *= -1;
                color = newColor();
            }
            if ((y + h) > 400 || (y + h) < 0) {
                yDir *= -1;
                color = newColor();
            }
        }

        private Color newColor() {
            return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x,y,w,h);
        }
    }
}
