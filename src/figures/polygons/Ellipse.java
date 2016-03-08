package figures.polygons;


import java.awt.*;

public class Ellipse extends Rectangle {
    @Override
    public void draw(Graphics2D g) {
        g.setColor(getFillColor());
        int[] res = getCoordinates();
        g.fillOval(res[0], res[1], res[2], res[3]);
    }
}
