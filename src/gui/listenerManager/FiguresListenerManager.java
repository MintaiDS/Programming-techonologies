package gui.listenerManager;


import figures.Base;
import gui.PaintPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FiguresListenerManager {

    public MouseListener createMouseListener(PaintPanel paintPanel, Base figure){

        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(figure.getPointsNumber() < figure.getEffectivePointsNumber())
                    figure.addPoint(new Point(e.getX(), e.getY()));
                if(figure.getPointsNumber() == figure.getEffectivePointsNumber())
                    paintPanel.addFigure(figure);
            }
        };
    }
}
