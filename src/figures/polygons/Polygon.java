package figures.polygons;

import figures.Base2D;

import java.awt.*;
import java.util.ArrayList;


public class Polygon extends Base2D {
    ArrayList <Point> points;
    int pointNumber;

    public Polygon() {
        this.points = new ArrayList<>();
        this.pointNumber = 0;
    }
    public void addPoint(Point p){
        points.add(p);
        pointNumber++;
    }
    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public Integer getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(Integer pointNumber) {
        this.pointNumber = pointNumber;
    }

    protected void adjustCoordinates (int x, int y) {
        for (Point p: points){
            p.x += x;
            p.y += y;
        }
    }

    @Override
    public void draw(Graphics2D g) {
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
    public void move(Point newCenter, Graphics2D g) {
        Color prevColor = this.getLineColor();
        Color prevFillColor = this.getFillColor();
        this.setLineColor(new Color(255,255,255));
        this.setFillColor(new Color(255,255,255));
        this.draw(g);
        this.setLineColor(prevColor);
        this.setFillColor(prevFillColor);
        Point bufCenter = this.getCenter();
        this.adjustCoordinates(newCenter.x-bufCenter.x,newCenter.y-bufCenter.y);
        this.setCenter(newCenter);
        this.draw(g);
    }
}
