package figures.polygons;


import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Rectangle {
    @Override
    public void draw(Graphics2D g) {
        g.setColor(getFillColor());
        int[] res = getCoordinates();
        g.fillOval(res[0], res[1], res[2], res[3]);
        g.setColor(getLineColor());
        g.drawOval(res[0], res[1], res[2], res[3]);
    }
    public Ellipse2D getEllipse(){
        int[] points = getCoordinates();
        return new Ellipse2D.Double(points[0], points[1], points[2], points[3]);
    }
}
