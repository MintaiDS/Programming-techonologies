package figures.figures1d;


import java.awt.*;

public class Line extends Segment {
    public Line() {
    }

    public Line(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public void setP2(Point p2) {
        Point p1 = this.getP1();
        this.setCenter(p1);
        int xdif = p2.x - p1.x;
        int ydif = p2.y - p1.y;
        while ((p2.x <= 3000 && p2.x >= 0 && xdif != 0)||(p2.y <= 3000 && p2.y >=0 && ydif != 0)||
                (p1.x <= 3000 && p1.x >= 0 && xdif != 0)||(p1.y <= 3000 && p1.y >=0 && ydif != 0)){
            p2.x += xdif;
            p2.y += ydif;
            p1.x -= xdif;
            p1.y -= ydif;
        }
        this.p2 = p2;
        this.setP1(p1);
    }

    public void addPoint(Point point) {
        if(p1 == null) {
            p1 = point;
            return;
        }
        this.setP2(point);
    }
}
