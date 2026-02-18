package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int deltaX, deltaY = 0;

    public GamePanel() {

        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeDeltaX(int val) {
        this.deltaX += val;
    }

    public void changeDeltaY(int val) {
        this.deltaY += val;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100 + deltaX, 100 + deltaY, 200, 50);
    }
}
