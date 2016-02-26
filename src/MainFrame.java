import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    PaintPanel paintPanel;
    JPanel instrumentsPanel;


    public JPanel createInstrumentsPanel() {
        JPanel panel = new JPanel();

        JButton line = new JButton("Line");
        JButton ray = new JButton("Ray");
        JButton segment = new JButton("Segment");

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(line);
        panel.add(ray);
        panel.add(segment);

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
        mf.setSize(new Dimension(800, 400));
        mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
}
