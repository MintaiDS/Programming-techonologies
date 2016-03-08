package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Polygon{
    protected final int pointNumber = 2;
    public Rectangle() {

    }
    protected int[] getCoordinates(){
        ArrayList<Point> arr = this.getPoints();
        int[] res = new int[4];
        Point firstPoint = arr.get(0);
        Point secondPoint = arr.get(1);
        res[0] = firstPoint.x;
        res[1] = secondPoint.y;
        res[2] = Math.abs(res[0]-secondPoint.x);
        res[3] = Math.abs(res[1]-secondPoint.y);
        return res;
    }
    @Override
    public void draw(Graphics2D g) {
       int[] res = this.getCoordinates();
        g.fillRect(res[0], res[1], res[2], res[3]);
    }
}
