package foo;

import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class StatusPanel extends JPanel {
    IModel model;
    private double scale;
    JTextField[] textfields = new JTextField[3];
    
    public StatusPanel(IModel model) {
        this.model = model;
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,100));
        textfields[0] = new JTextField("cross Player: ");
        textfields[1] = new JTextField("circle Player: ");
        textfields[2] = new JTextField("current Player: ");
        Font testFond = new Font("Test", Font.BOLD, 20);
        for (JTextField displayField : textfields) {
            displayField.setEditable(false);
            displayField.setFont(testFond);
            displayField.setBackground(Color.CYAN);
            add(displayField);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        configureGraphicsForUsageOfUserCoordinateSystem(g2d);
    }
//    
//    private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2d) {
//        double sx = this.getWidth() / 400.0;
//        double sy = this.getHeight() / 400.0;
//        scale = Math.min(sx, sy);
////        AffineTransform af = AffineTransform.getScaleInstance(sx, sy);
//        AffineTransform af = AffineTransform.getScaleInstance(scale, scale);
//        g2d.transform(af);
//    }
}
