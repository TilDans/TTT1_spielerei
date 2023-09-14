import javax.swing.JComponent;
import javax.swing.JTable;

import foo.*;

public class ComponentTest {
    public static void main(String[] args) {
        IModel model = new Model();
        model.setFieldState(2, 1, EFieldState.CROSS);
        model.setFieldState(0, 2, EFieldState.CIRCLE);
        System.out.println(model);
        TicTacToeBoardPanel comp = new TicTacToeBoardPanel(model);
        comp.setMoveListener(new IMoveListener() {
            @Override
            public void moveOccured(int row, int column) {
                System.out.println(row + " " + column);
            }
        });
        JComponentTestFrame frame = new JComponentTestFrame(comp);
    }
}
