package figures.figures1d;


import figures.Base;

import java.awt.*;
import java.awt.geom.Line2D;

public class Segment extends Base {

    protected Point p1, p2;

    public Segment() { }

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw(Graphics2D g2) {
        g2.draw(new Line2D.Double(p1, p2));
    }
}
