package gui;

import figures.figures1d.Segment;
import gui.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class PaintPanel extends JPanel {

    MainFrame mainFrame;

    int width = 800;
    int height = 600;


    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if(mainFrame.drawingSegment) {
            ArrayList<Point> points = mainFrame.listenersManager.provideDataForDrawing();
            g2.draw(new Line2D.Double(points.get(0), points.get(1)));
        }
    }


    public PaintPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setSize(new Dimension(width, height));
    }
}
