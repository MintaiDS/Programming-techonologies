package util;


import java.awt.*;
import java.util.ArrayList;

public class CustomMath {
    static int width = 800;
    static int height = 600;

    //calculates intersection of 2 lines(a1, a2) and (b1, b2)
    public static Point getIntersection(Point a1, Point a2, Point b1, Point b2) {

        //k1*x + c1 = y -first line
        double k1 = (a1.getY() - a2.getY())/(a1.getX() - a2.getX());
        double c1 = (a1.getY()*a2.getX() - a2.getY()*a1.getX())/(a2.getX() - a1.getX());

        //k2*x + c2 = y -second line
        double k2 = (b1.getY() - b2.getY())/(b1.getX() - b2.getX());
        if(b1.getX() - b2.getX() == 0) {
            k2 = 0;
        }
        double c2 = (b1.getY()*b2.getX() - b2.getY()*b1.getX())/(b2.getX() - b1.getX());

        System.out.println(k2);

        //intersection
        double x = (c2 - c1)/(k1 - k2);
        double y = c1 + k1*x;

        return new Point((int)x, (int)y);
    }

    public static Point getRayEnd(Point a1, Point a2) {
        Point top = getIntersection(a1, a2, new Point(0, 0), new Point(100, 0));
        Point bottom = getIntersection(a1, a2, new Point(0, height), new Point(100, height));
        Point left = getIntersection(a1, a2, new Point(0, 0), new Point(0, 100));
        Point right = getIntersection(a1, a2, new Point(width, 0), new Point(width, 100));

        System.out.println(top);
        System.out.println(bottom);
        System.out.println(left);
        System.out.println(right);

        ArrayList<Point> result = new ArrayList<>();

        if(top.getX() < width && top.getX() > 0) {
            result.add(top);
            //System.out.println(1);
        }

        if(bottom.getX() < width && bottom.getX() > 0) {
            result.add(bottom);
            //System.out.println(2);
        }

        if(left.getY() < height && left.getY() > 0) {
            result.add(left);
            //System.out.println(3);
        }

        if(right.getY() < height && right.getY() > 0) {
            result.add(right);
            ///System.out.println(4);
        }

        /*if(result.size() == 1) {
            return result.get(0);
        }*/

        if(a2.getX() > a1.getX()) {
            if(result.get(0).getX() > result.get(1).getX()) {
                return result.get(0);
            }
            return result.get(1);
        }
        else {
            if(result.get(0).getX() < result.get(1).getX()) {
                return result.get(0);
            }
            return result.get(1);
        }
    }
}
