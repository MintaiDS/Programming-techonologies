package figures.polygons;

import figures.Base2D;

import java.awt.*;
import java.util.ArrayList;


public class Polygon extends Base2D {
    ArrayList <Point> points;

    public Polygon() {
        this.points = new ArrayList<>();
    }
    public void addPoint(Point p){
        points.add(p);
    }
    public int getPointsNumber(){
        return points.size();
    }
    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getFillColor());
        int pointNumber = this.getPointsNumber();
        int[] xPoints = new int[pointNumber];
        int[] yPoints = new int[pointNumber];
        int number = 0;
        for (Point p: points){
            xPoints[number] = p.x;
            yPoints[number] = p.y;
            number++;
        }
        g.fill(new java.awt.Polygon(xPoints, yPoints, pointNumber));
    }

    @Override
    public void move(Point newCenter) {
        for (Point p: points){
            p.x += newCenter.x;
            p.y += newCenter.y;
        }
        this.setCenter(newCenter);
    }
}
