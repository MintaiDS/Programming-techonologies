package gui.listenerManager;


import figures.Base;
import figures.Base2D;
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
                if (paintPanel.isDraw() &&  !paintPanel.isMove()) {
                    if (figure.getPointsNumber() < figure.getEffectivePointsNumber())
                        figure.addPoint(new Point(e.getX(), e.getY()));
                    if (figure.getPointsNumber() == figure.getEffectivePointsNumber()) {
                        figure.setLineColor(paintPanel.getLineColor());
                        if (Base2D.class.isAssignableFrom(figure.getClass())) {
                            ((Base2D) figure).setFillColor(paintPanel.getFillColor());
                        }
                        paintPanel.addFigure(figure);
                        paintPanel.setDraw(false);
                    }
                }
            }
        };
    }
    public MouseListener createMoveListener(PaintPanel paintPanel){
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!paintPanel.isDraw()) {
                    Point p = e.getPoint();
                    if (!paintPanel.isMove()) {
                        Base f = paintPanel.findFigure(p);
                        if (f != null) {
                            paintPanel.setMove(true);
                            paintPanel.setMoveFigure(f);
                        }
                    } else {
                        Base moveFigure = paintPanel.getMoveFigure();
                        moveFigure.move(p);
                        paintPanel.addFigure(moveFigure);
                        paintPanel.setMove(false);
                    }
                }
            }
        };
    }
}
