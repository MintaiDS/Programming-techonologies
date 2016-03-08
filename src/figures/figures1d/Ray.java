package figures.figures1d;


import java.awt.*;

public class Ray extends Segment {
    public Ray() {
    }

    public Ray(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public void setP2(Point p2) {
        this.setCenter(this.getP1());
        int x = getP1().x;
        int y = getP1().y;
        int xdif = p2.x - x;
        int ydif = p2.y - y;
        while ((p2.x <= 3000 && p2.x >= 0)||(p2.y <= 3000 && p2.y >=0)){
            p2.x += xdif;
            p2.y += ydif;
        }
    }
}
