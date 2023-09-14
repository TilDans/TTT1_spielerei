package foo;

import javax.swing.*;

public class JComponentTestFrame extends JFrame {
    public JComponentTestFrame(JComponent component) {
        add(component);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
