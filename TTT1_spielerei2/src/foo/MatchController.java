package foo;

import java.awt.Point;
import java.util.List;

public class MatchController {
    private IPlayer player1;
    private IPlayer player2;
    private IModel model;
    private List<IView> views;

    public MatchController(IPlayer player1, IPlayer player2, IModel model, List<IView> views) {
        this.player1 = player1;
        this.player2 = player2;
        this.model = model;
        this.views = views;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            if (!model.getWon()) {
                boolean even = i % 2 == 0;
                IPlayer currentPlayer = even ? player1 : player2;
                model.setPlayer(currentPlayer);
                try {
                    String situation = model.toServerString();
                    Point move = currentPlayer.getMove(situation);
                    System.out.println(move);
                    EFieldState nextState = even ? EFieldState.CROSS : EFieldState.CIRCLE;
                    model.setFieldState(move.x, move.y, nextState);
                    isWon(currentPlayer);
                    for (IView view : views) {
                        view.refresh();
                    }
                } catch (PlayerException e) {
                    // TODO popup, neue IP, neuer Network Player, i--   | --> mit neuem Server weiterspielen
                    e.printStackTrace();
                    System.exit(0);
                } 
            }
        }
        if (!model.getWon()) {
            System.out.println("Kein Gewinner");
        } else {
            System.out.println(model.getCurrentPlayer().getId() + " won");
        }
    }

    private void isWon(IPlayer currentPlayer) {
        String situation = model.toString();
        boolean diagonalLtoRDown = situation.charAt(0) != '_' && (situation.charAt(0) == situation.charAt(5)) && (situation.charAt(0) == situation.charAt(10));
//        System.out.println(situation.charAt(0) + " " + situation.charAt(5) + " " + situation.charAt(10));
        boolean diagonalLtoRUp = situation.charAt(8) != '_' &&(situation.charAt(8) == situation.charAt(5)) && (situation.charAt(8) == situation.charAt(2));
//        System.out.println(situation.charAt(8) + " " + situation.charAt(5) + " " + situation.charAt(2));
        boolean straightLines = false;
        for (int i = 0; i < 3; i++) {
            if (situation.charAt(i) != '_' && situation.charAt(i) == situation.charAt(i + 4) && situation.charAt(i) == situation.charAt(i + 8)) {
                straightLines = true;
            }
        }
        if (situation.contains("xxx") | situation.contains("ooo") | diagonalLtoRDown | diagonalLtoRUp | straightLines) {
            model.setWon();
        }
    }
}
