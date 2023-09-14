package foo;

public class Model implements IModel {
    private EFieldState[][] states = new EFieldState[3][3];
    private volatile boolean won;
    private IPlayer currentPlayer;
    private int moveCount;
    private IPlayer player1;
    private IPlayer player2;

    

    @Override
    public int getMoveCount() {
        return moveCount;
    }

    public Model() {
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                states[i][j] = EFieldState.EMPTY;
            }
        }
    }

    @Override
    public EFieldState getFieldState(int row, int column) {
        return states[row][column];
    }

    @Override
    public void setFieldState(int row, int column, EFieldState state) {
        states[row][column] = state;
        moveCount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                sb.append(states[i][j].getSYMBOL());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String toServerString() {
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                sb.append(states[i][j].getSYMBOL());
            }
        }
        sb.append('\n');
        return sb.toString();
    }

    @Override
    public boolean getWon() {
        return won;
    }

    @Override
    public void setWon() {
        won = true;
    }

    @Override
    public void setPlayer(IPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    @Override
    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }
    
    
}
