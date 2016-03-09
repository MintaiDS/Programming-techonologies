package gui;

import figures.Base;
import figures.figures1d.Line;
import figures.figures1d.Ray;
import figures.figures1d.Segment;
import figures.polygons.*;
import figures.polygons.Polygone;
import figures.polygons.Rectangle;
import gui.listenerManager.FiguresListenerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

    JPanel instrumentsPanel;
    PaintPanel paintPanel;
    MouseListener currentPaintPanelMouseListener = null;


    public JPanel createInstrumentsPanel() {
        JPanel panel = new JPanel();

        JButton lineButton = new JButton("Line");
        JButton rayButton = new JButton("Ray");
        JButton segmentButton = new JButton("Segment");

        JButton polygonButton = new JButton("Polygon");
        JButton rectangleButton = new JButton("Rectangle");
        JButton rhombusButton = new JButton("Rhombus");
        JButton triangleButton = new JButton("Triangle");
        JButton regularPolygonButton = new JButton("Regular");

        JButton circleButton = new JButton("Circle");
        JButton ellipseButton = new JButton("Ellipse");

        JButton lineColorButton = new JButton("Line Color");
        JButton fillColorButton = new JButton("Fill Color");
        //JButton moveButton = new JButton("Move");

        JTextField polygonPointsNumber = new JTextField(3);
        JTextField regularPolygonPointsNumber = new JTextField(3);

        segmentButton.addActionListener(e -> setupPaintPanelMouseListener(new Segment()));

        rayButton.addActionListener(e -> setupPaintPanelMouseListener(new Ray()));

        lineButton.addActionListener(e -> setupPaintPanelMouseListener(new Line()));

        circleButton.addActionListener(e -> setupPaintPanelMouseListener(new Circle()));

        ellipseButton.addActionListener(e -> setupPaintPanelMouseListener(new Ellipse()));

        polygonButton.addActionListener(e ->
                setupPaintPanelMouseListener(new Polygone(getTextFieldIntValue(polygonPointsNumber))));

        rectangleButton.addActionListener(e -> setupPaintPanelMouseListener(new Rectangle()));

        regularPolygonButton.addActionListener(e ->
                setupPaintPanelMouseListener(new RegularPolygon(getTextFieldIntValue(regularPolygonPointsNumber))));

        rhombusButton.addActionListener(e -> setupPaintPanelMouseListener(new Rhombus()));

        triangleButton.addActionListener(e -> setupPaintPanelMouseListener(new Triangle()));

        lineColorButton.setActionCommand("LINE");
        fillColorButton.setActionCommand("FILL");
        //moveButton.setActionCommand("MOVE");
        lineColorButton.addActionListener(paintPanel);
        fillColorButton.addActionListener(paintPanel);
        //moveButton.addActionListener(paintPanel);

        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.ipady = 5;


        panel.add(segmentButton, gbc);
        gbc.gridy++;
        panel.add(rayButton, gbc);
        gbc.gridy++;
        panel.add(lineButton, gbc);
        gbc.gridy++;
        panel.add(circleButton, gbc);

        panel.add(segmentButton, gbc);
        gbc.gridy++;
        panel.add(rayButton, gbc);
        gbc.gridy++;
        panel.add(lineButton, gbc);
        gbc.gridy++;

        panel.add(circleButton, gbc);
        gbc.gridy++;
        panel.add(ellipseButton, gbc);
        gbc.gridy++;

        panel.add(polygonButton, gbc);
        gbc.gridy++;
        panel.add(polygonPointsNumber, gbc);
        gbc.gridy++;
        panel.add(rectangleButton, gbc);
        gbc.gridy++;
        panel.add(regularPolygonButton, gbc);
        gbc.gridy++;
        panel.add(regularPolygonPointsNumber, gbc);
        gbc.gridy++;
        panel.add(rhombusButton, gbc);
        gbc.gridy++;
        panel.add(triangleButton, gbc);
        gbc.gridy++;
        panel.add(lineColorButton, gbc);
        gbc.gridy++;
        panel.add(fillColorButton, gbc);
        //gbc.gridy++;
       // panel.add(moveButton, gbc);

        panel.setBackground(Color.decode("#7986CB"));
        panel.setPreferredSize(new Dimension(105, 600));

        return panel;
    }

    public void setupPaintPanelMouseListener(Base figure) {
        removeCurrentPaintPanelMouseListener();
        setNewPaintPanelMouseListener(figure);
        paintPanel.setDraw(true);
    }

    public void removeCurrentPaintPanelMouseListener() {
        if(currentPaintPanelMouseListener != null) {
            paintPanel.removeMouseListener(currentPaintPanelMouseListener);
        }
    }

    public void setNewPaintPanelMouseListener(Base figure) {
        currentPaintPanelMouseListener = (new FiguresListenerManager()).createMouseListener(paintPanel, figure);
        paintPanel.addMouseListener(currentPaintPanelMouseListener);
    }

    public int getTextFieldIntValue(JTextField textField) {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter correct points number!", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public MainFrame() {
        paintPanel = new PaintPanel();
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
        mf.setResizable(false);
        mf.setVisible(true);
    }
}