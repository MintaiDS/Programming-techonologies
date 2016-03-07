package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    PaintPanel paintPanel;
    JPanel instrumentsPanel;


    public JPanel createInstrumentsPanel() {
        JPanel panel = new JPanel();

        JButton point = new JButton("Point");

        JButton line = new JButton("Line");
        JButton ray = new JButton("Ray");
        JButton segment = new JButton("Segment");

        JButton circle = new JButton("Circle");
        JButton ellipse = new JButton("Ellipse");

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(point);

        panel.add(line);
        panel.add(ray);
        panel.add(segment);

        panel.add(circle);
        panel.add(ellipse);

        panel.setBackground(Color.decode("#7986CB"));

        return panel;
    }


    public MainFrame() {
        paintPanel = new PaintPanel(this);
        instrumentsPanel = createInstrumentsPanel();

        this.setLayout(new BorderLayout());
        this.add(paintPanel, BorderLayout.CENTER);
        this.add(instrumentsPanel, BorderLayout.EAST);
    }


    public static void main(String[] args) {
        MainFrame mf = new MainFrame();

        int width = 1000;
        int height = 600;
        mf.setSize(new Dimension(width, height));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        mf.setLocation((screenWidth - width)/2, (screenHeight - height)/2);

        mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
}
