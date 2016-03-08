package gui;

import figures.figures1d.Segment;
import gui.listeners.IListenersManager;
import gui.listeners.implementations.SegmentListenersManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainFrame extends JFrame {

    PaintPanel paintPanel;
    JPanel instrumentsPanel;

    boolean drawingPoint = false;

    boolean drawingSegment = false;
    boolean drawingRay = false;
    boolean drawingLine = false;

    boolean drawingCircle = false;
    boolean drawingEllipse = false;

    IListenersManager listenersManager;

    MouseListener currentPaintPanelMouseListener = null;
    MouseMotionListener currentPaintPanelMouseMotionListener = null;


    public JPanel createInstrumentsPanel() {
        JPanel panel = new JPanel();

        JButton point = new JButton("Point");

        JButton line = new JButton("Line");
        JButton ray = new JButton("Ray");
        JButton segmentButton = new JButton("Segment");

        JButton circle = new JButton("Circle");
        JButton ellipse = new JButton("Ellipse");


        segmentButton.addActionListener(e -> {
            if(currentPaintPanelMouseListener != null) {
                paintPanel.removeMouseListener(currentPaintPanelMouseListener);
            }
            if(currentPaintPanelMouseMotionListener != null) {
                paintPanel.removeMouseMotionListener(currentPaintPanelMouseMotionListener);
            }

            drawingSegment = true;
            listenersManager = new SegmentListenersManager();
            currentPaintPanelMouseListener = listenersManager.createMouseListener(paintPanel);
            currentPaintPanelMouseMotionListener = listenersManager.createMouseMotionListener(paintPanel);

            paintPanel.addMouseListener(currentPaintPanelMouseListener);
            paintPanel.addMouseMotionListener(currentPaintPanelMouseMotionListener);
        });


        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(point);

        panel.add(line);
        panel.add(ray);
        panel.add(segmentButton);

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

        int width = 900;
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