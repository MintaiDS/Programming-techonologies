package gui;

import figures.Base;
import figures.figures1d.Segment;
import figures.polygons.*;
import figures.polygons.Rectangle;
import gui.MainFrame;
import gui.listenerManager.FiguresListenerManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements ActionListener{

    private ArrayList<Base> figures = new ArrayList<>();
    private Color lineColor = new Color(0, 0, 0);
    private Color fillColor = new Color(0, 0, 0);
    private boolean isMove = false;
    private boolean isDraw = false;
    private MouseListener myListener = new FiguresListenerManager().createMoveListener(this);

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    private Base moveFigure = null;

    public Base getMoveFigure() {
        return moveFigure;
    }

    public void setMoveFigure(Base moveFigure) {
        this.moveFigure = moveFigure;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, 1000, 1000);
        Graphics2D g2 = (Graphics2D) g;
        figures.forEach(item -> item.draw(g2));
    }

    public void addFigure(Base figure) {
        figures.add(figure);
        repaint();
    }
    public Base findFigure(Point p) {
        for (int i = figures.size()-1; i >= 0; i--){
            Base f = figures.get(i);
            if (Segment.class.isAssignableFrom(f.getClass())){
                Line2D line = ((Segment)f).getFigure();
                if (line.intersects(p.x, p.y, 3, 3)){
                    figures.remove(i);
                    return f;
                }
            } else {
                if (Ellipse.class.isAssignableFrom(f.getClass())){
                    Ellipse2D ellipse = ((Ellipse)f).getEllipse();
                    if (ellipse.contains(p.x, p.y)){
                        figures.remove(i);
                        return f;
                    }
                } else {
                    if (Rhombus.class.isAssignableFrom(f.getClass())) {
                        Polygon pol = ((Polygone) f).getFigure();
                        if (pol.contains(p.x, p.y)) {
                            figures.remove(i);
                            return f;
                        }
                    } else {
                        if (figures.polygons.Rectangle.class.isAssignableFrom(f.getClass())) {
                            Rectangle2D rect = ((figures.polygons.Rectangle) f).getRect();
                            if (rect.contains(p.x, p.y)) {
                                figures.remove(i);
                                return f;
                            }
                        } else {
                            if (Polygone.class.isAssignableFrom(f.getClass())) {
                                Polygon pol = ((Polygone) f).getFigure();
                                if (pol.contains(p.x, p.y)) {
                                    figures.remove(i);
                                    return f;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public PaintPanel() {
        int width = 800;
        int height = 600;
        this.setSize(new Dimension(width, height));
        this.addMouseListener(myListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Color bufColor;
        switch (command) {
            case "LINE":
                bufColor = JColorChooser.showDialog(this, "Line Color", lineColor);
                if (bufColor != null) {
                    setLineColor(bufColor);
                    repaint();
                }
                break;
            case "FILL":
                bufColor = JColorChooser.showDialog(this, "Fill Color", fillColor);
                if (bufColor != null) {
                    setFillColor(bufColor);
                    repaint();
                }
        }
    }
}
