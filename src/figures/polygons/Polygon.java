package figures.polygons;

import figures.Base2D;

import java.awt.*;
import java.util.ArrayList;


public class Polygon extends Base2D {
    ArrayList <Point> points;
    int n;

    public Polygon() { this.points = new ArrayList<>(); }

    public Polygon(int n) {
        this.n = n;
        this.points = new ArrayList<>();
    }

    public void addPoint(Point p){
        System.out.println(111);
        if (points.size() == 0)
            this.setCenter(p);
        points.add(p);
    }

    public int getPointsNumber(){
        return points.size();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.setCenter(points.get(0));
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
        Point pt = this.diff(newCenter);
        for (Point p: points){
            p.x += pt.x;
            p.y += pt.y;
        }
        this.setCenter(newCenter);
    }

    public int getEffectivePointsNumber() {
        return n;
    }
}
