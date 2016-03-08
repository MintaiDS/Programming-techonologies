package figures;


import java.awt.*;

public class Base {
    private Point center = null;
    private Color lineColor;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void draw(Graphics2D g) {}

    public void move(Point newCenter) {}

    protected Point diff(Point newCenter){
        Point oldCenter = this.getCenter();
        return new Point(newCenter.x - oldCenter.x, newCenter.y - oldCenter.y);
    }

    public Point location() {
        return this.getCenter();
    }

    public void addPoint(Point point) {};

    public int getEffectivePointsNumber() { return 0; };

    public int getPointsNumber() { return 0; };
}
