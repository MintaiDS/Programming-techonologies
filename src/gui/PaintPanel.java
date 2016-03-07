package gui;

import figures.figures1d.Segment;
import gui.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;

public class PaintPanel extends JPanel {

    MainFrame mainFrameInstance;

    int width = 800;
    int height = 600;


    public PaintPanel(MainFrame mainFrameInstance) {
        this.mainFrameInstance = mainFrameInstance;

        this.setSize(new Dimension(width, height));
    }


    protected void paintComponent(Graphics g) {
        //?super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Segment s1 = new Segment(new Point(100, 100), new Point(400, 400));
        s1.draw(g2);

    }
}
