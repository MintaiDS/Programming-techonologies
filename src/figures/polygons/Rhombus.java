package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Rhombus extends Rectangle{
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getFillColor());
        ArrayList<Point> arr = this.getPoints();
        int[] resx = new int[4];
        int[] resy = new int[4];
        Point firstPoint = arr.get(0);
        Point secondPoint = arr.get(1);
        resx[0] = (firstPoint.x + secondPoint.x)/2;
        resy[0] = firstPoint.y;
        resx[1] = firstPoint.x;
        resy[1] = (firstPoint.y + secondPoint.y)/2;
        resx[2] = (firstPoint.x + secondPoint.x)/2;
        resy[2] = secondPoint.y;
        resx[3] = secondPoint.x;
        resy[3] = (firstPoint.y + secondPoint.y)/2;
        g.fillPolygon(resx, resy, 4);
    }
}
