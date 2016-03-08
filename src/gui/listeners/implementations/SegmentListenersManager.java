package gui.listeners.implementations;


import figures.Base;
import figures.figures1d.Segment;
import gui.listeners.IListenersManager;
import util.CustomMath;
import util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class SegmentListenersManager implements IListenersManager {

    Point first = null, second = null;

    boolean firstSelected = false, secondSelected = false;

    Segment segment;


    public MouseListener createMouseListener(JPanel paintPanel) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(firstSelected && !secondSelected) {
                    second = new Point(e.getX(), e.getY());
                    secondSelected = true;

                    segment = new Segment(first, second);

                    paintPanel.repaint();
                    System.out.println("Second press");
                }
                if(!firstSelected) {
                    first = new Point(e.getX(), e.getY());
                    second = new Point(e.getX(), e.getY());
                    firstSelected = true;
                    System.out.println("Press");
                    //paintPanel.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

    public MouseMotionListener createMouseMotionListener(JPanel paintPanel) {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(firstSelected && !secondSelected) {
                    //System.out.println("Move");
                }
            }
        };
    }

    public Base provideDataForDrawing() {
        return segment;
    }
}
