package foo;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameGUI extends JFrame implements IView {
    JComponent componentGame;
    JComponent componentStats;
    
    public GameGUI(JComponent componentGame, JComponent componentStats) {
        this.componentGame = componentGame;
        this.componentStats = componentStats;
        setLayout(null);
        add(componentGame, 1);
        add(componentStats, -1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void refresh() {
        repaint();
    }
}
