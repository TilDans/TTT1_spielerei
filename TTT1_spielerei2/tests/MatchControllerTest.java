import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import foo.*;

public class MatchControllerTest {
    public static void main(String[] args) {
        IModel model = new Model();
        List<IView> views = new ArrayList<>();
        IView view = new ConsoleView(model);
        TicTacToeBoardPanel view2 = new TicTacToeBoardPanel(model);
        StatusPanel stat1 = new StatusPanel(model);
        GameGUI frame1 = new GameGUI(view2, stat1);
        views.add(view);
        views.add(frame1);
//        IPlayer p1 = new NetworkPlayer("localhost");
//        IPlayer p2 = new NetworkPlayer("localhost");
        IPlayer p1 = new HumanPlayer(view2, "Peter");
        IPlayer p2 = new HumanPlayer(view2, "Michael");
        MatchController mc = new MatchController(p1, p2, model, views);
        mc.play();
    }
}
