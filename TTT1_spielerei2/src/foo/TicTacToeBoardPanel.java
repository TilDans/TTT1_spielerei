package foo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBoardPanel extends JPanel implements IInputDevice {
    private IModel model;
    private double scale;
    private IMoveListener listener;
    

    public TicTacToeBoardPanel(IModel model) {
        this.model = model;
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(450, 450));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = (int) (e.getX() / scale / 100);
                int row = (int) (e.getY() / scale / 100);
                if (row >= 0 && row <= 2 && column >= 0 && column <= 2 && listener != null) {
                    listener.moveOccured(row, column);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        configureGraphicsForUsageOfUserCoordinateSystem(g2d);
        drawGrid(g2d);
        drawFieldStates(g2d);
    }

    private void drawFieldStates(Graphics2D g2d) {
        final int OFFSET = 5;
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                EFieldState state = model.getFieldState(row, col);
                switch (state) {
                case CROSS:
                    g2d.drawLine(col * 100 + OFFSET, row * 100 + OFFSET, col * 100 + 100 - OFFSET,
                            row * 100 + 100 - OFFSET);
                    g2d.drawLine(col * 100 + 100 - OFFSET, row * 100 + OFFSET, col * 100 + OFFSET,
                            row * 100 + 100 - OFFSET);
                    break;
                case CIRCLE:
                    g2d.drawOval(col * 100 + OFFSET, row * 100 + OFFSET, 100 - 2 * OFFSET, 100 - 2 * OFFSET);
                    break;
                default:
                    break;
                }
            }
        }
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.drawLine(100, 0, 100, 300);
        g2d.drawLine(200, 0, 200, 300);
        g2d.drawLine(0, 100, 300, 100);
        g2d.drawLine(0, 200, 300, 200);
        g2d.drawRect(0, 0, 300, 300);
    }

    private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2d) {
        double sx = this.getWidth() / 300.0;
        double sy = this.getHeight() / 300.0;
        scale = Math.min(sx, sy);
//        AffineTransform af = AffineTransform.getScaleInstance(sx, sy);
        AffineTransform af = AffineTransform.getScaleInstance(scale, scale);
        g2d.transform(af);
    }


    @Override
    public void setMoveListener(IMoveListener iml) {
        this.listener = iml;
    }
}
