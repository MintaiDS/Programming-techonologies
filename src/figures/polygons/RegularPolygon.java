package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class RegularPolygon extends Polygon {
    public void fillArray(int number){
        ArrayList<Point> arr = this.getPoints();
        ArrayList<Point> res = new ArrayList<>();
        Point fPoint = arr.get(0);
        Point sPoint = arr.get(1);
        int dist = (int) fPoint.distance(sPoint);
        res.add(sPoint);
    }
}
