package gui;

import figures.Base;
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

    private ArrayList<Base> figures = new ArrayList<>();


    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        figures.forEach(item -> item.draw(g2));
    }

    public void addFigure(Base figure) {
        figures.add(figure);
        repaint();
    }

    public PaintPanel() {
        int width = 800;
        int height = 600;
        this.setSize(new Dimension(width, height));
    }
}
