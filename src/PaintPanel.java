import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PaintPanel extends JPanel {

    MainFrame mainFrameInstance;

    int width = 600;
    int height = 400;


    public PaintPanel(MainFrame mainFrameInstance) {
        this.mainFrameInstance = mainFrameInstance;

        this.setSize(new Dimension(width, height));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
