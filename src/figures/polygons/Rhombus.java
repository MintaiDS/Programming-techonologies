package figures.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Rhombus extends Rectangle{

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getFillColor());
        int[] resx = new int[4];
        int[] resy = new int[4];
        if (this.getPointsNumber() == 2) {
            ArrayList<Point> arr = this.getPoints();
            ArrayList<Point> newArr = new ArrayList<>();
            Point firstPoint = arr.get(0);
            Point secondPoint = arr.get(1);
            resx[0] = (firstPoint.x + secondPoint.x) / 2;
            resy[0] = firstPoint.y;
            newArr.add(new Point(resx[0], resy[0]));
            resx[1] = firstPoint.x;
            resy[1] = (firstPoint.y + secondPoint.y) / 2;
            newArr.add(new Point(resx[1], resy[1]));
            resx[2] = (firstPoint.x + secondPoint.x) / 2;
            resy[2] = secondPoint.y;
            newArr.add(new Point(resx[2], resy[2]));
            resx[3] = secondPoint.x;
            resy[3] = (firstPoint.y + secondPoint.y) / 2;
            newArr.add(new Point(resx[3], resy[3]));
            this.setPoints(newArr);
            setCenter(new Point((resx[0]+resx[2])/2,(resy[0]+resy[2])/2));
    }
        else {
            ArrayList<Point> arr = this.getPoints();
            int kol = 0;
            for (Point p: arr){
                resx[kol] = p.x;
                resy[kol] = p.y;
                kol++;
            }
        }
        g.fillPolygon(resx, resy, 4);
        g.setColor(this.getLineColor());
        g.drawPolygon(resx, resy, 4);
    }
}
