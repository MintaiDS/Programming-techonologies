package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Polygon{
    public Rectangle() {

    }

    protected int[] getCoordinates(){
        ArrayList<Point> arr = this.getPoints();
        int[] res = new int[4];
        Point firstPoint = arr.get(0);
        Point secondPoint = arr.get(1);
        res[0] = firstPoint.x;
        res[1] = firstPoint.y;
        res[2] = Math.abs(res[0]-secondPoint.x);
        res[3] = Math.abs(res[1]-secondPoint.y);
        return res;
    }

    @Override
    public void addPoint(Point p) {
        System.out.println(21);
        points.add(p);
        if (points.size() == 2){
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            this.setCenter(new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2));
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getFillColor());
        int[] res = this.getCoordinates();
        g.fillRect(res[0], res[1], res[2], res[3]);
    }

    public int getEffectivePointsNumber() {
        return 2;
    }
}
