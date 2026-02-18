package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int deltaX = 100, deltaY = 100;

    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeDeltaX(int val) {
        this.deltaX += val;
        repaint();
    }

    public void changeDeltaY(int val) {
        this.deltaY += val;
        repaint();
    }

    public void setRectPos(int x, int y) {
        this.deltaX = x;
        this.deltaY = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(deltaX, deltaY, 200, 50);
    }
}
