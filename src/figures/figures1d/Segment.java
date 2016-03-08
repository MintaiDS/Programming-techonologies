package figures.figures1d;


import figures.Base;

import java.awt.*;
import java.awt.geom.Line2D;

public class Segment extends Base {

    private Point p1, p2;

    public Segment() { }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        Point cent = new Point();
        cent.x = Math.abs(p2.x+p1.x)/2;
        cent.y = Math.abs(p2.y+p1.y)/2;
        this.setCenter(cent);
    }

    public Segment(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
    }

    @Override
    public void move(Point newCenter) {
        Point p = this.diff(newCenter);
        this.setP1(new Point(p1.x+p.x, p1.y+p.y));
        this.setP2(new Point(p2.x+p.x, p2.y+p.y));
    }

    public void draw(Graphics2D g) {
        g.setColor(this.getLineColor());
        g.draw(new Line2D.Double(p1, p2));
    }
}
