package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Circle extends Ellipse {
    @Override
    protected int[] getCoordinates() {
        int[] res = new int[4];
        ArrayList<Point> arr = this.getPoints();
        Point fPoint = arr.get(0);
        Point sPoint = arr.get(1);
        int dist = (int) fPoint.distance(sPoint);
        res[0] = fPoint.x - dist;
        res[1] = fPoint.y - dist;
        res[2] = 2*dist;
        res[3] = 2*dist;
        return res;
    }
}
