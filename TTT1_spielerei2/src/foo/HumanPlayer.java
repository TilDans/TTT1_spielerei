package foo;

import java.awt.Point;

public class HumanPlayer implements IPlayer, IMoveListener {
    private volatile Point move;
    private IInputDevice input;
    private String id;

    @Override
    public String getId() {
        return id;
    }

    public HumanPlayer(IInputDevice input, String name) {
        this.input = input;
        this.id = name;
    }

    @Override
    public void moveOccured(int row, int column) {
        move = new Point(row, column);
    }

    @Override
    public Point getMove(String situation) throws PlayerException {
        move = null;
        input.setMoveListener(this);
        while (move == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return move;
    }
}
