package figures.polygons;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class RegularPolygon extends Polygone {

    public RegularPolygon(int number) {
        this.n = number;
    }

    @Override
    public void draw(Graphics2D g) {
        if (this.getPointsNumber() == 2){
            fillArray(n);
        }
        super.draw(g);
    }

    public void fillArray(int number){
        ArrayList<Point> arr = this.getPoints();
        ArrayList<Point> res = new ArrayList<>();
        Point fPoint = arr.get(0);
        Point sPoint = arr.get(1);
        int x = sPoint.x - fPoint.x;
        int y = sPoint.y - fPoint.y;
        int x1,y1;
        double alpha = Math.PI*2./number;
        res.add(sPoint);
        for (int i = 1; i < number; ++i){
            x1 = x;
            y1 = y;
            x = (int) (Math.cos(alpha)*x1 - Math.sin(alpha)*y1);
            y = (int) (Math.cos(alpha)*y1 + Math.sin(alpha)*x1);
            res.add(new Point(x + fPoint.x ,y + fPoint.y));
        }
        setPoints(res);
        setCenter(fPoint);
    }

    @Override
    public int getEffectivePointsNumber() {
        return 2;
    }
}
