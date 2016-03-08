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

    public void move(Point newCenter, Graphics2D g) {}

    public Point location() {
        return center;
    }
}
